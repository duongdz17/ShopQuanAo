package controller;

import java.io.IOException;

import dao.DanhMucDAO;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/deleteUser"})
public class DeleteUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int userid = Integer.parseInt(req.getParameter("userid"));
			UserDAO userDAO = new UserDAO();
			boolean check = userDAO.delete(userid);
			
			HttpSession session = req.getSession();
			if(check){
				session.setAttribute("succMsg", "Xóa thành công");
				resp.sendRedirect("admin/listUser.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/listUser.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
