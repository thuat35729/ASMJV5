<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<h1 class="text-center">Thông tin chi tiết hóa đơn</h1>
<table class="table">
    <thead>
    <tr>
        <td>
            ID hóa đơn
        </td>
        <td>
            Tên sản phẩm
        </td>
        <td>
            Số lượng
        </td>
        <td>
            Giá bán
        </td>
        <td>
            Tổng tiền
        </td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listHDCT}" var="hdct">
        <tr>
            <td>
                    ${hdct.idHoaDon.id}
            </td>
            <td>
                    ${hdct.idCtsp.idSanPham.tenSP}
            </td>
            <td>
                    ${hdct.soLuong}
            </td>
            <td>
                    ${hdct.giaBan}
            </td>
            <td>
                    ${hdct.tongTien}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="text-sm-end">
    <h2 class="badge text-bg-primary text-wrap fs-5" style="width: 20rem; height: 3rem">
        Tổng tiền hóa đơn: ${tongTienHoaDon}
    </h2>
</div>