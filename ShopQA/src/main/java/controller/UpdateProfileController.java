package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
@WebServlet(urlPatterns = {"/updateprofile"})
public class UpdateProfileController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int userid = Integer.parseInt(req.getParameter("userid"));
			String hoten = req.getParameter("hoten");
			String email = req.getParameter("email");
			String sodienthoai = req.getParameter("sodienthoai");
			String diachi = req.getParameter("diachi");
			
			
			
			User user = new User();
			user.setUserid(userid);
			user.setHoten(hoten);
			user.setEmail(email);
			user.setSodienthoai(sodienthoai);
			user.setDiachi(diachi);
			
			HttpSession session = req.getSession();
			UserDAO userDAO = new UserDAO();
			
			
				boolean check2 = userDAO.updateProfile(user);
				if(check2) {
					session.setAttribute("succMsg", "Update thành công");
					resp.sendRedirect("profileKhachHang.jsp");
				}else {
					session.setAttribute("failedMsg", "Update thất bại");
					resp.sendRedirect("profileKhachHang.jsp");
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
