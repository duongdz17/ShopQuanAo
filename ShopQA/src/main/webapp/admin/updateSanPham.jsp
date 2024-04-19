<%@page import="model.SanPham"%>
<%@page import="dao.SanPhamDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/admin/assets" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="phantachlayout/css.jsp"%>
    <title>Quản lý sản phẩm</title>
    
</head>
<body>
    <div class="page-wrapper" id="main-wrapper" data-layout="vertical"
        data-navbarbg="skin6" data-sidebartype="full"
        data-sidebar-position="fixed" data-header-position="fixed">
        <%@include file="phantachlayout/sidebar.jsp"%>

        <div class="body-wrapper">
            <%@include file="phantachlayout/header.jsp"%>

            <div class="container-fluid">
                <div class="container-fluid">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title fw-semibold mb-4">Cập nhật sản phẩm</h5>
                            <c:if test="${not empty succMsg}">
                                <p class="alert alert-success text-center" role="alert">${succMsg}</p>
                                <c:remove var="succMsg" scope="session" />
                            </c:if>
                            <c:if test="${not empty failedMsg}">
                                <p class="alert alert-danger text-center" role="alert">${failedMsg}</p>
                                <c:remove var="failedMsg" scope="session" />
                            </c:if>

                            <%-- Lấy thông tin sản phẩm từ cơ sở dữ liệu --%>
                            <%
                                int masanpham = Integer.parseInt(request.getParameter("masanpham"));
                                SanPhamDAO sanPhamDAO = new SanPhamDAO();
                                SanPham sanPham = sanPhamDAO.getSanPhamById(masanpham);
                            %>
                            <div class="card">
                                <div class="card-body p-4">
<form name="updateForm" action="../updateSanPham" class="row g-3" method="post" onsubmit="return validateForm()">
                                        <div class="col-12" hidden="">
                                            <label>Mã sản phẩm</label>
                                            <input type="number" readonly="readonly" name="masanpham"  value="<%=sanPham.getMasanpham() %>" class="form-control" />
                                        </div>
                                        <div class="col-12">
                                            <label>Tên sản phẩm</label>
                                            <input type="text" name="tensanpham" value="<%=sanPham.getTensanpham() %>"  class="form-control" />
                                        </div>
                                        <div class="col-12">
                                            <label>Mô tả</label>
                                            <input type="text" name="mota" value="<%=sanPham.getMota() %>"  class="form-control" />
                                        </div>
                                        <div class="col-12">
                                            <label>Giá</label>
                                            <input type="number" name="gia" value="<%=sanPham.getGia() %>"  class="form-control" />
                                        </div>
                                        <div class="col-12">
                                            <label>Giảm giá</label>
                                            <input type="number" name="giamgia" value="<%=sanPham.getGiamgia() %>" class="form-control" />
                                        </div>
                                        <div class="col-12">
                                            <label>Hình ảnh</label>
                                            <input type="text" name="hinhanh" value="<%=sanPham.getHinhanh() %>"  class="form-control" />
                                        </div>
                                        <div class="col-12">
                                            <label>Mã danh mục</label>
                                            <input type="number" name="madanhmuc" value="<%=sanPham.getMadanhmuc() %>"  class="form-control" />
                                        </div>
                                        <div class="col-12">
                                            <label>Ngày tạo</label>
                                            <input type="date" name="ngaytao" value="<%=sanPham.getNgaytao() %>"  class="form-control" />
                                        </div>
                                        
                                        <div class="col-12">
                                            <button type="submit" class="btn btn-primary">Cập nhật</button> |
                                            <a href="listSanPham.jsp" class="btn btn-secondary">Quay lại</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
    function validateForm() {
        var tensanpham = document.forms["updateForm"]["tensanpham"].value;
        var mota = document.forms["updateForm"]["mota"].value;
        var gia = document.forms["updateForm"]["gia"].value;
        var giamgia = document.forms["updateForm"]["giamgia"].value;
        var hinhanh = document.forms["updateForm"]["hinhanh"].value;
        var madanhmuc = document.forms["updateForm"]["madanhmuc"].value;
        var ngaytao = document.forms["updateForm"]["ngaytao"].value;

        if (tensanpham == "" || mota == "" || gia == "" || giamgia == "" || hinhanh == "" || madanhmuc == "" || ngaytao == "") {
            alert("Vui lòng nhập đầy đủ thông tin sản phẩm");
            return false;
        }
    }
</script>
    
</body>
</html>
