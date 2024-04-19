package controller;

import java.io.IOException;

import dao.AnhNhaTaiTroDAO;
import dao.DanhMucDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AnhNhaTaiTro;
import model.DanhMuc;
@WebServlet(urlPatterns = {"/addAnhNTT"})
public class AddAnhNhaTaiTroController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String tenanh = req.getParameter("tenanh");
			String anhnhatt = req.getParameter("anhnhatt");
			
			AnhNhaTaiTro anhNhaTaiTro = new AnhNhaTaiTro(0, tenanh, anhnhatt);
			AnhNhaTaiTroDAO anhNhaTaiTroDAO = new AnhNhaTaiTroDAO();
			boolean check = anhNhaTaiTroDAO.insert(anhNhaTaiTro);
			
			
			
			HttpSession session = req.getSession();
			if(check) {
				session.setAttribute("succMsg", "Thêm ảnh thành công");
				resp.sendRedirect("admin/listAnhNTT.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/addAnhNTT.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
