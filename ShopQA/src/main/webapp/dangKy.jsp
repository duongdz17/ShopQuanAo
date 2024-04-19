<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<c:url value="/UserAssets" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<%@include file="phantachlayout/css.jsp" %>
</head>
<body>
<%@include file="phantachlayout/header.jsp" %>
<div class="container p-2">
		<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
					<h4 class="text-center">Đăng ký tài khoản</h4>
					
					<c:if test="${not empty succMsg }">
						<p class="alert alert-success text-center" role="alert">${succMsg}</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>

					<c:if test="${not empty failedMsg }">
						<p class="alert alert-danger text-center" role="alert">${failedMsg}</p>
						<c:remove var="failedMsg" scope="session" />
					</c:if>
					<form name="registrationForm" action="dangKyKhachHang" method="post" onsubmit="return validateForm()">
						<div class="mb-3">
							<label>Họ tên:</label> <input type="text" class="form-control"
								 name="hoten">
						</div>
						<div class="mb-3">
							<label>Tên đăng nhập:</label> <input type="text"
								class="form-control"  name="tendangnhap">
						</div>
						<div class="mb-3">
							<label>Mật khẩu:</label> <input type="password"
								class="form-control"  name="matkhau">
						</div>
						<div class="mb-3">
							<label>Email:</label> <input type="text" class="form-control"
								 name="email">
						</div>
						<div class="mb-3">
							<label>Số điện thoại:</label> <input type="number"
								class="form-control"  name="sodienthoai">
						</div>

						<div class="mb-3">
							<label>Đia chỉ:</label> <input type="text" class="form-control"
								 name="diachi">
						</div>
						
						<div class="mb-3">
							<label>Ngày sinh:</label> <input type="date" class="form-control"
								 name="ngaysinh">
						</div>

						<div class="mb-3" hidden="">
							<label>Quyền truy cập:</label> <input type="number" class="form-control"
								readonly="readonly" value="2" required="required" name="maquyentruycap">
						</div>

						
						<button type="submit" class="btn btn-primary">Hoàn tất</button> |
						<a href="dangNhap.jsp" class="btn btn-light">Quay lại</a>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
    function validateForm() {
    	  var hoTen = document.forms["registrationForm"]["hoten"].value;
    	    var tenDangNhap = document.forms["registrationForm"]["tendangnhap"].value;
    	    var matKhau = document.forms["registrationForm"]["matkhau"].value;
    	    var email = document.forms["registrationForm"]["email"].value;
    	    var soDienThoai = document.forms["registrationForm"]["sodienthoai"].value;
    	    var diaChi = document.forms["registrationForm"]["diachi"].value;
    	    var ngaySinh = document.forms["registrationForm"]["ngaysinh"].value;
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (hoTen == "" && tenDangNhap == "" && matKhau == "" && email == "" && soDienThoai == "" && diaChi == "" && ngaySinh == "") {
            alert("Vui lòng điền đầy đủ thông tin vào tất cả các trường.");
            return false;
        }
        if (!emailRegex.test(email)) {
            alert("Định dạng email không hợp lệ!");
            return false;
        }
       
        
        return true;
    }
</script>
	
</body>
</html>