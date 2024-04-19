package controller;

import java.io.IOException;

import dao.SanPhamDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/deleteSanPham"})
public class DeleteSanPhamController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int masanpham = Integer.parseInt(req.getParameter("masanpham"));
			SanPhamDAO sanPhamDAO = new SanPhamDAO();
			boolean check = sanPhamDAO.delete(masanpham);
			HttpSession session = req.getSession();
			if(check){
				session.setAttribute("succMsg", "Xóa thành công");
				resp.sendRedirect("admin/listSanPham.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/listSanPham.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
