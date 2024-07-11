<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Document</title>
</head>
<body>
<form action="/khach-hang/sua?id=${listKH.id}" method="post">
    <div class="mb-3">
        <label class="form-label"> Họ tên </label>
        <input type="text" class="form-control" name="hoTen" value="${listKH.hoTen}">
    </div>
    <div class="mb-3">
        <label class="form-label">Dia chi </label>
        <input type="text" class="form-control" name="diaChi" value="${listKH.diaChi}">
    </div>
    <div class="mb-3">
        <label class="form-label">SDT </label>
        <input type="text" class="form-control" name="sdt" value="${listKH.sdt}">
    </div>
    <div class="row">
        <p class="col-4">Trang thai
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Hoạt động" name="trangThai"<c:if test="${listKH.trangThai == 'Hoạt động'}">checked</c:if>>
            <label class="form-check-label">
                Hoạt động
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Ngưng hoạt động" name="trangThai"<c:if test="${listKH.trangThai == 'Ngưng hoạt động'}">checked</c:if>>
            <label class="form-check-label">
                Ngưng hoạt động
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-success">Sửa</button>
</form>
</body>
</html>