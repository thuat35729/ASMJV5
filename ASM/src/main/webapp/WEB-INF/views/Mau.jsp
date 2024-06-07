<%--
  Created by IntelliJ IDEA.
  User: Dungvt22
  Date: 25/03/2024
  Time: 5:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<form action="/mausac/add" method="post">
    <div class="mb-3">
        <label class="form-label">Ma </label>
        <input type="text" class="form-control" name="mamau" >
    </div>
    <div class="mb-3">
        <label class="form-label">Ten </label>
        <input type="text" class="form-control" name="tenmau" >
    </div>
    <div class="row">
        <p class="col-4">Trang thai
        </p>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Active" name="trangthai">
            <label class="form-check-label">
                Active
            </label>
        </div>
        <div class="form-check col-4">
            <input class="form-check-input" type="radio" value="Inactive" name="trangthai">
            <label class="form-check-label">
                Inactive
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
        <th>ma mau</th>
        <th>ten mau</th>
        <th>trang thai</th>
        <th>ngay tao</th>
        <th>ngay sua</th>
        <th>thao tac</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listms}" var="a" varStatus="i">
        <tr>

            <td>${i.index+1}</td>
            <td>${a.id}</td>
            <td>${a.maMau}</td>
            <td>${a.tenMau}</td>
            <td>${a.trangThai}</td>
            <td>${a.ngayTao}</td>
            <td>${a.ngaySua}</td>
            <td>
                <a class="btn btn-warning"  href="/mausac/detal?id=${a.id}">CHI TIET</a>
            </td>
            <td>
                <a class="btn btn-warning"  href="/mausac/delete?id=${a.id}">XOA</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
