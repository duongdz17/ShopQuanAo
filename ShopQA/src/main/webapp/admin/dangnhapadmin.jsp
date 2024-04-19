<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/assets" var="url"></c:url>

<!doctype html>
<html lang="en">

<head>
<meta charset="UTF-8">
<%@include file="phantachlayout/css.jsp"%>
<title>Đăng nhập Admin</title>
</head>

<body style="background-color: #9C9C9C">
  <!--  Body Wrapper -->
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <div
      class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div class="card mb-0">
              <div class="card-body">
                	<h3 class="text-center">XIN CHÀO ADMIN</h3>
                <p class="text-center">Vui lòng đăng nhập</p>
								<c:if test="${not empty succMsg }">
									<p class="alert alert-success text-center" role="alert">${succMsg}</p>
									<c:remove var="succMsg" scope="session" />
								</c:if>
								<c:if test="${not empty failedMsg }">
									<p class="alert alert-danger text-center" role="alert">${failedMsg}</p>
									<c:remove var="failedMsg" scope="session" />
								</c:if>
								<form action="../dangnhapadmin" method="post">
                  <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Tên đăng nhập</label>
                    <input type="text" name="tendangnhap" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="mb-4">
                    <label for="exampleInputPassword1" class="form-label">Mật khẩu</label>
                    <input type="password" name="matkhau" class="form-control" id="exampleInputPassword1">
                  </div>
                  
                  
                  <button type="submit" class="btn btn-danger w-100 py-8 fs-4 mb-4 rounded-2">Đăng nhập</button>
                  
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="${url}/libs/jquery/dist/jquery.min.js"></script>
  <script src="${url}/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>