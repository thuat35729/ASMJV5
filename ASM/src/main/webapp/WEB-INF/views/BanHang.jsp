<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="row">
    <div class="col-7">
        <h2>Danh sách hoá đơn</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten khach hang</td>
                <td>Ngay tao</td>
                <td>Trang Thai</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listhd}" var="hd" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${hd.id}</td>
                    <td>${hd.id_khachHang.hoTen}</td>
                    <td>${hd.ngayTao}</td>
                    <td>${hd.trangThai}</td>
                    <td>
                        <a href="/ban-hang/viewhdct?id=${hd.id}"><button class="btn btn-info">Chon</button></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <h2>Danh sách hoá đơn chi tiết</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten san pham</td>
                <td>So luong</td>
                <td>Gia ban</td>
                <td>Tong tien</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach varStatus="i" var="hdct" items="${listhdct}">
                <tr>
                    <td>${i.index +1}</td>
                    <td>${hdct.id}</td>
                    <td>${hdct.id_ctsp.id_sanPham.tenSP}</td>
                    <td>${hdct.soLuong}</td>
                    <td>${hdct.id_ctsp.giaBan}</td>
                    <td>${hdct.tongTien}</td>
                    <td><button class="btn btn-danger">DELETE</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-5">
        <h2>Tạo hoá đơn</h2>
        <div class="row">
            <div>
                <div>
                    <label class="mb-3 col-3">Số điện thoại</label>
                    <input type="text" class="col-7">
                </div>
                <button class="btn btn-primary">Search</button>
            </div>
            <div class="mb-3">
                <label class="col-3">Ten Khach hang</label>
                <input type="text" class="col-7" readonly>
            </div>
            <div class="mb-3">
                <label class="col-3">ID Hoa don</label>
                <input type="text" class="col-7" readonly>
            </div>
            <div class="mb-3">
                <label class="col-3">Tong tien</label>
                <input type="text" class="col-7" readonly>
            </div>
            <div>
                <button class="btn btn-primary">Tạo hoá đơn</button>
                <button class="btn btn-primary">Thanh toán</button>
            </div>
        </div>

    </div>
</div>
<div>
    <h2>Danh sách chi tiết sản phẩm</h2>
    <table class="table">
        <thead>
        <tr>
            <td>STT</td>
            <td>ID CTSP</td>
            <td>Ten san pham</td>
            <td>Mau sac</td>
            <td>Size</td>
            <td>Gia ban</td>
            <td>So luong ton</td>
            <td>Trang Thai</td>
            <td>Chuc nang</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listctsp}" var="ctsp" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${ctsp.id}</td>
            <td>${ctsp.id_sanPham.tenSP}</td>
            <td>${ctsp.id_mauSac.tenMau}</td>
            <td>${ctsp.giaBan}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.trangThai}</td>
            <td>Chua thanh toan</td>
            <td>
                <button class="btn btn-primary">Chọn mua</button>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>