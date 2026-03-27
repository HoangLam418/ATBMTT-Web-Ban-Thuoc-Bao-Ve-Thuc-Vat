# ATBMTT - Web Bán Thuốc Bảo Vệ Thực Vật

Hướng dẫn chạy dự án Java Web (Maven + Jetty) trên máy local.

## 1. Yêu cầu môi trường

- Windows (dự án hiện đang có script PowerShell)
- JDK 17
- MySQL 8.x (hoặc MySQL tương thích)
- VS Code (khuyến nghị để chạy bằng task có sẵn)

Lưu ý:
- Dự án dùng Maven đã đóng gói trong repo tại `.tools/apache-maven-3.9.9`.
- Script `run-dev.ps1` đang gán cứng đường dẫn JAVA_HOME mặc định:
  - `C:\Program Files\Eclipse Adoptium\jdk-17.0.18.8-hotspot`
- Nếu máy bạn dùng JDK ở đường dẫn khác, hãy sửa biến `$javaHome` trong `run-dev.ps1`.

## 2. Cấu hình Database

Thông tin mặc định trong `src/main/resources/DB.properties`:

- db.host=127.0.0.1
- db.port=3306
- db.username=root
- db.password=
- db.name=test

Cần đảm bảo:
- Đã tạo database `test` (hoặc đổi tên DB và cập nhật lại file properties)
- Tài khoản MySQL có quyền truy cập DB
- Đã import schema/data trước khi chạy (nếu bạn có file SQL riêng)

## 3. Chạy nhanh bằng VS Code Task (khuyến nghị)

1. Mở project trong VS Code.
2. Chạy task `Run Web (Jetty)`.
3. Truy cập: http://localhost:8080/

Dừng server:
- Chạy task `Stop Web (8080)`.

## 4. Chạy bằng PowerShell

Tại thư mục gốc project, chạy:

```powershell
powershell -ExecutionPolicy Bypass -File .\run-dev.ps1
```

Script sẽ:
- Đặt JAVA_HOME
- Kill process đang chiếm cổng 8080 (nếu có)
- Chạy Jetty Maven Plugin trên cổng 8080
- Tự động mở trình duyệt khi app sẵn sàng

Dừng server:
- Nhấn `Ctrl + C` trong terminal đang chạy
- Hoặc dùng task `Stop Web (8080)`

## 5. Chạy bằng Maven (không qua script)

Nếu bạn đã tự cài Maven và JAVA_HOME đúng:

```powershell
mvn -DskipTests -Dfile.encoding=UTF-8 -Dproject.build.sourceEncoding=UTF-8 -Dmaven.compiler.encoding=UTF-8 -Djetty.http.port=8080 org.eclipse.jetty:jetty-maven-plugin:9.4.53.v20231009:run
```

## 6. Sự cố thường gặp

1. Lỗi không tìm thấy Maven trong `.tools`
- Kiểm tra file tồn tại: `.tools\apache-maven-3.9.9\bin\mvn.cmd`

2. Lỗi sai đường dẫn JDK
- Sửa `$javaHome` trong `run-dev.ps1` cho đúng với máy bạn.

3. Lỗi kết nối MySQL
- Kiểm tra MySQL đã chạy
- Kiểm tra DB/username/password trong `DB.properties`
- Kiểm tra đã tạo DB và import bảng dữ liệu cần thiết

4. Cổng 8080 đã bị chiếm
- Dùng task `Stop Web (8080)` rồi chạy lại.

## 7. Cấu trúc chính

- `src/main/java`: Mã nguồn Java (controller, dao, service, ...)
- `src/main/webapp`: JSP, static assets, cấu hình web
- `src/main/resources/DB.properties`: Cấu hình DB
- `run-dev.ps1`: Script chạy local nhanh
- `pom.xml`: Cấu hình Maven và dependencies
