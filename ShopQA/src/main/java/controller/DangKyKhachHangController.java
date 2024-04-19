package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
@WebServlet(urlPatterns = {"/dangKyKhachHang"})
public class DangKyKhachHangController extends HttpServlet {
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
			
			

			User user = new User();
			user.setHoten(hoten);
			user.setTendangnhap(tendangnhap);
			user.setMatkhau(matkhau);
			user.setEmail(email);
			user.setSodienthoai(sodienthoai);
			user.setDiachi(diachi);
			user.setNgaysinh(ngaysinh);
			user.setMaquyentruycap(2);
			HttpSession session = req.getSession();
			 // Kiểm tra xem hoten có trống không
            if (hoten.isEmpty() ) {
                session.setAttribute("failedMsg", "Vui lòng nhập họ tên");
                resp.sendRedirect("dangKy.jsp");
                return; // Kết thúc xử lý nếu có trường nào trống
            }
            // Kiểm tra xem tên đăng nhập có trống không
            if (tendangnhap.isEmpty() ) {
                session.setAttribute("failedMsg", "Vui lòng nhập tên đăng nhập");
                resp.sendRedirect("dangKy.jsp");
                return; // Kết thúc xử lý nếu có trường nào trống
            }
            // Kiểm tra xem mật khẩu có trống không
            if (matkhau.isEmpty() ) {
                session.setAttribute("failedMsg", "Vui lòng nhập mật khẩu");
                resp.sendRedirect("dangKy.jsp");
                return; // Kết thúc xử lý nếu có trường nào trống
            }
            // Kiểm tra xem số điện thoại có trống không
            if (sodienthoai.isEmpty() ) {
                session.setAttribute("failedMsg", "Vui lòng nhập số điện thoại");
                resp.sendRedirect("dangKy.jsp");
                return; // Kết thúc xử lý nếu có trường nào trống
            }
         // Kiểm tra xem địa chỉ có trống không
            if (diachi.isEmpty() ) {
                session.setAttribute("failedMsg", "Vui lòng nhập địa chỉ");
                resp.sendRedirect("dangKy.jsp");
                return; // Kết thúc xử lý nếu có trường nào trống
            }
        
         // Kiểm tra xem ngày sinh có trống không
            if (ngaysinh.isEmpty() ) {
                session.setAttribute("failedMsg", "Vui lòng nhập ngày sinh");
                resp.sendRedirect("dangKy.jsp");
                return; // Kết thúc xử lý nếu có trường nào trống
            }
            // Kiểm tra xem ngày sinh có trống không
            if (email.isEmpty() ) {
                session.setAttribute("failedMsg", "Vui lòng nhập email");
                resp.sendRedirect("dangKy.jsp");
                return; // Kết thúc xử lý nếu có trường nào trống
            }
         // Kiểm tra định dạng email
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                session.setAttribute("failedMsg", "Định dạng email không đúng");
                resp.sendRedirect("dangKy.jsp");
                return; // Kết thúc xử lý nếu email không đúng định dạng
            }
			UserDAO userDAO = new UserDAO();
			boolean check2 = userDAO.KiemTraTenDangNhap(tendangnhap);
			if(check2) {
				boolean check3 = userDAO.KiemTraEmail(email);
				if(check3) {
					boolean check4 = userDAO.KiemTraSoDienThoai(sodienthoai);
					if(check4) {
					boolean check = userDAO.DangKyKhachHang(user);
					if(check) {
						session.setAttribute("succMsg", "Đăng ký thành công!");
						resp.sendRedirect("dangNhap.jsp");
					}else {
						session.setAttribute("failedMsg", "Thông tin bị sai!");
						resp.sendRedirect("dangKy.jsp");
					}
					}else {
						session.setAttribute("failedMsg", "Số điện thoại đã tồn tại!!");
						resp.sendRedirect("dangKy.jsp");
					}
				}else {
					session.setAttribute("failedMsg", "Email đã tồn tại!!");
					resp.sendRedirect("dangKy.jsp");
				}
			}else {
				session.setAttribute("failedMsg", "Tên đăng nhập đã tồn tại!!");
				resp.sendRedirect("dangKy.jsp");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
