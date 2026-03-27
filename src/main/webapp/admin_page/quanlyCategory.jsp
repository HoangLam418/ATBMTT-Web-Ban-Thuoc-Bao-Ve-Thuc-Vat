<% Object List; %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <title>Quan ly don hang</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="admin_page/css/bootstrap.min.admin.css">
    <link rel="stylesheet" href="admin_page/css/custom.css">


    <!--google fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">


    <!--google material icon-->
    <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">

</head>
<body>
<% List<Category> listCategory = (List<Category>) request.getAttribute("listCategory");
    if (listCategory == null) listCategory = new ArrayList<>();%>
<div class="wrapper">
    <div class="body-overlay"></div>
    <!-------sidebar--design------------>
    <div id="sidebar">
        <div class="sidebar-header">
            <img src="./assets/img/logo.png" class="img-fluid"/>
        </div>
        <ul class="list-unstyled component m-0">
            <li>
                <a href="./admin_dashboard" class="dashboard"><i class="material-icons">dashboard</i>Trang chủ </a>
            </li>

            <li class="dropdown">
                <a href="#homeSubmenu1" data-toggle="collapse" aria-expanded="false"
                   class="dropdown-toggle">
                    <i class="material-icons">aspect_ratio</i>Quản lý người dùng
                </a>
                <ul class="collapse list-unstyled menu" id="homeSubmenu1">
                    <li><a href="./maUser?roleID=0&uid=1">Quản lý khách hàng</a></li>
                    <li><a href="./maUser?roleID=1&uid=1">Quản lý nhân viên</a></li>
                    <li><a href="#">Chủ cửa hàng</a></li>
                </ul>
            </li>

            <li class="dropdown active">
                <a href="#homeSubmenu2" data-toggle="collapse" aria-expanded="false"
                   class="dropdown-toggle">
                    <i class="material-icons">apps</i>Quản lý sản phẩm
                </a>
                <ul class="collapse list-unstyled menu" id="homeSubmenu2">
                    <li><a href="./maCategory">Quản lý doanh mục</a></li>
                    <li><a href=".//maProduct">Quản lý sản phẩm</a></li>
                    <li><a href="#">Quản lý mã giảm giá</a></li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#homeSubmenu3" data-toggle="collapse" aria-expanded="false"
                   class="dropdown-toggle">
                    <i class="material-icons">equalizer</i>charts
                </a>
                <ul class="collapse list-unstyled menu" id="homeSubmenu3">
                    <li><a href="#">Pages 1</a></li>
                    <li><a href="#">Pages 2</a></li>
                    <li><a href="#">Pages 3</a></li>
                </ul>
            </li>


            <li class="dropdown">
                <a href="#homeSubmenu4" data-toggle="collapse" aria-expanded="false"
                   class="dropdown-toggle">
                    <i class="material-icons">extension</i>UI Element
                </a>
                <ul class="collapse list-unstyled menu" id="homeSubmenu4">
                    <li><a href="#">Pages 1</a></li>
                    <li><a href="#">Pages 2</a></li>
                    <li><a href="#">Pages 3</a></li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#homeSubmenu5" data-toggle="collapse" aria-expanded="false"
                   class="dropdown-toggle">
                    <i class="material-icons">border_color</i>forms
                </a>
                <ul class="collapse list-unstyled menu" id="homeSubmenu5">
                    <li><a href="#">Pages 1</a></li>
                    <li><a href="#">Pages 2</a></li>
                    <li><a href="#">Pages 3</a></li>
                </ul>
            </li>

            <li class="dropdown">
                <a href="#homeSubmenu6" data-toggle="collapse" aria-expanded="false"
                   class="dropdown-toggle">
                    <i class="material-icons">grid_on</i>tables
                </a>
                <ul class="collapse list-unstyled menu" id="homeSubmenu6">
                    <li><a href="#">table 1</a></li>
                    <li><a href="#">table 2</a></li>
                    <li><a href="#">table 3</a></li>
                </ul>
            </li>


            <li class="dropdown">
                <a href="#homeSubmenu7" data-toggle="collapse" aria-expanded="false"
                   class="dropdown-toggle">
                    <i class="material-icons">content_copy</i>Pages
                </a>
                <ul class="collapse list-unstyled menu" id="homeSubmenu7">
                    <li><a href="#">Pages 1</a></li>
                    <li><a href="#">Pages 2</a></li>
                    <li><a href="#">Pages 3</a></li>
                </ul>
            </li>


            <li class="">
                <a href="#" class=""><i class="material-icons">date_range</i>copy </a>
            </li>
            <li class="">
                <a href="#" class=""><i class="material-icons">library_books</i>calender </a>
            </li>

        </ul>
    </div>

    <!-------sidebar--design- close----------->


    <!-------page-content start----------->

    <div id="content">

        <!------top-navbar-start----------->

        <div class="top-navbar">
            <div class="xd-topbar">
                <div class="row">
                    <div class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
                        <div class="xp-menubar">
                            <span class="material-icons text-white">signal_cellular_alt</span>
                        </div>
                    </div>

                    <div class="col-md-5 col-lg-3 order-3 order-md-2">
                        <div class="xp-searchbar">
                            <form action="./maCategory" method="get">
                                <div class="input-group">
                                    <input type="search" name="search" class="form-control"
                                           placeholder="Search">
                                    <div class="input-group-append">
                                        <button class="btn" type="submit" id="button-addon2">Go
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <jsp:include page="include/header_content.jsp"/>
<%--                    <jsp:include page="include/header_content.jsp"/>--%>


