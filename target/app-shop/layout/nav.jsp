<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="${pageContext.request.contextPath}/assets/logo.svg" alt="my brand">
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarScroll">
      <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/products">Products</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath()%>/product/new">Create</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Account
          </a>
          <ul class="dropdown-menu">
            <li class="${not empty sessionScope.username ? 'd-none' : 'd-block'}"><a class="dropdown-item" href="${pageContext.request.contextPath}/login">Login</a></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/cart/me">My cart</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>