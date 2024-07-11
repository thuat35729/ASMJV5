<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Trang Chủ - Phần Mềm Bán Hàng</title>
    <style>
        .navbar {
            position: sticky;
            top: 0;
            z-index: 1000;
        }
        .banner {
            background: url('../../../resources/static/img/banner.jpg') no-repeat center center;
            background-size: cover;
            height: 300px;
            color: white;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
        }
        .banner h1 {
            font-size: 3rem;
            text-shadow: 2px 2px 4px #000;
        }
        .footer {
            background-color: #f8f9fa;
            padding: 10px 0;
            text-align: center;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="../../../resources/static/img/th.jpeg" width="30" height="30" class="d-inline-block align-top" alt=""> VuiVui</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link" href="/ban-hang/hien-thi">Bán hàng</a>
                <a class="nav-link" href="/hoa-don/hien-thi">Quản lý hóa đơn</a>
                <a class="nav-link" href="/khach-hang/hien-thi">Quản lý khách hàng</a>
                <a class="nav-link" href="/danh-muc/hien-thi">Quản lý danh mục</a>
                <a class="nav-link" href="/kich-co/hien-thi">Quản lý kích cỡ</a>
                <a class="nav-link" href="/mau-sac/hien-thi">Quản lý màu sắc</a>
                <a class="nav-link" href="/co-ao/hien-thi">Quản lý cổ áo</a>
                <a class="nav-link" href="/ctsp/hien-thi">Sản phẩm chi tiết</a>
                <a class="nav-link" href="/san-pham/hien-thi">Sản phẩm</a>
            </div>
        </div>
    </div>
</nav>
<div class="banner">
    <h1>Chào mừng đến với phần mềm bán hàng VuiVui</h1>
</div>
<div class="container mt-5">
    <div class="text-center">
        <p>Trang chủ này cung cấp các liên kết để truy cập các chức năng chính của phần mềm:</p>
    </div>
    <div class="row">
        <div class="col-md-4 mb-3">
            <div class="card">
                <div class="card-body text-center">
                    <h5 class="card-title">Bán hàng</h5>
                    <p class="card-text">Quản lý các hoạt động bán hàng hàng ngày.</p>
                    <a href="/ban-hang/hien-thi" class="btn btn-primary">Truy cập</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <div class="card">
                <div class="card-body text-center">
                    <h5 class="card-title">Quản lý hóa đơn</h5>
                    <p class="card-text">Theo dõi và quản lý các hóa đơn.</p>
                    <a href="/hoa-don/hien-thi" class="btn btn-primary">Truy cập</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 mb-3">
            <div class="card">
                <div class="card-body text-center">
                    <h5 class="card-title">Quản lý khách hàng</h5>
                    <p class="card-text">Quản lý thông tin khách hàng.</p>
                    <a href="/khach-hang/hien-thi" class="btn btn-primary">Truy cập</a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="text-center mt-4">
    <a href="/ban-hang/hien-thi" class="btn btn-success btn-lg">Bắt đầu bán hàng</a>
</div>
<footer class="footer mt-5">
    <div class="container">
        <span class="text-muted">&copy; 2024 VuiVui. All rights reserved.</span>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+ojA7K0l1RNpp7L4RheCw5iuanWs"
        crossorigin="anonymous"></script>
</body>
</html>