<%--                    <div class="col-10 col-md-6 col-lg-8 order-1 order-md-3">--%>
<%--                        <div class="xp-profilebar text-right">--%>
<%--                            <nav class="navbar p-0">--%>
<%--                                <ul class="nav navbar-nav flex-row ml-auto">--%>
<%--                                    <li class="dropdown nav-item active">--%>
<%--                                        <a class="nav-link" href="#" data-toggle="dropdown">--%>
<%--                                            <span class="material-icons">notifications</span>--%>
<%--                                            <span class="notification">4</span>--%>
<%--                                        </a>--%>
<%--                                        <ul class="dropdown-menu">--%>
<%--                                            <li><a href="#">You Have 4 New Messages</a></li>--%>
<%--                                            <li><a href="#">You Have 4 New Messages</a></li>--%>
<%--                                            <li><a href="#">You Have 4 New Messages</a></li>--%>
<%--                                            <li><a href="#">You Have 4 New Messages</a></li>--%>
<%--                                        </ul>--%>
<%--                                    </li>--%>

<%--                                    <li class="nav-item">--%>
<%--                                        <a class="nav-link" href="#">--%>
<%--                                            <span class="material-icons">question_answer</span>--%>
<%--                                        </a>--%>
<%--                                    </li>--%>

<%--                                    <li class="dropdown nav-item">--%>
<%--                                        <a class="nav-link" href="#" data-toggle="dropdown">--%>
<%--                                            <span class="material-icons">person</span>--%>
<%--                                        </a>--%>
<%--                                        <ul class="dropdown-menu small-menu">--%>
<%--                                            <li><a href="#">--%>
<%--                                                <span class="material-icons">person_outline</span>--%>
<%--                                                Profile--%>
<%--                                            </a></li>--%>
<%--                                            <li><a href="#">--%>
<%--                                                <span class="material-icons">settings</span>--%>
<%--                                                Settings--%>
<%--                                            </a></li>--%>
<%--                                            <li><a href="#">--%>
<%--                                                <span class="material-icons">logout</span>--%>
<%--                                                Logout--%>
<%--                                            </a></li>--%>

<%--                                        </ul>--%>
<%--                                    </li>--%>


<%--                                </ul>--%>
<%--                            </nav>--%>
<%--                        </div>--%>
<%--                    </div>--%>

                </div>

                <div class="xp-breadcrumbbar text-center">
                    <h4 class="page-title">Quản lý đơn hàng</h4>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Vishweb</a></li>
                        <li class="breadcrumb-item active" aria-curent="page">Dashboard</li>
                    </ol>
                </div>


            </div>
        </div>
        <!------top-navbar-end----------->


        <!------main-content-start----------->

        <div class="main-content">
            <div class="row">
                <div class="col-md-12">
                    <div class="table-wrapper">

                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-6 p-0 flex justify-content-lg-start justify-content-center">
                                    <h2 class="ml-lg-2">Manage Employees</h2>
                                </div>
                                <div class="col-sm-6 p-0 flex justify-content-lg-end justify-content-center">
                                    <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal">
                                        <i class="material-icons">&#xE147;</i>
                                        <span>Add New Employees</span>
                                    </a>
