<%--
  Created by IntelliJ IDEA.
  User: Dungvt22
  Date: 26/03/2024
  Time: 11:23 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<form action="/kich-co/add" method="post">
    <div class="mb-3">
        <label class="form-label">Mã kích cỡ </label>
        <input type="text" class="form-control" name="maSize">
    </div>
    <div class="mb-3">
        <label class="form-label">Tên kích cỡ </label>
        <input type="text" class="form-control" name="tenSize">
    </div>
    <div class="row">
        <p class="col-4">Trạng thái
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Hoạt động" name="trangThai">
            <label class="form-check-label">
                Hoạt động
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Ngưng hoạt động" name="trangThai">
            <label class="form-check-label">
                Ngưng hoạt động
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-success">Submit</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Mã kích cỡ</th>
        <th>Tên kích cỡ</th>
        <th>Trạng thái</th>
        <th>Ngày tạo</th>
        <th>Ngày sửa</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listsz}" var="a" varStatus="i">
        <tr>

            <td>${i.index+1}</td>
            <td>${a.id}</td>
            <td>${a.maSize}</td>
            <td>${a.tenSize}</td>
            <td>${a.trangThai}</td>
            <td>${a.ngayTao}</td>
            <td>${a.ngaySua}</td>
            <td>
                <a class="btn btn-warning" href="/kich-co/detal?id=${a.id}">CHI TIẾT</a>
            </td>
            <td>
                <a class="btn btn-warning" href="/kich-co/delete?id=${a.id}">XÓA</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
