<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>App store | Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col">
            <h1 class="text-center">Your cart</h1>
        </div>
    </div>
    <div class="row">
        <div class="col col-md-6 offset-md-3">
            <c:choose>
                <c:when test="${isAuth}">

                    <table class="table table-bordered">
                        <caption class="text-end fs-5 lead">Total:  <strong>${total}</strong></caption>
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Description</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Price</th>
                            <th scope="col">Subtotal</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${cart}">
                            <tr>
                                <td>${item.getProduct().id}</td>
                                <td>${item.getProduct().description}</td>
                                <td>${item.quantity}</td>
                                <td>${item.getProduct().price}</td>
                                <td>${item.subTotal()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <a href="<%=request.getContextPath()%>/products" class="btn btn-success">Continue buy</a>
                </c:when>
                <c:otherwise>
                    <h1>Usted no esta <a href="<%=request.getContextPath()%>/login.html">Autenticado</a></h1>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