<%--                                    <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal">--%>
<%--                                        <i class="material-icons">&#xE15C;</i>--%>
<%--                                        <span>Delete</span>--%>
<%--                                    </a>--%>
                                </div>
                            </div>
                        </div>

                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th></th>
                                <th></th>
                                <th>Mã</th>
                                <th>Tên doanh mục</th>
                                <th></th>
                                <th>Chỉnh</th>
                            </tr>
                            </thead>

                            <tbody>
                            <%for (Category a :listCategory){%>
                            <tr>
                                <form id="editForm<%=a.getId()%>" action="./editCategory" method="post" accept-charset="UTF-8">
                                    <th></th>
                                    <th><svg xmlns="http://www.w3.org/2000/svg" height="16" width="14" viewBox="0 0 448 512"><path d="M210.6 5.9L62 169.4c-3.9 4.2-6 9.8-6 15.5C56 197.7 66.3 208 79.1 208H104L30.6 281.4c-4.2 4.2-6.6 10-6.6 16C24 309.9 34.1 320 46.6 320H80L5.4 409.5C1.9 413.7 0 419 0 424.5c0 13 10.5 23.5 23.5 23.5H192v32c0 17.7 14.3 32 32 32s32-14.3 32-32V448H424.5c13 0 23.5-10.5 23.5-23.5c0-5.5-1.9-10.8-5.4-15L368 320h33.4c12.5 0 22.6-10.1 22.6-22.6c0-6-2.4-11.8-6.6-16L344 208h24.9c12.7 0 23.1-10.3 23.1-23.1c0-5.7-2.1-11.3-6-15.5L237.4 5.9C234 2.1 229.1 0 224 0s-10 2.1-13.4 5.9z"/></svg></th>
                                    <th><%=a.getId()%></th>
                                    <th><input type="text" name="categoryName" value="<%=a.getCategoryName()%>"></th>
                                    <th></th>
                                    <th>
                                        <a href="javascript:void(0);" class="edit" data-toggle="modal" onclick="submitEditForm(<%=a.getId()%>)">
                                            <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
                                        </a>
                                        <a href="#deleteEmployeeModal<%=a.getId()%>" class="delete" data-toggle="modal">
                                            <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
                                        </a>
                                    </th>
                                </form>
                            </tr>
                            <!---- Xóa doanh mục  ---->
                            <div class="modal fade" tabindex="-1" id="deleteEmployeeModal<%=a.getId()%>" role="dialog">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">Xóa doanh mục </h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <p>Bạn có chắc muốn xóa <%=a.getCategoryName()%> ra khỏi danh sách</p>
                                            <p class="text-warning"><small>Bấm "hủy" để dừng lại,</small></p>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                                            <button type="button" class="btn btn-success" onclick="deleteCate(<%=a.getId()%>)">Xóa</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%}%>
                            </tbody>
                        </table>

                        <div class="clearfix">
                            <div class="hint-text">showing <b>5</b> out of <b>25</b></div>
                            <ul class="pagination">
                                <li class="page-item disabled"><a href="#">Previous</a></li>
                                <li class="page-item "><a href="#" class="page-link">1</a></li>
                                <li class="page-item "><a href="#" class="page-link">2</a></li>
                                <li class="page-item active"><a href="#" class="page-link">3</a></li>
                                <li class="page-item "><a href="#" class="page-link">4</a></li>
                                <li class="page-item "><a href="#" class="page-link">5</a></li>
                                <li class="page-item "><a href="#" class="page-link">Next</a></li>
                            </ul>
                        </div>
                    </div>
                </div>


                <!----add-modal start--------->
                <div class="modal fade" tabindex="-1" id="addEmployeeModal" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Add Employees</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form action="./insertCate" method="post" accept-charset="UTF-8">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>Tên doanh mục</label>
                                        <input type="text" class="form-control" name="nameCate" required>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                                    <button type="submit" class="btn btn-success">Thêm</button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>

                <!----edit-modal end--------->


                <!----edit-modal start--------->
                <div class="modal fade" tabindex="-1" id="editEmployeeModal" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Edit Employees</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="emil" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <textarea class="form-control" required></textarea>
                                </div>
                                <div class="form-group">
                                    <label>Phone</label>
                                    <input type="text" class="form-control" required>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <button type="button" class="btn btn-success">Save</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!----edit-modal end--------->


                <!----delete-modal start--------->


                <!----edit-modal end--------->


            </div>
        </div>

        <!------main-content-end----------->


        <!----footer-design------------->

        <footer class="footer">
            <div class="container-fluid">
                <div class="footer-in">
                    <p class="mb-0">&copy 2021 Vishweb Design . All Rights Reserved.</p>
                </div>
            </div>
        </footer>


    </div>

</div>


<!-------complete html----------->


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="admin_page/js/adminJS/jquery-3.3.1.slim.min.js"></script>
<script src="admin_page/js/adminJS/popper.min.js"></script>
<script src="admin_page/js/adminJS/jquery-3.3.1.min.js"></script>
<script src="admin_page/js/adminJS/bootstrap.min.js"></script>


<script type="text/javascript">
    $(document).ready(function () {
        $(".xp-menubar").on('click', function () {
            $("#sidebar").toggleClass('active');
            $("#content").toggleClass('active');
        });

        $('.xp-menubar,.body-overlay').on('click', function () {
            $("#sidebar,.body-overlay").toggleClass('show-nav');
        });

    });
</script>
<script>
    function deleteCate(cateID) {
        // Tạo một biểu mẫu và thêm input ẩn để chứa thông tin người dùng
        var form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", "./deleteCate"); // Sửa chính tả ở đây

        var inputCateID = document.createElement("input");
        inputCateID.setAttribute("type", "hidden");
        inputCateID.setAttribute("name", "cateID");
        inputCateID.setAttribute("value", cateID);


        form.appendChild(inputCateID);
        document.body.appendChild(form);

        // Gửi yêu cầu POST
        form.submit();
    }
</script>
<script>
    function submitEditForm(categoryId) {
        var form = document.getElementById('editForm' + categoryId);

        var inputCateID = document.createElement("input");
        inputCateID.type = "hidden";
        inputCateID.name = "categoryId";
        inputCateID.value = categoryId;
        form.appendChild(inputCateID);

        form.submit();
    }
</script>



</body>

</html>


