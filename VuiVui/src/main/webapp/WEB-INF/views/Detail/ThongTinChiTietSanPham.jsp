<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>${error}</h1>
<h2>Chi tiết sản phẩm</h2>
<form action="/ctsp/sua?id=${listctsp.id}" method="post">
<p>Tên sản phẩm</p>
<select name="idSanPham" class="form-control">
    <c:forEach items="${listsp}" var="sp">
        <option value="${sp.id}" <c:if test="${listctsp.idSanPham.id == sp.id}">selected</c:if>>
                ${sp.tenSP}
        </option>
    </c:forEach>
</select>
<p>Tên màu</p>
<select name="idMauSac" class="form-control">
    <c:forEach items="${listmau}" var="mau">
        <option value="${mau.id}" <c:if test="${listctsp.idMauSac.id == mau.id}">selected</c:if>>
                ${mau.tenMau}
        </option>
    </c:forEach>
</select>
<p>Kích cỡ</p>
<select name="idSize" class="form-control">
    <c:forEach items="${listsize}" var="s">
        <option value="${s.id}" <c:if test="${listctsp.idSize.id == s.id}">selected</c:if>>
                ${s.tenSize}
        </option>
    </c:forEach>
</select>
<p>Cổ áo</p>
<select name="idCoAo" class="form-control">
    <c:forEach items="${listCoAo}" var="s">
        <option value="${s.id}" <c:if test="${listctsp.idCoAo.id == s.id}">selected</c:if>>
                ${s.tenCoAo}
        </option>
    </c:forEach>
</select>
<p>Giá bán</p>
<input type="text" name="giaBan" class="form-control" value="${listctsp.giaBan}"><br>
<p style="color: red">${errorGiaBan}</p>
<p>Số lượng</p>
<input type="text" name="soLuongTon" class="form-control" value="${listctsp.soLuongTon}"><br>
<p style="color: red">${errorSoLuong}</p>
<p>Trạng thái</p>
<div class="form-check">
    <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault1" value="Còn hàng"<c:if
            test="${listctsp.trangThai == 'Còn hàng'}"> checked</c:if>>
    <label class="form-check-label" for="flexRadioDefault1">
        Còn hàng
    </label>
</div>
<div class="form-check">
    <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault2" checked value="Hết hàng"<c:if
            test="${listctsp.trangThai == 'Hết hàng'}"> checked</c:if>>
    <label class="form-check-label" for="flexRadioDefault2">
        Hết hàng
    </label>
</div>
<button type="submit" class="btn btn-info" onclick="return confirm('Có muốn sửa không')">Sửa</button>
</form>
</body>
</html>