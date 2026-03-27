<%@ page import="dao.AccountDAO" %>
<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: Windows 10
  Date: 16-12-2023
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href='login-register/css/register.css' rel='stylesheet'>
    <!-- Boxicons CSS -->
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<section class="container forms">
    <!-- Signup Form -->
    <div class="form signup">
        <div class="form-content">
            <header>Signup</header>
            <form action="signup" method="post">
                <% String error = (String) session.getAttribute("errorRegis"); %>
                <% if(error != null){ %>
                <p class="text-danger"><%= error %></p>
                <% } %>
                <% String error1 = (String) session.getAttribute("errorNumber"); %>
                <% if(error1 != null){ %>
                <p class="text-danger"><%= error1 %></p>
                <% } %>
                <div class="field input-field">
                    <input name="email" type="email" placeholder="Email" class="input">
                </div>
                <div class="field input-field">
                    <input name="username" type="name" placeholder="Tên người dùng" class="input">
                </div>
                <div class="field input-field">
                    <input name="surname" type="name" placeholder="Họ" class="input">
                </div>
                <div class="field input-field">
                    <input name="lastname" type="name" placeholder="Tên" class="input">
                </div>
                <div class="field input-field">
                    <input name="phone" type="tel" placeholder="Số điện thoại" class="input">
                </div>
                <div class="field input-field">
                    <input name="pass" type="password" placeholder="Nhập mật khẩu" class="password">
                    <i class='bx bx-hide eye-icon'></i>
                </div>
                <div class="field input-field">
                    <input name="rePass" type="password" placeholder="Nhập lại mật khẩu" class="password">
                </div>
                <div class="field button-field">
                    <button>Đăng ký</button>
                </div>
            </form>
            <div class="form-link">
                <span>Đã có tài khoản? <a href="login" class="<%-- link login-link --%>">Đăng nhập</a></span>
            </div>
        </div>
    </div>
</section>
<!-- JavaScript -->
<script src="login-register/js/signup_signin.js"></script>

</body>
</html>

