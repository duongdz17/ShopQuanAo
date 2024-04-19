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
@WebServlet(urlPatterns = {"/dangNhapKhachHang"})
public class DangNhapKhachHangController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserDAO userDAO = new UserDAO();
			HttpSession session = req.getSession();
			
			String tendangnhap = req.getParameter("tendangnhap");
			String matkhau = req.getParameter("matkhau");
			int maquyentruycap = Integer.parseInt(req.getParameter("maquyentruycap"));
			
			 // Kiểm tra xem các trường đăng nhập có trống không
            if (tendangnhap.isEmpty() ) {
                session.setAttribute("failedMsg", "Vui lòng nhập tên đăng nhập");
                resp.sendRedirect("dangNhap.jsp");
                return; // Kết thúc xử lý nếu có trường nào trống
            }
            if ( matkhau.isEmpty()) {
                session.setAttribute("failedMsg", "Vui lòng nhập mật khẩu");
                resp.sendRedirect("dangNhap.jsp");
                return; // Kết thúc xử lý nếu có trường nào trống
            }
           
			User user = userDAO.dangNhapKhachHang(tendangnhap, matkhau, maquyentruycap);
			if(user!=null) {
				session.setAttribute("khachhang", user);
				session.setAttribute("succMsg", "Đăng nhập thành công");
				resp.sendRedirect("index.jsp");
			}else {
				session.setAttribute("failedMsg", "Tên đăng nhập hoặc mật khẩu không đúng");
				resp.sendRedirect("dangNhap.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
