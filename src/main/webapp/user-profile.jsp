<%@ page import="bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>bs4 edit profile page - Bootdey.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
    	body{
            margin-top:20px;
            background:#7fad39
        }
    </style>
</head>
<body>
<% User user = (User) session.getAttribute("user"); %>
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
                                        <p class="mb-0">@<%= user.getEmail() %></p>
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
                                <form class="form" action="userEdit" method="post">
                                    <%
                                        String notifyS = (String) session.getAttribute("notifySuccess");
                                        String notifyF = (String) session.getAttribute("notifyFails");
                                    %>
                                    <% if(notifyS != null) {%>
                                    <p class="text-success"><%= notifyS %></p>
                                    <% } else {%>
                                    <p hidden="hidden" class="text-success"><%= notifyS %></p>
                                    <% } %>
                                    <% if(notifyF != null) {%>
                                    <p class="text-danger"><%= notifyF %></p>
                                    <% } else {%>
                                    <p hidden="hidden" class="text-danger"><%= notifyF %></p>
                                    <% } %>
                                    <div class="row">
                                        <div class="col">
                                            <div class="row">
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label>Họ</label>
                                                        <input class="form-control" id="surname" type="text" name="surname" placeholder="<%= user.getSurname() %>">
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label>Tên</label>
                                                        <input class="form-control" id="lastname" type="text" name="lastname" placeholder="<%= user.getLastname() %>">
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label>Tên người dùng</label>
                                                        <input class="form-control" id="username" type="text" name="username" placeholder="<%= user.getUsername() %>">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label>Email</label>
                                                        <input readonly class="form-control" type="text" placeholder="<%= user.getEmail() %>">
                                                        <label>Phone</label>
                                                        <input class="form-control" id="phone" type="text" name="phone" placeholder="<%= user.getPhone() %>">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col mb-3"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-12 col-sm-6 mb-3">
                                            <h2>Thay đổi mật khẩu</h2>
                                            <div class="row">
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label>Mật khẩu hiện tại</label>
                                                        <div class="input-group">
                                                            <input id="currentPassword" name="password" type="password" placeholder="••••••••••" class="form-control">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label>Mật khẩu mới</label>
                                                        <div class="input-group">
                                                            <input id="newPassword" name="newPassword" type="password" placeholder="••••••••••" class="form-control">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label>Xác nhận mật khẩu</label>
                                                        <div class="input-group">
                                                            <input id="confirmPassword" name="confirmPassword" type="password" placeholder="••••••••••" class="form-control">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label>
                                                            <input type="checkbox" id="showPasswordCheckbox">
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
                                        <button class="btn btn-primary" type="submit" style="background-color: #7fad39; border: #7fad39;">Save Changes</button>
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
    $(document).ready(function () {
        $('#showPasswordCheckbox').change(function () {
            var passwordField = $('#currentPassword, #newPassword, #confirmPassword');
            var fieldType = $(this).prop('checked') ? 'text' : 'password';
            passwordField.attr('type', fieldType);
        });
    });
</script>
</body>
</html>