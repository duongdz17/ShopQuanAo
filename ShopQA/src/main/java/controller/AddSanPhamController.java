package controller;

import java.io.IOException;

import dao.SanPhamDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.SanPham;

@WebServlet(urlPatterns = { "/addSanPham" })
public class AddSanPhamController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        String tensanpham = req.getParameter("tensanpham");
	        String mota = req.getParameter("mota");
	        String giaString = req.getParameter("gia");
	        String giamgiaString = req.getParameter("giamgia");
	        String hinhanh = req.getParameter("hinhanh");
	        String madanhmucString = req.getParameter("madanhmuc");
	        String ngaytao = req.getParameter("ngaytao");

	        // Kiểm tra nếu trường "gia" trống
	        if (giaString.isEmpty()) {
	            HttpSession session = req.getSession();
	            session.setAttribute("failedMsg", "Vui lòng nhập giá");
	            resp.sendRedirect("admin/addSanPham.jsp");
	            return; // Kết thúc xử lý nếu có trường nào trống
	        }

	        double gia = Double.parseDouble(giaString);

	        // Kiểm tra nếu trường "giamgia" trống
	        if (giamgiaString.isEmpty()) {
	            HttpSession session = req.getSession();
	            session.setAttribute("failedMsg", "Vui lòng nhập giảm giá");
	            resp.sendRedirect("admin/addSanPham.jsp");
	            return; // Kết thúc xử lý nếu có trường nào trống
	        }

	        double giamgia = Double.parseDouble(giamgiaString);

	        // Kiểm tra nếu trường "madanhmuc" trống
	        if (madanhmucString.isEmpty()) {
	            HttpSession session = req.getSession();
	            session.setAttribute("failedMsg", "Vui lòng nhập mã danh mục");
	            resp.sendRedirect("admin/addSanPham.jsp");
	            return; // Kết thúc xử lý nếu có trường nào trống
	        }

	        int madanhmuc = Integer.parseInt(madanhmucString);

	        SanPham sanPham = new SanPham(0, tensanpham, mota, gia, giamgia, hinhanh, madanhmuc, ngaytao);
	        SanPhamDAO sanPhamDAO = new SanPhamDAO();

	        boolean check = sanPhamDAO.insert(sanPham);

	        HttpSession session = req.getSession();

	        if (tensanpham.isEmpty()) {
	            session.setAttribute("failedMsg", "Vui lòng nhập tên sản phẩm");
	            resp.sendRedirect("admin/addSanPham.jsp");
	            return; // Kết thúc xử lý nếu có trường nào trống
	        }

	        if (mota.isEmpty()) {
	            session.setAttribute("failedMsg", "Vui lòng nhập mô tả");
	            resp.sendRedirect("admin/addSanPham.jsp");
	            return; // Kết thúc xử lý nếu có trường nào trống
	        }

	        if (hinhanh.isEmpty()) {
	            session.setAttribute("failedMsg", "Vui lòng nhập hình ảnh");
	            resp.sendRedirect("admin/addSanPham.jsp");
	            return; // Kết thúc xử lý nếu có trường nào trống
	        }

	        if (ngaytao.isEmpty()) {
	            session.setAttribute("failedMsg", "Vui lòng nhập ngày tạo");
	            resp.sendRedirect("admin/addSanPham.jsp");
	            return; // Kết thúc xử lý nếu có trường nào trống
	        }

	        if (check) {
	            session.setAttribute("succMsg", "Thêm sản phẩm thành công");
	            resp.sendRedirect("admin/listSanPham.jsp");
	        } else {
	            session.setAttribute("failedMsg", "Có gì đó sai sai");
	            resp.sendRedirect("admin/addSanPham.jsp");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
