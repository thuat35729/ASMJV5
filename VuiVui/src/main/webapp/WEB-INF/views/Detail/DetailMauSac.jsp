<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<h1 class="text-center">Thông tin chi tiết màu sắc</h1>
<body>
<form action="/mau-sac/sua?id=${listMau.id}" method="post">
    <p>Mã màu</p>
    <input type="text" value="${listMau.maMau}" name="maMau" class="form-control" readonly>
    <p>Tên màu</p>
    <input type="text" value="${listMau.tenMau}" name="tenMau" class="form-control">
    <p>trang Thái</p>
    <div class="form-check col-4">
        <input class="form-check-input" type="radio" value="Hoạt động" name="trangThai"
               <c:if test="${listMau.trangThai ='Hoạt động'}">checked</c:if>>
        <label class="form-check-label">
            Hoạt động
        </label>
    </div>
    <div class="form-check col-4">
        <input class="form-check-input" type="radio" value="Ngưng hoạt động" name="trangThai"
               <c:if test="${listMau.trangThai ='Ngưng hoạt động'}">checked</c:if>>
        <label class="form-check-label">
            Ngưng hoạt động
        </label>
        <button type="submit">Sửa</button>
    </div>
</form>
</body>
</html>