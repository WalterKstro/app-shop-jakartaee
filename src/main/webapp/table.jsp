<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
          <h1 class="text-center">List of products</h1>
        </div>
    </div>

    <div class="row mb-5">
        <div class="col">
            <c:choose>
                <c:when test="${auth}">
                    <div class="d-flex justify-content-between">
                        <p>Hola bienvenido <span class="badge text-bg-primary">${user}</span></p>
                        <a href="<%= request.getContextPath() %>/logout" class="btn btn-danger">Cerrar sessión</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <p>Usted no esta <a href="/app-shop/login.html">autenticado</a></p>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Description</th>
                    <th scope="col">Category</th>
                    <c:if test="${auth}">
                        <th scope="col">Price</th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.description}</td>
                        <td>${product.type}</td>
                        <c:if test="${auth}">
                            <td>${product.price}</td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
