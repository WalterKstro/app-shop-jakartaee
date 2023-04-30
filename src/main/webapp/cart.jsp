<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="layout/header.jsp"/>
    <div class="row">
        <div class="col col-md-10 offset-md-1">
            <c:choose>
                <c:when test="${cart.list.isEmpty()}">
                    <h1 class="text-center">You don't have items <a href="<%=request.getContextPath()%>/products">Buy</a></h1>
                </c:when>
                <c:otherwise>
                    <form action="<%=request.getContextPath()%>/cart/update" method="POST" id="form">
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
                            <c:forEach var="item" items="${cart.list}">
                                <tr>
                                    <td>${item.product.id}</td>
                                    <td>${item.product.description}</td>
                                    <td class="w-25">
                                        <input type="number" class="form-control" value="${item.quantity}" name="quantity_${item.product.id}">
                                    </td>
                                    <td>${item.product.formatCurrency()}</td>
                                    <td>${item.formatCurrency()}</td>
                                    <td>
                                        <input class="form-check-input" type="checkbox" value="${item.product.id}" name="delete_${item.product.id}">
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr class="table-dark">
                                <td>Total</td>
                                <td colspan="5" class="text-end">${cart.formatCurrency()}</td>
                            </tr>
                            </tbody>
                        </table>
                    </form>

                    <div class="d-flex gap-4">
                        <a href="<%=request.getContextPath()%>/products" class="btn btn-success btn-sm">Continue buying</a>
                        <button class="btn btn-sm btn-outline-success" id="submit">Update cart</button>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

<jsp:include page="layout/footer.jsp"/>