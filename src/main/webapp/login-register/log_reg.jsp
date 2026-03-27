<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
<!--    <meta name="description" content="Ogani Template">-->
<!--    <meta name="keywords" content="Ogani, unica, creative, html">-->
<!--    <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
<!--    <meta http-equiv="X-UA-Compatible" content="ie=edge">-->
<!--    <title>Vườn phố</title>-->

<!--    &lt;!&ndash; Google Font &ndash;&gt;-->
<!--    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">-->

<!--    &lt;!&ndash; Css Styles &ndash;&gt;-->
<!--    <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">-->
<!--    <link rel="stylesheet" href="assets/css/font-awesome.min.css" type="text/css">-->
<!--    <link rel="stylesheet" href="assets/css/elegant-icons.css" type="text/css">-->
<!--    <link rel="stylesheet" href="assets/css/nice-select.css" type="text/css">-->
<!--    <link rel="stylesheet" href="assets/css/jquery-ui.min.css" type="text/css">-->
<!--    <link rel="stylesheet" href="assets/css/owl.carousel.min.css" type="text/css">-->
<!--    <link rel="stylesheet" href="assets/css/slicknav.min.css" type="text/css">-->
<!--    <link rel="stylesheet" href="assets/css/style.css" type="text/css">-->
<!--    <meta charset="UTF-8">-->
    <title>Login/Regis</title>
    <link rel="stylesheet" href="assets/css/Log_Regis.css">
</head>
<body>
    <!--Fo-->
    <%--<div class="blur-bg-overlay"></div>--%>
    <%--<div class="form-popup">--%>
    <%--    <span class="close-btn material-symbols-rounded"><svg xmlns="http://www.w3.org/2000/svg" height="1em"--%>
    <%--                                                          viewBox="0 0 384 512"><path--%>
    <%--            d="M376.6 84.5c11.3-13.6 9.5-33.8-4.1-45.1s-33.8-9.5-45.1 4.1L192 206 56.6 43.5C45.3 29.9 25.1 28.1 11.5 39.4S-3.9 70.9 7.4 84.5L150.3 256 7.4 427.5c-11.3 13.6-9.5 33.8 4.1 45.1s33.8 9.5 45.1-4.1L192 306 327.4 468.5c11.3 13.6 31.5 15.4 45.1 4.1s15.4-31.5 4.1-45.1L233.7 256 376.6 84.5z"/></svg></span>--%>
    <%--    <div class="form-box login">--%>
    <%--        <div class="form-details">--%>
    <%--            <h2>Chào mừng quý khách quay lại</h2>--%>
    <%--            <p>Hãy điền địa chỉ email và mật khẩu vào các ô bên phải</p>--%>
    <%--        </div>--%>
    <%--        <div class="form-content">--%>
    <%--            <h2>ĐĂNG NHẬP</h2>--%>
    <%--            &lt;%&ndash;            <%=request.getAttribute("error")%>&ndash;%&gt;--%>
    <%--            <form class="form_login" method="post" action="./login" >--%>
    <%--                <div class="input-field">--%>
    <%--                    <input type="text" name="email" required>--%>
    <%--                    <label>Email</label>--%>
    <%--                </div>--%>
    <%--                <div class="input-field">--%>
    <%--                    <input type="password" name="pass" required>--%>
    <%--                    <label>Password</label>--%>
    <%--                </div>--%>
    <%--                <a href="#" class="forgot-pw">Quên mật khẩu?</a>--%>
    <%--                <button type="submit">Login</button>--%>
    <%--            </form>--%>
    <%--            <div class="bottom-link">--%>
    <%--                Chưa có tài khoản--%>
    <%--                <a href="#" id="signup-link">Đăng ký</a>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <%--    <!--ĐĂNG KÝ-->--%>
    <%--    <div class="form-box signup">--%>
    <%--        <div class="form-details">--%>
    <%--            <h2>Tạo tài khoản</h2>--%>
    <%--            <p>Điền thông tin theo yêu cầu bên phải</p>--%>
    <%--        </div>--%>
    <%--        <div class="form-content">--%>
    <%--            <h2>ĐĂNG KÝ</h2>--%>
    <%--            <form class="form_register" method="post" action="./register">--%>
    <%--                &lt;%&ndash;                <%=request.getAttribute("error1")%>&ndash;%&gt;--%>
    <%--                <div class="input-field">--%>
    <%--                    <input type="text" name="name" required>--%>
    <%--                    <label>Nhập tên</label>--%>
    <%--                </div>--%>
    <%--                <div class="input-field">--%>
    <%--                    <input type="text" name="email" required>--%>
    <%--                    <label>Nhập email</label>--%>
    <%--                </div>--%>
    <%--                <div class="input-field">--%>
    <%--                    <input type="password" name="pass" id="NhapMK" onkeyup="KiemTraMK()" required>--%>
    <%--                    <label>Nhập Password </label>--%>
    <%--                </div>--%>
    <%--                <div class="input-field">--%>
    <%--                    <input type="password" name="pass" id="NhapLaiMK" onkeyup="KiemTraMK()" required>--%>
    <%--                    <label>Nhập lại Password<span class="red" id="msg"></span></label>--%>
    <%--                </div>--%>
    <%--                &lt;%&ndash;                <div class="policy-text">&ndash;%&gt;--%>
    <%--                &lt;%&ndash;                    <input type="checkbox" id="policy">&ndash;%&gt;--%>
    <%--                &lt;%&ndash;                    <label for="policy">&ndash;%&gt;--%>
    <%--                &lt;%&ndash;                        Tôi đồng ý với&ndash;%&gt;--%>
    <%--                &lt;%&ndash;                        <a href="">Điều khoản</a>&ndash;%&gt;--%>
    <%--                &lt;%&ndash;                    </label>&ndash;%&gt;--%>

    <%--                &lt;%&ndash;                </div>&ndash;%&gt;--%>
    <%--                <button type="submit">Register</button>--%>
    <%--            </form>--%>
    <%--            <div class="bottom-link">--%>
    <%--                Đã có sẵn tài khoản?--%>
    <%--                <a href="#" id="login-link">Đăng nhập</a>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <%--</div>--%>

</body>
</html>