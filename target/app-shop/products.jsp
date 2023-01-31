<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="layout/header.jsp"/>

<div class="row">
        <div class="col">
          <h1 class="text-center">List of products</h1>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <table class="table table-bordered table-responsive table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Description</th>
                    <th scope="col">Category</th>
                    <c:if test="${auth}">
                        <th scope="col">Price</th>
                        <th scope="col">Buy</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.description}</td>
                        <td>${product.category.getName()}</td>
                        <c:if test="${auth}">
                            <td>${product.formatCurrency()}</td>
                            <td><a href="<%= request.getContextPath()%>/cart/add?id=${product.id}"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="10" cy="20.5" r="1"/><circle cx="18" cy="20.5" r="1"/><path d="M2.5 2.5h3l2.7 12.4a2 2 0 0 0 2 1.6h7.7a2 2 0 0 0 2-1.6l1.6-8.4H7.1"/></svg></a></td>
                            <td><a href="<%= request.getContextPath()%>/product/new?id=${product.id}"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><polygon points="14 2 18 6 7 17 3 17 3 13 14 2"></polygon><line x1="3" y1="22" x2="21" y2="22"></line></svg></a></td>
                            <td><a onclick="return confirm('Desea eliminar este producto?')" href="<%= request.getContextPath()%>/product/delete?id=${product.id}"><?xml version="1.0" encoding="UTF-8"?><svg width="24px" height="24px" viewBox="0 0 24 24" stroke-width="1.5" fill="none" xmlns="http://www.w3.org/2000/svg" color="#000000"><path d="M2.87 21.121L4.993 19m2.121-2.121L4.993 19m0 0L2.87 16.879M4.992 19l2.121 2.121M7 2h9.5L21 6.5V19" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path><path d="M11 22h5.5a1.5 1.5 0 001.5-1.5V8.749a.6.6 0 00-.176-.425l-3.148-3.148A.6.6 0 0014.25 5H4.5A1.5 1.5 0 003 6.5V13" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path><path d="M14 5v3.4a.6.6 0 00.6.6H18" stroke="#000000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path></svg></a></td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
<jsp:include page="layout/footer.jsp"/>
