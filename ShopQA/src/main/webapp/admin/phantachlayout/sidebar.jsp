<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Sidebar Start -->
    <aside class="left-sidebar">
      <!-- Sidebar scroll-->
      <div>
        <div class="brand-logo d-flex align-items-center justify-content-between" style="background-color: #EECBAD">
          <a href="index.jsp" class="text-nowrap logo-img">
            <h1>Quản trị viên</h1>
          </a>
          <div class="close-btn d-xl-none d-block sidebartoggler cursor-pointer" id="sidebarCollapse">
            <i class="ti ti-x fs-8"></i>
          </div>
        </div>
        <!-- Sidebar navigation-->
        <nav class="sidebar-nav scroll-sidebar" data-simplebar="" style="background-color: #CDAF95">
          <ul id="sidebarnav">
            
            <li class="nav-small-cap">
              <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
              <span class="hide-menu">Danh sách quản lý</span>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="listDanhMuc.jsp" aria-expanded="false">
                <span>
                  <i class="fa-solid fa-bars"></i>
                </span>
                <span class="hide-menu">Quản lý danh mục</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="listSanPham.jsp" aria-expanded="false">
                <span>
                  <i class="fa-solid fa-shirt"></i>
                </span>
                <span class="hide-menu">Quản lý sản phẩm</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="listAnhNTT.jsp" aria-expanded="false">
                <span>
                  <i class="fa-solid fa-image"></i>
                </span>
                <span class="hide-menu">Quản lý ảnh nhà tài trợ</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="listUser.jsp" aria-expanded="false">
                <span>
                  <i class="fa-solid fa-user"></i>
                </span>
                <span class="hide-menu">Quản lý người dùng</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="listQuyenTruyCap.jsp" aria-expanded="false">
                <span>
                  <i class="fa-solid fa-lock"></i>
                </span>
                <span class="hide-menu">Quản lý quyền truy cập</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="listDonHang.jsp" aria-expanded="false">
                <span>
                  <i class="ti ti-file-description"></i>
                </span>
                <span class="hide-menu">Quản lý đơn hàng</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="listFeedback.jsp" aria-expanded="false">
                <span>
                  <i class="fa-solid fa-message"></i>
                </span>
                <span class="hide-menu">Phản hồi của người dùng</span>
              </a>
            </li>
            <li class="nav-small-cap">
            <a href="/ShopQA/index.jsp" style="color: black">
              <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
              <span class="hide-menu">Trở về trang người dùng</span>
              </a>
            </li>
            
          </ul>
          
        </nav>
        <!-- End Sidebar navigation -->
      </div>
      <!-- End Sidebar scroll-->
    </aside>
    <!--  Sidebar End -->