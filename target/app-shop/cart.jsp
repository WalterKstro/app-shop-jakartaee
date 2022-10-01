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
        <div class="col col-md-8 offset-md-2">
            <c:choose>
                <c:when test="${isAuth}">
                    <form action="<%=request.getContextPath()%>/update" method="POST" id="form">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Description</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Price</th>
                                <th scope="col">Subtotal</th>
                                <th scope="col">Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${cart}">
                                <tr>
                                    <td>
                                        ${item.getProduct().id}
                                    </td>
                                    <td>${item.getProduct().description}</td>
                                    <td class="w-25">
                                        <input type="number" class="form-control" value="${item.quantity}" name="quantity_${item.getProduct().id}">
                                    </td>
                                    <td>${item.getProduct().formatCurrency()}</td>
                                    <td>${item.formatCurrency()}</td>
                                    <td>
                                        <input class="form-check-input" type="checkbox" value="${item.getProduct().id}" name="delete_${item.getProduct().id}">
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr class="table-dark">
                                <td>Total</td>
                                <td colspan="5" class="text-end">${total}</td>
                            </tr>
                            </tbody>
                        </table>
                    </form>

                    <a href="<%=request.getContextPath()%>/products" class="btn btn-success">Continue buying</a>
                    <button class="btn btn-success" id="submit">Update cart</button>
                </c:when>
                <c:otherwise>
                    <h1 class="text-center">You don't have items <a href="<%=request.getContextPath()%>/products">Buy</a></h1>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/js/index.js"></script>
</body>
</html>
