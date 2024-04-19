<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/assets" var="url"></c:url>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <%@include file="phantachlayout/css.jsp" %>
  <title>Trang quản trị</title>
  
</head>

<body style="background-color: #A9A9A9">
  <!--  Body Wrapper -->
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <c:if test="${not empty succMsg }">
							<p class="alert alert-success text-center" role="alert">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<c:if test="${not empty failedMsg }">
							<p class="alert alert-danger text-center" role="alert">${failedMsg}</p>
							<c:remove var="failedMsg" scope="session" />
						</c:if>
    <%@include file="phantachlayout/sidebar.jsp" %>
    <!--  Main wrapper -->
    <div class="body-wrapper">
      <%@include file="phantachlayout/header.jsp" %>
      
        <%@include file="phantachlayout/footer.jsp" %>
      </div>
    </div>

  <script src="${url}/libs/jquery/dist/jquery.min.js"></script>
  <script src="${url}/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="${url}/js/sidebarmenu.js"></script>
  <script src="${url}/js/app.min.js"></script>
  <script src="${url}/libs/apexcharts/dist/apexcharts.min.js"></script>
  <script src="${url}/libs/simplebar/dist/simplebar.js"></script>
  <script src="${url}/js/dashboard.js"></script>
</body>

</html>