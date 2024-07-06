<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<%--<form method="get" action="/home/viewSP">--%>
<%--    <button type="submit" class="view" name="view" value="submit">Hien thi</button>--%>
<%--</form>--%>
<%--<c:if test="${view == 'submit'}">--%>
<body>
<%--<form:form></form:form>--%>
<form action="/san-pham/add" method="post">
    <p>Ma San Pham</p>
    <input type="text" name="maSP" class="form-control"><br>
    <p>Ten San Pham</p>
    <input type="text" name="tenSP" class="form-control"><br>
    <p>Trang Thai</p>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault1" value="Active">
        <label class="form-check-label" for="flexRadioDefault1">
            Active
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="trangThai" id="flexRadioDefault2" checked value="Inactive">
        <label class="form-check-label" for="flexRadioDefault2">
            Inactive
        </label>
    </div>
    <p>Ma Danh Muc</p>
    <select name="idDanhMuc" class="form-control">
        <c:forEach items="${listdm}" var="dm">
            <option value="${dm.id}">
                    ${dm.tenDanhMuc}
            </option>
        </c:forEach>
    </select>
    <button type="submit" class="btn btn-success">ADD</button>

</form>
<table border="2" class="table">
    <thead>
    <tr>
        <td>STT</td>
        <td>id</td>
        <td>Mã sản phẩm</td>
        <td>Tên sản phẩm</td>
        <td>Trạng thái</td>
        <td>Ngày tạo</td>
        <td>Ngày sửa</td>
        <td>Tên danh mục</td>
        <td>Mã danh mục</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page}" var="sp" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${sp.id}</td>
            <td>${sp.maSP}</td>
            <td>${sp.tenSP}</td>
            <td>${sp.trangThai}</td>
            <td>${sp.ngayTao}</td>
            <td>${sp.ngaySua}</td>
            <td>${sp.idDanhMuc.tenDanhMuc}</td>
            <td>${sp.idDanhMuc.maDanhMuc}</td>
            <td>
                <a href="/san-pham/delete?id=${sp.id}">
                    <button class="btn btn-primary">Delete</button>
                </a>
                <a href="/san-pham/detail?id=${sp.id}">
                    <button class="btn btn-warning">Update</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    <%--    <div>--%>
    <%--        <a href="/san-pham/view?pageNo=0"> |&lt; </a>--%>
    <%--        <a href="/san-pham/view?pageNo=${page.number - 1}" <c:if test="${page.number == 0}">class="disabled"</c:if>> &lt;&lt; </a>--%>
    <%--        <a href="/san-pham/view?pageNo=${page.number + 1}"--%>
    <%--           <c:if test="${page.number + 1 >= page.totalPages}">class="disabled"</c:if>> &gt;&gt; </a>--%>
    <%--        <a href="/san-pham/view?pageNo=${page.totalPages - 1}"> &gt;| </a>--%>
    <%--    </div>--%>
    <div>
        <nav aria-label="Page navigation example" name="pageNo">
            <ul class="pagination">
                <li class="page-item">
                    <c:if test="${currentPage > 0}">
                        <a class="page-link" href="/san-pham/view?pageNo=${currentPage - 1}">Previous</a>
                    </c:if>
                </li>
                <c:forEach var="i" begin="1" end="${totalPage}">
                    <li class="page-item ${i == currentPage + 1 ? 'active' : ''}">
                        <a class="page-link" href="/san-pham/view?pageNo=${i - 1}">${i}</a>
                    </li>
                </c:forEach>
                <li class="page-item">
                    <c:if test="${currentPage < totalPage - 1}">
                        <a class="page-link" href="/san-pham/view?pageNo=${currentPage + 1}">Next</a>
                    </c:if>
                </li>
            </ul>
        </nav>
    </div>
    </tbody>
</table>
</body>
</html>