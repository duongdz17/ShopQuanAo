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
@WebServlet(urlPatterns = {"/deleteAnhNTT"})
public class DeleteAnhNhaTaiTroController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int maanhntt = Integer.parseInt(req.getParameter("maanhntt"));
			AnhNhaTaiTroDAO anhNhaTaiTroDAO = new AnhNhaTaiTroDAO();
			boolean check = anhNhaTaiTroDAO.delete(maanhntt);
			
			HttpSession session = req.getSession();
			if(check){
				session.setAttribute("succMsg", "Xóa thành công");
				resp.sendRedirect("admin/listAnhNTT.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/listAnhNTT.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
