<<%@ page import="dao.AccountDAO" %>
<%@ page import="bean.User" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html; UTF-8" language="java" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Chỉnh sửa người dùng</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body{
            margin-top:20px;
            background:#353b48
        }
        #activeInput {
            cursor: pointer;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Material+Icons" rel="stylesheet">
</head>
<%User a = (User) request.getAttribute("user");
    if (a==null) a=new User();%>
<body>
<%--<% User user = (User) session.getAttribute("uslogin"); %>--%>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
    <div class="row flex-lg-nowrap">
        <div class="col-12 col-lg-auto mb-3" style="width: 200px;"></div>
        <div class="col">
            <div class="row">
                <div class="col mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="e-profile">
                                <div class="row">
                                    <div class="col-12 col-sm-auto mb-3">
                                        <div class="mx-auto" style="width: 140px;">
                                            <div class="d-flex justify-content-center align-items-center rounded" style="height: 140px; background-color: rgb(233, 236, 239);">
                                                <span style="color: rgb(166, 168, 170); font: bold 8pt Arial;">140x140</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col d-flex flex-column flex-sm-row justify-content-between mb-3">
                                        <div class="text-center text-sm-left mb-2 mb-sm-0">
                                            <h4 class="pt-sm-2 pb-1 mb-0 text-nowrap"></h4>
<%--                                            <% Random rd = new Random(); %>--%>
<%--                                            <% int random = rd.nextInt(9000)+1000; %>--%>
<%--                                            <% String[] str = user.getEmail().split("@"); %>--%>
<%--                                            <% String email = str[0]; %>--%>
<%--                                            <p class="mb-0">@<%= email %>.<%= random %></p>--%>
                                            <p class="mb-0"></p><!--giống comment trên-->
                                            <div class="text-muted"><small>Last seen 2 hours ago</small></div>
                                            <div class="mt-2">
                                                <button class="btn btn-primary" type="button" style="background-color: #7fad39; border: #7fad39;">
                                                    <i class="fa fa-fw fa-camera"></i>
                                                    <span>Change Photo</span>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="text-center text-sm-right">
                                            <div class="text-muted"><small>Joined 09 Dec 2017</small></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-content pt-3">
                                    <div class="tab-pane active">
                                        <form id="editUserForm" class="form" action="./editUser" method="post" novalidate onsubmit="saveFormData()" accept-charset="UTF-8">
                                            <div class="row">
                                                <div class="col">
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label>Họ</label>
                                                                <input class="form-control" id="lastname" type="text" name="lastname" placeholder="<%=a.getLastname()%>">
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label>Tên</label>
<%--                                                                <input class="form-control" id="lastname" type="text" name="lastname" placeholder="<%= user.getLastname() %>">--%>
                                                                <input class="form-control" id="surname" type="text" name="surname" placeholder="<%= a.getSurname() %>">
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label>Tên người dùng</label>
<%--                                                                <input class="form-control" id="username" type="text" name="username" placeholder="<%= user.getUsername() %>">--%>
                                                                <input class="form-control" id="username" type="text" name="username" placeholder="<%= a.getUsername() %>">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label>Mã</label>
                                                                <input class="form-control" id="userID" type="text" name="userID" value="<%=a.getId()%>" readonly>
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label>Email</label>
                                                                <input readonly class="form-control" type="text" placeholder="<%= a.getEmail() %>">
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label>Phone</label>
<%--                                                                <input class="form-control" id="phone" type="text" name="phone" placeholder="<%= user.getPhone() %>">--%>
                                                                <input class="form-control" id="phone" type="text" name="phone" placeholder="<%= a.getPhone() %>">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col mb-3"></div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label>Vai trò</label>
                                                                <input class="form-control" id="role" type="text" name="role" placeholder="<%=a.roleString()%>" readonly>
                                                            </div>
                                                        </div>
<%--                                                        <div class="col">--%>
<%--                                                            <div class="form-group">--%>
<%--                                                                <label>Trạng thái</label>--%>
<%--                                                                <input  class="form-control" name="active" type="text" placeholder="<%= a.getActive() %>">--%>
<%--                                                            </div>--%>
<%--                                                        </div>--%>
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label for="activeInput">Trạng thái</label>
                                                                <input id="activeInput" class="form-control" name="active" type="text" value="<%= a.activeString()%>" onclick="toggleActive()" readonly>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-12 col-sm-6 mb-3">
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label>Mật khẩu hiện tại</label>
                                                                <div class="input-group">
                                                                    <input id="currentPassword" name="password" value="<%=a.getPassword()%>" type="password" class="form-control" readonly>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label>Đường dẫn</label>
                                                                <div class="input-group">
                                                                    <input id="hash" name="hash" value="<%=a.getHash()%>" type="password" class="form-control" readonly>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label>
                                                                    <input type="checkbox" id="showPasswordCheckbox" onclick="togglePasswordVisibility()">
                                                                    Hiển thị mật khẩu
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-12 col-sm-5 offset-sm-1 mb-3"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col d-flex justify-content-start">
                                                    <button class="btn btn-primary" type="button" style="background-color: #7fad39; border: #7fad39;" onclick="showAlert()">Save Changes</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-md-3 mb-3">
                    <div class="card mb-3">
                        <div class="card-body">
                            <div class="px-xl-3">
                                <button class="btn btn-block btn-secondary" style="background-color: #7fad39; border: #7fad39;">
                                    <i class="fa fa-sign-out"></i>
                                    <span><a href="HomePageController" style="text-decoration: none; text-underline: none; color: white;">Trang chủ</a></span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>
<script>
    // Lắng nghe sự kiện thay đổi của checkbox
    function togglePasswordVisibility() {
        var passwordInput = document.getElementById("currentPassword");
        var hash= document.getElementById("hash");
        var checkbox = document.getElementById("showPasswordCheckbox");

        // Nếu checkbox được chọn, hiển thị mật khẩu, ngược lại ẩn mật khẩu
        passwordInput.type = checkbox.checked ? "text" : "password";
        hash.type = checkbox.checked ? "text" :"password";
    }
</script>
<script>
    function toggleActive() {
        var activeInput = document.getElementById("activeInput");
        // Thay đổi giá trị của input giữa 0 và 1 khi input được click
        if (activeInput.value === "Khóa tài khoản") {
            activeInput.value = "Kích hoạt tài khoản";
        } else {
            activeInput.value = "Khóa tài khoản";
        }
    }
</script>

<script>
    function showAlert() {
        Swal.fire({
            title: "Bạn có muốn lưu lại ?",
            showCancelButton: true,
            confirmButtonText: "Lưu"
        }).then((result) => {
            if (result.isConfirmed) {
                // Nếu người dùng nhấn "Save", thực hiện hành động submit form
                document.getElementById("editUserForm").submit();
            } else {
                Swal.fire("Đã hủy", "", "info");
            }
        });

    }
</script>


</body>
</html>