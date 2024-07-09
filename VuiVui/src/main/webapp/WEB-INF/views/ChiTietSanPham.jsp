<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<form action="/ctsp/them" method="post">
    <p>Tên sản phẩm</p>
    <select name="idSanPham" class="form-control">
        <c:forEach items="${listsp}" var="sp">
            <option value="${sp.id}">
                    ${sp.tenSP}
            </option>
        </c:forEach>
    </select>
    <p>Tên màu</p>
    <select name="idMauSac" class="form-control">
        <c:forEach items="${listmau}" var="mau">
            <option value="${mau.id}">
                    ${mau.tenMau}
            </option>
        </c:forEach>
    </select>
    <p>Kích cỡ</p>
    <select name="idSize" class="form-control">
        <c:forEach items="${listsize}" var="s">
            <option value="${s.id}">
                    ${s.tenSize}
            </option>
        </c:forEach>
    </select>
    <p>Cổ áo</p>
    <select name="idCoAo" class="form-control">
        <c:forEach items="${listCoAo}" var="s">
            <option value="${s.id}">
                    ${s.tenCoAo}
            </option>
        </c:forEach>
    </select>
    <p>Giá bán</p>
    <input type="text" name="giaBan" class="form-control"><br>
    <p style="color: red">${errorGiaBan}</p>
    <p>Số lượng</p>
    <input type="text" name="soLuongTon" class="form-control"><br>
    <p style="color: red">${errorSoLuong}</p>
    <p>Trạng thái</p>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault1" value="Còn hàng">
        <label class="form-check-label" for="flexRadioDefault1">
            Còn hàng
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault2" checked value="Hết hàng">
        <label class="form-check-label" for="flexRadioDefault2">
            Hết hàng
        </label>
    </div>
    <button type="submit" class="btn btn-info" onclick="return confirm('Co Muon Them Khong')">Thêm</button>
</form>
<table border="2" class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>id</td>
        <td>Tên sản phẩm</td>
        <td>Màu sắc</td>
        <td>Kích cỡ</td>
        <td>Cổ áo</td>
        <td>Giá bán</td>
        <td>Số lượng</td>
        <td>Trạng thái</td>
        <td>Ngày tạo</td>
        <td>Ngày sửa</td>
        <td>Hành động</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.content}" var="ctsp" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${ctsp.id}</td>
            <td>${ctsp.idSanPham.tenSP}</td>
            <td>${ctsp.idMauSac.tenMau}</td>
            <td>${ctsp.idSize.tenSize}</td>
            <td>${ctsp.idCoAo.tenCoAo}</td>
            <td>${ctsp.giaBan}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.trangThai}</td>
            <td>${ctsp.ngayTao}</td>
            <td>${ctsp.ngaySua}</td>
            <td>
                </button> <a href="/ctsp/xoa?id=${ctsp.id}">
                <button class="btn btn-danger">Xóa</button>
            </a>
                <a href="/ctsp/chi-tiet?id=${ctsp.id}">
                    <button class="btn btn-warning">Chi Tiết</button>
                </a>
            </td>
        </tr>

    </c:forEach>

    </tbody>
</table>
<div>
    <nav aria-label="Page navigation example" name="pageNo">
        <ul class="pagination">
            <li class="page-item">
                <c:if test="${currentPage > 0}">
                    <a class="page-link" href="/ctsp/hien-thi?pageNo=${currentPage - 1}">Previous</a>
                </c:if>
            </li>
            <c:forEach var="i" begin="1" end="${page.totalPages}">
                <li class="page-item ${i == currentPage + 1 ? 'active' : ''}">
                    <a class="page-link" href="/ctsp/hien-thi?pageNo=${i - 1}">${i}</a>
                </li>
            </c:forEach>
            <li class="page-item">
                <c:if test="${currentPage < page.totalPages - 1}">
                    <a class="page-link" href="/ctsp/hien-thi?pageNo=${currentPage + 1}">Next</a>
                </c:if>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>