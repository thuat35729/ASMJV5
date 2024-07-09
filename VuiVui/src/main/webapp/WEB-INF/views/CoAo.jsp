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
<form action="/co-ao/them" method="post">
    <p>
        Mã cổ áo
    </p>
    <input type="text" class="form-control" name="maCoAo">
    <p>
        Tên cổ áo
    </p>
    <input type="text" class="form-control" name="tenCoAo">
    <p>
        Trạng thái
    </p>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" value="Hoạt động"
               name="trangThai">
        <label class="form-check-label" for="flexRadioDefault1">
            Hoạt động
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked
               value="Ngưng hoạt động" name="trangThai">
        <label class="form-check-label" for="flexRadioDefault2">
            Ngưng hoạt động
        </label>
    </div>
    <button type="submit" class="btn btn-success">Thêm</button>
</form>
<table class="table">
    <thead>
    <tr>
        <td>
            Số thứ tự
        </td>
        <td>
            Mã cổ áo
        </td>
        <td>
            Tên cổ áo
        </td>
        <td>
            Trang thái
        </td>
        <td>
            Hoạt động
        </td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCoAo}" var="a" varStatus="i">
        <tr>
            <td>
                    ${i.index + 1}
            </td>
            <td>
                    ${a.maCoAo}
            </td>
            <td>
                    ${a.tenCoAo}
            </td>
            <td>
                    ${a.trangThai}
            </td>
            <td>
                <a href="/co-ao/xoa?id=${a.id}">
                    <button class="btn btn-danger">Xoá</button>
                </a>
                <a href="/co-ao/chi-tiet?id=${a.id}">
                    <button class="btn btn-warning">Chi Tiết</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>