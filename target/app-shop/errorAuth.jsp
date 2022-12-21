<jsp:include page="layout/header.jsp"/>
<%@ page contentType="text/html; charset=UTF-8" %>
    <div class="row">
        <div class="col offset-md-3 col-md-6">
            <h1 class="text-center">Error usuario y/o contraseña, es incorrecta</h1>
            <a href="<%= request.getContextPath() %>/login" class="btn btn-info d-block">Regresar</a>
        </div>
    </div>
<jsp:include page="layout/footer.jsp"/>
