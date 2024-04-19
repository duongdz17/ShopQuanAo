package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/dangxuatadmin"})
public class DangXuatAdminController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			session.removeAttribute("admin");
			
			HttpSession session2 = req.getSession();
			session.setAttribute("succMsg", "Đăng xuất thành công");
			resp.sendRedirect("/ShopQA/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
