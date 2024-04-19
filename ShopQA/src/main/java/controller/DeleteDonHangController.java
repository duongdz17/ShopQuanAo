package controller;

import java.io.IOException;

import dao.DanhMucDAO;
import dao.DonHangDAO;
import dao.KetNoiCSDL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/deleteDonHang"})
public class DeleteDonHangController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int madonhang = Integer.parseInt(req.getParameter("madonhang"));
			DonHangDAO donHangDAO = new DonHangDAO(KetNoiCSDL.getConnection());
			boolean check = donHangDAO.delete(madonhang);
			
			HttpSession session = req.getSession();
			if(check){
				session.setAttribute("succMsg", "Xóa thành công");
				resp.sendRedirect("admin/listDonHang.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/listDonHang.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
