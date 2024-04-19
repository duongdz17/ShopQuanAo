<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/UserAssets" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hồ sơ người dùng</title>
<%@include file="phantachlayout/css.jsp" %>
</head>
<body>
<%@include file="phantachlayout/header.jsp" %>
<!-- Checkout Start -->
<c:if test="${not empty succMsg }">
						<p class="alert alert-success text-center" role="alert">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>

					<c:if test="${not empty failedMsg }">
						<p class="alert alert-danger text-center" role="alert">${failedMsg}</p>
						<c:remove var="failedMsg" scope="session" />
					</c:if>
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-8">
                <div class="mb-4">
                    <h4 class="font-weight-semi-bold mb-4">Profile</h4>
                    <form action="updateprofile" method="post">
                    <input hidden="" value="${khachhang.userid }" name="userid">
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label>Họ tên</label>
                            <input class="form-control" type="text" name="hoten" value="${khachhang.hoten }">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Email</label>
                            <input class="form-control" type="email" name="email" value="${khachhang.email}">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Số điện thoại</label>
                            <input class="form-control" type="number" name="sodienthoai" value="${khachhang.diachi}">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Địa chỉ</label>
                            <input class="form-control" type="text" name="diachi" value="${khachhang.ngaysinh }">
                        </div>
                        
                       
						<div class="col-12">
							<button type="submit" class="btn btn-primary">Cập nhật thông tin</button>
							
						</div>
					</div>
					</form>
                </div>
                
            </div>
            
        </div>
    </div>
    <!-- Checkout End -->
    <%@include file="phantachlayout/footer.jsp" %>
</body>
</html>