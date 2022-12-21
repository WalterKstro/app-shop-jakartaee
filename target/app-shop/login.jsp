<jsp:include page="layout/header.jsp"/>
  <div class="row">
    <div class="col">
      <h1 class="text-center">Log In</h1>
    </div>
  </div>
  <div class="row">
    <div class="col col-md-4 offset-md-4">
      <form method="POST" action="/app-shop/login">
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Correo</label>
          <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
        </div>
        <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label">Password</label>
          <input type="password" class="form-control" id="exampleInputPassword1" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>
  </div>
<jsp:include page="layout/footer.jsp"/>