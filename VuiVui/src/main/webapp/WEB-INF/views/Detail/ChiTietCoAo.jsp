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
    <form action="/co-ao/sua?id=${listCoAo.id}" method="post">
        <p>
            Mã cổ áo
        </p>
        <input type="text" name="maCoAo" value="${listCoAo.maCoAo}" class="form-control" readonly>
        <p>
            Tên cổ áo
        </p>
        <input type="text" name="tenCoAo" value="${listCoAo.tenCoAo}" class="form-control">
        <p style="color: red">${errorTenCoAo}</p>
        <p>
            Trạng thái
        </p>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault1" value="Hoạt động"
                   <c:if test="${listCoAo.trangThai == 'Hoạt động'}">checked</c:if>>
            <label class="form-check-label" for="flexRadioDefault1">
                Hoạt động
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault2" value="Ngưng hoạt động"
                   <c:if test="${listCoAo.trangThai == 'Ngưng hoạt động'}">checked</c:if>>
            <label class="form-check-label" for="flexRadioDefault2">
                Ngưng hoạt động
            </label>
        </div>
        <button type="submit" class="btn btn-success">Sửa</button>
    </form>
</body>
</html>