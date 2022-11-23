<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.walterkstro.models.Product" %>
<%
    Product product = (Product) request.getAttribute("product");
    boolean isUpdate = (product != null && product.getId() != 0);
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <h1 class="text-center">Register new product</h1>
        </div>
    </div>

    <div class="row mb-5">
        <div class="col col-md-4 offset-md-4">
            <form action="<%= request.getContextPath()%>/cart/new" method="POST">
                <div>
                    <input
                            type="hidden"
                            name="id"
                            value="<%=  isUpdate ? product.getId() : "" %>"
                    >
                </div>
                <div>
                    <label for="description">Description</label>
                    <input
                            type="text"
                            class="form-control"
                            id="description"
                            name="description"
                            value="<%=  isUpdate ? product.getDescription() : "" %>"
                    >
                    <c:if test="${errors.containsKey(\"description\")}">
                        <span class="small text-danger py-1 d-block fw-bolder" role="alert">
                                <c:out value="${errors.get(\"description\")}"/>
                        </span>
                    </c:if>
                </div>
                <div>
                    <label for="price">Price</label>
                    <input
                            type="text"
                            class="form-control"
                            id="price"
                            name="price"
                            value="<%=  isUpdate ? product.getPrice() : "" %>"
                    >
                    <c:if test="${errors.containsKey(\"price\")}">
                        <span class="small text-danger py-1 d-block fw-bolder" role="alert">
                                <c:out value="${errors.get(\"price\")}"/>
                        </span>
                    </c:if>
                </div>
                <div>
                    <label for="category">Category</label>
                    <select class="form-select" id="category" name="category">
                        <option selected>Select one category</option>
                        <c:forEach var="category" items="${categories}">
                            <option value="${ category.id }"  ${category.id == product.getCategory().getId() ? "selected" : null } >${category.name}</option>
                        </c:forEach>
                    </select>
                    <c:if test="${errors.containsKey(\"category\")}">
                            <span class="small text-danger py-1 d-block fw-bolder" role="alert">
                                    <c:out value="${errors.get(\"category\")}"/>
                            </span>
                    </c:if>
                </div>
                <div>
                    <button type="submit" class="btn btn-info">Register</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
