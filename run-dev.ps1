$ErrorActionPreference = 'Stop'

$projectRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $projectRoot

$javaHome = 'C:\Program Files\Eclipse Adoptium\jdk-17.0.18.8-hotspot'
$mvnCmd = Join-Path $projectRoot '.tools\apache-maven-3.9.9\bin\mvn.cmd'
$appUrl = 'http://localhost:8080/'

if (-not (Test-Path $mvnCmd)) {
    throw "Cannot find Maven at $mvnCmd"
}

$env:JAVA_HOME = $javaHome
$env:Path = "$javaHome\bin;$env:Path"

$listening = Get-NetTCPConnection -LocalPort 8080 -State Listen -ErrorAction SilentlyContinue | Select-Object -First 1
if ($listening) {
    Stop-Process -Id $listening.OwningProcess -Force
}

# Open browser automatically when the app becomes reachable.
Get-Job -Name OpenBrowserWhenReady -ErrorAction SilentlyContinue | Remove-Job -Force
Start-Job -Name OpenBrowserWhenReady -ArgumentList $appUrl -ScriptBlock {
    param($url)
    for ($i = 0; $i -lt 60; $i++) {
        try {
            $resp = Invoke-WebRequest -Uri $url -UseBasicParsing -TimeoutSec 2
            if ($resp.StatusCode -ge 200 -and $resp.StatusCode -lt 500) {
                Start-Process $url
                break
            }
        } catch {
            Start-Sleep -Milliseconds 500
        }
    }
} | Out-Null

& $mvnCmd "-DskipTests" "-Dfile.encoding=UTF-8" "-Dproject.build.sourceEncoding=UTF-8" "-Dmaven.compiler.encoding=UTF-8" "-Djetty.http.port=8080" org.eclipse.jetty:jetty-maven-plugin:9.4.53.v20231009:run
