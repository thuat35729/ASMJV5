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
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <img src="../../../resources/static/img/th.jpeg" width="20px" height="20px">
        <a class="navbar-brand" href="#">VuiVui</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="/ban-hang/hien-thi">Bán hàng</a>
                <a class="nav-link active" aria-current="page" href="/ban-hang/hien-thi">Quản lý hóa đơn</a>
                <a class="nav-link active" aria-current="page" href="/khach-hang/hien-thi">Quản lý khách hàng</a>
                <a class="nav-link active" aria-current="page" href="/danh-muc/hien-thi">Quản lý danh mục</a>
                <a class="nav-link active" aria-current="page" href="/kich-co/hien-thi">Quản lý kích cỡ</a>
                <a class="nav-link active" aria-current="page" href="/mau-sac/hien-thi">Quản lý màu sắc</a>
                <a class="nav-link active" aria-current="page" href="/co-ao/hien-thi">Quản lý cổ áo</a>
                <a class="nav-link active" aria-current="page" href="/ctsp/hien-thi">Sản phẩm chi tiết</a>
                <a class="nav-link active" aria-current="page" href="/san-pham/hien-thi">Sản phẩm</a>
            </div>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <h1>Chào mừng đến với phần mềm bán hàng VuiVui</h1>
    <p>Trang chủ này cung cấp các liên kết để truy cập các chức năng chính của phần mềm:</p>
    <ul>
        <li><a href="/ban-hang/hien-thi">Bán hàng</a></li>
        <li><a href="/ban-hang/hien-thi">Quản lý hóa đơn</a></li>
        <li><a href="/ctsp/hien-thi">Sản phẩm chi tiết</a></li>
        <li><a href="/khach-hang/hien-thi">Quản lý khách hàng</a></li>
        <li><a href="/danh-muc/hien-thi">Quản lý danh mục</a></li>
        <li><a href="/san-pham/hien-thi">Quản lý sản phẩm</a></li>
        <li><a href="/kich-co/hien-thi">Quản lý kích cỡ</a></li>
        <li><a href="/mau-sac/hien-thi">Quản lý màu sắc</a></li>
        <li><a href="/co-ao/hien-thi">Quản lý cổ áo</a></li>
    </ul>
</div>
<a href="/ban-hang/hien-thi">
    <button class="btn btn-primary mt-3">Bắt đầu bán hàng</button>
</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+ojA7K0l1RNpp7L4RheCw5iuanWs"
        crossorigin="anonymous"></script>
</body>
</html>
