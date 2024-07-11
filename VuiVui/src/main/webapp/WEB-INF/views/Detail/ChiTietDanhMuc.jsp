<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh Muc</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Chi tiết danh mục</title>
</head>
<body>
<h1 class="text-center">Thông tin chi tiết danh mục</h1>
<form method="post" action="/danh-muc/sua?id=${listDM.id}">
    <p>Mã danh mục</p>
    <input type="text" name="maDanhMuc" value="${listDM.maDanhMuc}" readonly>
    <p>Tên danh mục</p>
    <input type="text" name="tenDanhMuc" value="${listDM.tenDanhMuc}">
    <p>Trang thái</p>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault1" value="Còn hàng"
               <c:if test="${listDM.trangThai == 'Còn hàng'}">checked</c:if>>
        <label class="form-check-label" for="flexRadioDefault1">
            Còn hàng
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault2" value="Hết hàng"
               <c:if test="${listDM.trangThai == 'Hết hàng'}">checked</c:if>>
        <label class="form-check-label" for="flexRadioDefault2">
            Hết hàng
        </label>
    </div>
    <button type="submit" class="btn btn-success">Sửa</button>
</form>
</body>
</html>