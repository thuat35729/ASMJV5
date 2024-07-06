<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hóa Dơn</title>
</head>
<body>
<h2 class="text-center">Danh sách hóa đơn</h2>
<table class="table">
    <thead>
    <tr>
        <td>ID</td>
        <td>Tên khách hàng</td>
        <td>Số điện thoại</td>
        <td>Địa chỉ</td>
        <td>Trạng thái</td>
        <td>Hành động</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="hoaDon" items="${listHD}">
    <tr>

            <td>${hoaDon.id}</td>
            <td>${hoaDon.idKhachHang.hoTen}</td>
            <td>${hoaDon.idKhachHang.sdt}</td>
            <td>${hoaDon.idKhachHang.diaChi}</td>
            <td>${hoaDon.trangThai}</td>
            <td>
                <a href="/hoa-don/chi-tiet?id=${hoaDon.id}" >
                    <button class="btn btn-info">
                        Xem chi tiết
                    </button>
                </a>
            </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>