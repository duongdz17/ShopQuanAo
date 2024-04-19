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
@WebServlet(urlPatterns = {"/updateSanPham"})
public class UpdateSanPhamController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int masanpham = Integer.parseInt(req.getParameter("masanpham"));
			String tensanpham = req.getParameter("tensanpham");
			String mota = req.getParameter("mota");
			double gia = Double.parseDouble(req.getParameter("gia"));
			double giamgia = Double.parseDouble(req.getParameter("giamgia"));
			String hinhanh = req.getParameter("hinhanh");
			int madanhmuc = Integer.parseInt(req.getParameter("madanhmuc"));
			String ngaytao = req.getParameter("ngaytao");
			
			SanPham sanPham = new SanPham();
			sanPham.setMasanpham(masanpham);
			sanPham.setTensanpham(tensanpham);
			sanPham.setMota(mota);
			sanPham.setGia(gia);
			sanPham.setGiamgia(giamgia);
			sanPham.setHinhanh(hinhanh);
			sanPham.setMadanhmuc(madanhmuc);
			sanPham.setNgaytao(ngaytao);
			
		
			SanPhamDAO sanPhamDAO = new SanPhamDAO();
			boolean check = sanPhamDAO.update(sanPham);
			
			HttpSession session = req.getSession();
			 
			if(check){
				session.setAttribute("succMsg", "Cập nhật thành công");
				resp.sendRedirect("admin/listSanPham.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/updateSanPham.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
