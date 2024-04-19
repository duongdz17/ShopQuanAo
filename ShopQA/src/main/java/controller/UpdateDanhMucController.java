package controller;

import java.io.IOException;

import dao.DanhMucDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DanhMuc;
@WebServlet(urlPatterns = {"/updateDanhMuc"})
public class UpdateDanhMucController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int madanhmuc = Integer.parseInt(req.getParameter("madanhmuc"));
			String tenDanhMuc = req.getParameter("tendanhmuc");
			String anhDanhMuc = req.getParameter("anhdanhmuc");
			
			DanhMuc danhMuc = new DanhMuc();
			danhMuc.setMadanhmuc(madanhmuc);;
			danhMuc.setTendanhmuc(tenDanhMuc);
			danhMuc.setAnhdanhmuc(anhDanhMuc);
		
			DanhMucDAO danhMucDAO = new DanhMucDAO();
			boolean check = danhMucDAO.update(danhMuc);
			
			HttpSession session = req.getSession();
			if(check){
				session.setAttribute("succMsg", "Cập nhật thành công");
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
