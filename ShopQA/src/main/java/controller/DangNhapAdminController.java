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
@WebServlet(urlPatterns = {"/dangnhapadmin"})
public class DangNhapAdminController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserDAO userDAO = new UserDAO();
			HttpSession session = req.getSession();
			
			String tendangnhap = req.getParameter("tendangnhap");
			String matkhau = req.getParameter("matkhau");
			
			 // Kiểm tra xem các trường đăng nhập có trống không
            if (tendangnhap.isEmpty() ) {
                session.setAttribute("failedMsg", "Vui lòng nhập tên đăng nhập");
                resp.sendRedirect("admin/dangnhapadmin.jsp");
                return; // Kết thúc xử lý nếu có trường nào trống
            }
            if ( matkhau.isEmpty()) {
                session.setAttribute("failedMsg", "Vui lòng nhập mật khẩu");
                resp.sendRedirect("admin/dangnhapadmin.jsp");
                return; // Kết thúc xử lý nếu có trường nào trống
            }
			User user = userDAO.dangNhapAdmin(tendangnhap, matkhau);
			if(user!=null) {
				session.setAttribute("admin", user);
				session.setAttribute("succMsg", "Đăng nhập thành công");
				resp.sendRedirect("admin/index.jsp");
			}else {
				session.setAttribute("failedMsg", "Tên đăng nhập hoặc password không tồn tại");
				resp.sendRedirect("admin/dangnhapadmin.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
