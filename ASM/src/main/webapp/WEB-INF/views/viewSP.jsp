<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<table border="2">
    <thead>
    <tr>
        <td>STT</td>
        <td>id</td>
        <td>Ma San Pham</td>
        <td>Ten San Pham</td>
        <td>Trang Thai</td>
        <td>Ngay Tao</td>
        <td>Ngay Sua</td>
        <td>Ten Danh Muc</td>
        <td>Ma Danh Muc</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="dm" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${dm.id}</td>
            <td>${dm.maSP}</td>
            <td>${dm.tenSP}</td>
            <td>${dm.trangThai}</td>
            <td>${dm.ngayTao}</td>
            <td>${dm.ngaySua}</td>
            <td>${dm.id_danhMuc.tenDanhMuc}</td>
            <td>${dm.id_danhMuc.maDanhMuc}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>