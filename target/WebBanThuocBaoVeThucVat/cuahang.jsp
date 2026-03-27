<%@ page import="bean.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.ShoppingCart" %>
<%@ page import="bean.Products" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Category" %>
<%@ page import="bo.CategoryBO" %>
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
    <%--    <link rel="stylesheet" href="assets/css/Log_Regis.css">--%>
    <%--    <script src="js/log_reg.js" defer></script>--%>
    <%
        List<Products> products= (List<Products>) request.getAttribute("products");
        CategoryBO cb = new CategoryBO();
    %>
</head>

<body>
<jsp:include page="layout/header.jsp"/>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="assets/img/breadcrumb.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Cửa hàng</h2>
                    <div class="breadcrumb__option">
                        <a href="index.jsp">Trang chủ</a>
                        <span>Cửa hàng</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Section Begin -->
<section class="product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-5">
                <div class="sidebar">
                    <div class="sidebar__item">
                        <h4>Danh mục sản phẩm</h4>
                        <ul>
                            <li><a href="StoreProductHome">Tất cả sản phẩm</a></li>
                            <% for(Category cate : cb.getListCategory()) {%>
                            <li><a href="ProductController?id_category=<%=cate.getId()%>"><%= cate.getCategoryName() %></a></li>
                            <% } %>
                        </ul>
                    </div>
                    <%--                    <div class="sidebar__item">--%>
                    <%--                        <h4>Khoảng giá</h4>--%>
                    <%--                        <div class="price-range-wrap">--%>
                    <%--                            <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"--%>
                    <%--                                data-min="10000" data-max="10000000">--%>
                    <%--                                <div class="ui-slider-range ui-corner-all ui-widget-header"></div>--%>
                    <%--                                <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>--%>
                    <%--                                <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>--%>
                    <%--                            </div>--%>
                    <%--                            <div class="range-slider">--%>
                    <%--                                <div class="price-input">--%>
                    <%--                                    <input name="priceMin" type="text" id="minamount">--%>
                    <%--                                    <input name="priceMax" type="text" id="maxamount">--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="sidebar__item">--%>
                    <%--                        <h4>Popular Size</h4>--%>
                    <%--                        <div class="sidebar__item__size">--%>
                    <%--                            <label for="large">--%>
                    <%--                                Large--%>
                    <%--                                <input type="radio" id="large">--%>
                    <%--                            </label>--%>
                    <%--                        </div>--%>
                    <%--                        <div class="sidebar__item__size">--%>
                    <%--                            <label for="medium">--%>
                    <%--                                Medium--%>
                    <%--                                <input type="radio" id="medium">--%>
                    <%--                            </label>--%>
                    <%--                        </div>--%>
                    <%--                        <div class="sidebar__item__size">--%>
                    <%--                            <label for="small">--%>
                    <%--                                Small--%>
                    <%--                                <input type="radio" id="small">--%>
                    <%--                            </label>--%>
                    <%--                        </div>--%>
                    <%--                        <div class="sidebar__item__size">--%>
                    <%--                            <label for="tiny">--%>
                    <%--                                Tiny--%>
                    <%--                                <input type="radio" id="tiny">--%>
                    <%--                            </label>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="sidebar__item">--%>
                    <%--                        <div class="latest-product__text">--%>
                    <%--                            <h4>Mới nhất</h4>--%>
                    <%--                            <div class="latest-product__slider owl-carousel">--%>
                    <%--                                <div class="latest-prdouct__slider__item">--%>
                    <%--                             --%>
                    <%--                                    <a href="ProductInfor?id_product=<%= p.getId() %>" class="latest-product__item">--%>
                    <%--                                        <div class="latest-product__item__pic">--%>
                    <%--                                            <img src="assets/<%=p.getPicture()%>" alt="">--%>
                    <%--                                        </div>--%>
                    <%--                                        <div class="latest-product__item__text">--%>
                    <%--                                            <h6><%=p.getProduct_name()%></h6>--%>
                    <%--                                            <span><fmt:formatNumber value="<%= p.getPrice() %>" type="currency" pattern="###,###"/>₫</span>--%>
                    <%--                                        </div>--%>
                    <%--                                    </a>--%>
                    <%--                                    <% } %>--%>
                    <%--                                </div>--%>
                    <%--                                <div class="latest-prdouct__slider__item">--%>
                    <%--                                    <% for(Products p : productNew2) {%>--%>
                    <%--                                    <a href="ProductInfor?id_product=<%= p.getId() %>" class="latest-product__item">--%>
                    <%--                                        <div class="latest-product__item__pic">--%>
                    <%--                                            <img src="assets/<%=p.getPicture()%>" alt="">--%>
                    <%--                                        </div>--%>
                    <%--                                        <div class="latest-product__item__text">--%>
                    <%--                                            <h6><%=p.getProduct_name()%></h6>--%>
                    <%--                                            <span><fmt:formatNumber value="<%= p.getPrice() %>" type="currency" pattern="###,###"/>₫</span>--%>
                    <%--                                        </div>--%>
                    <%--                                    </a>--%>
                    <%--                                    <% } %>--%>
                    <%--                                </div>--%>
                    <%--                            </div>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                </div>
            </div>
            <div class="col-lg-9 col-md-7">
                <div class="product__discount">
                    <div class="section-title product__discount__title">
                        <h2>Giảm giá</h2>
                    </div>
                    <div class="row">
                        <div class="product__discount__slider owl-carousel">
                            <div class="col-lg-4">
                                <div class="product__discount__item">
                                    <div class="product__discount__item__pic set-bg"
                                         data-setbg="assets/img/product/discount/pd-1.jpg">
                                        <div class="product__discount__percent">-20%</div>
                                        <ul class="product__item__pic__hover">

                                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__discount__item__text">
                                        <span>Dried Fruit</span>
                                        <h5><a href="#">Thuốc bảo vệ thực vật</a></h5>
                                        <div class="product__item__price">45.000₫ <span>36.000₫</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="product__discount__item">
                                    <div class="product__discount__item__pic set-bg"
                                         data-setbg="assets/img/product/discount/pd-2.jpg">
                                        <div class="product__discount__percent">-20%</div>
                                        <ul class="product__item__pic__hover">

                                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__discount__item__text">
                                        <span>Vegetables</span>
                                        <h5><a href="#">Thuốc bảo vệ thực vật</a></h5>
                                        <div class="product__item__price">45.000₫ <span>36.000₫</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="product__discount__item">
                                    <div class="product__discount__item__pic set-bg"
                                         data-setbg="assets/img/product/discount/pd-3.jpg">
                                        <div class="product__discount__percent">-20%</div>
                                        <ul class="product__item__pic__hover">

                                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__discount__item__text">
                                        <span>Dried Fruit</span>
                                        <h5><a href="#">Thuốc bảo vệ thực vật</a></h5>
                                        <div class="product__item__price">45.000₫ <span>36.000₫</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="product__discount__item">
                                    <div class="product__discount__item__pic set-bg"
                                         data-setbg="assets/img/product/discount/pd-4.jpg">
                                        <div class="product__discount__percent">-20%</div>
                                        <ul class="product__item__pic__hover">

                                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__discount__item__text">
                                        <span>Dried Fruit</span>
                                        <h5><a href="#">Thuốc bảo vệ thực vật</a></h5>
                                        <div class="product__item__price">45.000₫ <span>36.000₫</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="product__discount__item">
                                    <div class="product__discount__item__pic set-bg"
                                         data-setbg="assets/img/product/discount/pd-5.jpg">
                                        <div class="product__discount__percent">-20%</div>
                                        <ul class="product__item__pic__hover">

                                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__discount__item__text">
                                        <span>Dried Fruit</span>
                                        <h5><a href="#">Thuốc bảo vệ thực vật</a></h5>
                                        <div class="product__item__price">45.000₫ <span>36.000₫</span></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="product__discount__item">
                                    <div class="product__discount__item__pic set-bg"
                                         data-setbg="assets/img/product/discount/pd-6.jpg">
                                        <div class="product__discount__percent">-20%</div>
                                        <ul class="product__item__pic__hover">

                                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__discount__item__text">
                                        <span>Dried Fruit</span>
                                        <h5><a href="#">Thuốc bảo vệ thực vật</a></h5>
                                        <div class="product__item__price">45.000₫ <span>36.000₫</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="filter__item">
                    <div class="row">
                        <div class="col-lg-4 col-md-5">
                            <div class="filter__sort">
                                <span>Sắp xếp : </span>
                                <select id="selectOrder">
                                    <option value="0">Thứ tự mặc định</option>
                                    <option value="1">Thứ tự theo mức độ phổ biến</option>
                                    <option value="2">Thứ tự theo giá: thấp đến cao</option>
                                    <option value="3">Thứ tự theo giá: cao xuống thấp</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4">
                            <div class="filter__found">
                                <h6><span><%= products.size() %></span> sản phẩm được tìm thấy</h6>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-3">
                            <div class="filter__option">
                                <span class="icon_grid-2x2"></span>
                                <span class="icon_ul"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <%for(Products a : products){%>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div id="" class="product__item">
                            <div class="product__item__pic set-bg" data-setbg="assets/<%=a.getPicture()%>">
                                <ul class="product__item__pic__hover">
                                    <li><a href="ProductInfor?id_product=<%= a.getId() %>"><i class="fa fa-retweet"></i></a></li>
                                    <li><a href="ShoppingCartCL?action=post&id=<%=a.getId()%>"><i class="fa fa-shopping-cart"></i></a></li>
                                </ul>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="#"><%=a.getProduct_name()%></a></h6>
                                <h5><%=a.formatPrice()%>₫</h5>
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div>
                <div class="product__pagination">
                    <a href="#">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#"><i class="fa fa-long-arrow-right"></i></a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Product Section End -->

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
    </div>
    <%--    <h1><%= productNew1.size() %></h1>--%>
</footer>

<!-- Js Plugins -->
<script src="assets/js/jquery-3.3.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<%--<script src="assets/js/jquery.nice-select.min.js"></script>--%>
<script src="assets/js/jquery-ui.min.js"></script>
<script src="assets/js/jquery.slicknav.js"></script>
<script src="assets/js/mixitup.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/main.js"></script>

<script>
    // Lắng nghe sự kiện thay đổi của thẻ select
    document.getElementById('selectOrder').addEventListener('change', function() {
        // Lấy giá trị được chọn
        var selectedValue = this.value;

        // Chuyển hướng trình duyệt đến trang index với tham số là giá trị được chọn
        window.location.href = 'ProductController?order=' + selectedValue;
    });
</script>

</body>

</html>