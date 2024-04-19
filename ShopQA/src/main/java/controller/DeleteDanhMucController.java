package controller;

import java.io.IOException;

import dao.DanhMucDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/deleteDanhMuc"})
public class DeleteDanhMucController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int madanhmuc = Integer.parseInt(req.getParameter("madanhmuc"));
			DanhMucDAO danhMucDAO = new DanhMucDAO();
			boolean check = danhMucDAO.delete(madanhmuc);
			HttpSession session = req.getSession();
			if(check){
				session.setAttribute("succMsg", "Xóa thành công");
				resp.sendRedirect("admin/listDanhMuc.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/listDanhMuc.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
