<%@ page import="bean.ShoppingCart" %>
<%@ page import="bean.CartItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="icon" type="image/x-icon" href="assets/img/logo.png">
    <title>Vườn phố</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="assets/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="assets/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/style.css" type="text/css">
    <link rel="stylesheet" href="assets/css/Log_Regis.css">
    <script src="js/log_reg.js" defer></script>
</head>

<body>
<%
    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");

    if (shoppingCart == null) {
        // Nếu giỏ hàng chưa tồn tại, tạo mới và đặt vào session
        shoppingCart = new ShoppingCart();
        session.setAttribute("cart", shoppingCart);
    }

    List<CartItem> cartItems = shoppingCart.getCartItemList();
    if (cartItems == null) {
        cartItems = new ArrayList<>(); // Tạo danh sách sản phẩm nếu chưa có
    }

    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
    String e = (String) request.getAttribute("error");
    if (e == null) {
        e = ""; // Đặt giá trị mặc định là chuỗi trống nếu e là null
    }
%>


<jsp:include page="layout/header.jsp"/>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="assets/img/breadcrumb.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Giỏ hàng</h2>
                    <div class="breadcrumb__option">
                        <a href="index.jsp">Trang chủ</a>
                        <span>Giỏ hàng</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shoping Cart Section Begin -->
<section class="shoping-cart spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="shoping__cart__table">
                    <table>
                        <thead>
                        <tr>
                            <th class="shoping__product">Sản phẩm</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Tổng cộng</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            int count = 0;
                            for(CartItem cartItem : cartItems){

                        %>
                        <tr>
                            <td class="shoping__cart__item">
                                <img class="product-image" src="assets/<%=cartItem.getProduct().getPicture()%>" alt="Vegetable's Package">
                                <h5><%=cartItem.getProduct().getProduct_name()%></h5>
                            </td>
                            <td class="shoping__cart__price">
                                <%=cartItem.getProduct().getPrice()%>
                            </td>
                            <td class="shoping__cart__quantity">
                                <form action="ShoppingCartCL" method="get">
                                    <input type="number" name="quantity" value="<%=cartItem.getQuantity()%>">
                                    <input type ="hidden" name ="action" value="put">
                                    <input type ="hidden" name="id" value="<%=cartItem.getProduct().getId()%>">
                                    <button hidden="hidden" id="button1" type="submit" class="primary-btn cart-btn cart-btn-right">
                                        <span class="icon_loading"></span>
                                        Cập nhật giỏ hàng
                                    </button>
                                </form>
                            </td>
                            <td class="shoping__cart__total">
                                <%=numberFormat.format(cartItem.getTotalPrice())%>
                            </td>
                            <td class="shoping__cart__item__close">
                                <form action="ShoppingCartCL" method="get">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="id" value="<%= cartItem.getProduct().getId() %>">
                                    <button type="submit" class="icon_close"></button>
                                </form>
                            </td>
                            <% }%>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="shoping__cart__btns">
                    <a href="ProductController" class="primary-btn cart-btn">TIẾP TỤC MUA SẮM</a>
<%--                    <p class="text-danger"><%=e%></p>--%>
                    <button id="button2" type="submit" class="primary-btn cart-btn cart-btn-right">
                        <span class="icon_loading"></span>
                        Cập nhật giỏ hàng
                    </button>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="shoping__continue">
                    <div class="shoping__discount">
                        <h5>Mã giảm giá</h5>
                        <form action="#">
                            <input type="text" placeholder="Điền mã của bạn vào">
                            <button type="submit" class="site-btn">Áp dụng mã</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="shoping__checkout">
                    <h5>Tổng số lượng hàng</h5>
                    <ul>
                        <li>Tạm tính <span><%=shoppingCart.getTotalPrice()%></span></li>
                        <li>Tổng <span><%=shoppingCart.getTotalPrice()%></span></li>
                    </ul>
                    <a href="thanh-toan.jsp" class="primary-btn">TIẾN HÀNH THANH TOÁN</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shoping Cart Section End -->

<!-- Footer Section Begin -->
<footer class="footer spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
                <div class="footer__about">
                    <div class="footer__about__logo">
                        <a href="index.jsp"><img src="assets/img/logo.png" alt=""></a>
                    </div>
                    <ul>
                        <li>Address: 171 Nguyễn Văn Khối, Phường 8, Gò Vấp, TP. HCM</li>
                        <li>Phone: +84 123456789</li>
                        <li>Email: vuonpho@gmail.com</li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                <div class="footer__widget">
                    <h6>Chính sách công ty</h6>
                    <ul>
                        <li><a href="#">Về chúng tôi</a></li>
                        <li><a href="#">Về cửa hàng chúng tôi</a></li>
                        <li><a href="#">Chính sách mua hàng</a></li>
                        <li><a href="#">Thông tin vận chuyển</a></li>
                        <li><a href="#">Điều khoản và bảo mật</a></li>
                        <li><a href="#">Địa chỉ cửa hàng</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">Chúng tôi là ai</a></li>
                        <li><a href="#">Dịch vụ của chúng tôi</a></li>
                        <li><a href="#">Các Project</a></li>
                        <li><a href="#">Liên hệ</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-12">
                <div class="footer__widget">
                    <h6>Tham gia với chúng tôi</h6>
                    <p>Cập nhật thông tin mới nhất và các ưu đãi về cửa hàng thông qua email.</p>
                    <form action="#">
                        <input type="text" placeholder="Nhập địa chỉ email">
                        <button type="submit" class="site-btn">ĐĂNG KÝ</button>
                    </form>
                    <div class="footer__widget__social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-instagram"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-pinterest"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="footer__copyright">

                    <div class="footer__copyright__payment"><img src="assets/img/payment-item.png" alt=""></div>
                </div>
            </div>
        </div>
    </div>
</footer>

<!-- Js Plugins -->
<script src="assets/js/jquery-3.3.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.nice-select.min.js"></script>
<script src="assets/js/jquery-ui.min.js"></script>
<script src="assets/js/jquery.slicknav.js"></script>
<script src="assets/js/mixitup.min.js"><d/script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/main.js"></script>
<script>
    document.getElementById("button2").addEventListener("click", function() {
        // Simulate a click on the first hidden button ("button1") for each item
        var hiddenButtons = document.querySelectorAll("[id^='button1']");
        hiddenButtons.forEach(function(button) {
            button.click();
        });
    });
</script>


</body>

</html>