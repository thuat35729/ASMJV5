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
    <title>Chi Tiet San Pham</title>
</head>

<body>
<div class="row">
    <h1 class="text-center">Thông tin chi tiết sản phẩm</h1>
    <form action="/san-pham/update?id=${listsp.id}" method="post">
        <p>Ma San Pham</p>
        <input type="text" name="maSP" value="${listsp.maSP}" class="form-control"><br>
        <p>Ten San Pham</p>
        <input type="text" name="tenSP" value="${listsp.tenSP}" class="form-control"><br>
        <p>Trang Thai</p>
        <input type="text" name="trangThai" value="${listsp.trangThai}" class="form-control"><br>
        <p>Ma Danh Muc</p>
        <select name="idDanhMuc" class="form-control">
            <c:forEach items="${listdm}" var="dm">
                <option value="${dm.id}" <c:if test="${listsp.idDanhMuc.id == dm.id}">selected</c:if>>
                        ${dm.tenDanhMuc}
                </option>
            </c:forEach>
        </select>
        <button type="submit" class="btn btn-success">UPDATE</button>
    </form>
</div>
</body>
</html>