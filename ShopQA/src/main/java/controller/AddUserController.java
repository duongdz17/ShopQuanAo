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
import model.DanhMuc;
import model.User;
@WebServlet(urlPatterns = {"/addUser"})
public class AddUserController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String hoten = req.getParameter("hoten");
			String tendangnhap = req.getParameter("tendangnhap");
			String matkhau = req.getParameter("matkhau");
			String email = req.getParameter("email");
			String sodienthoai = req.getParameter("sodienthoai");
			String diachi = req.getParameter("diachi");
			String ngaysinh = req.getParameter("ngaysinh");
			int maquyentruycap = Integer.parseInt(req.getParameter("maquyentruycap"));
			String anhnguoidung = req.getParameter("anhnguoidung");
			
			User user = new User(0, hoten, tendangnhap, matkhau, email, sodienthoai, diachi, ngaysinh, maquyentruycap, anhnguoidung);
			UserDAO userDAO = new UserDAO();
			boolean check = userDAO.insert(user);
			
			
			HttpSession session = req.getSession();
			if(check) {
				session.setAttribute("succMsg", "Thêm người dùng thành công");
				resp.sendRedirect("admin/listUser.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/addUser.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
