package controller;

import java.io.IOException;

import dao.QuyenTruyCapDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.QuyenTruyCap;
@WebServlet(urlPatterns = {"/addQuyenTruyCap"})
public class AddQuyenTruyCapController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String tenquyentruycap = req.getParameter("tenquyentruycap");
			QuyenTruyCap quyenTruyCap = new QuyenTruyCap(0, tenquyentruycap);
			QuyenTruyCapDAO quyenTruyCapDAO = new QuyenTruyCapDAO();
			
			boolean check = quyenTruyCapDAO.insert(quyenTruyCap);
			
			HttpSession session = req.getSession();
			if(check) {
				session.setAttribute("succMsg", "Thêm quyền truy cập thành công");
				resp.sendRedirect("admin/listQuyenTruyCap.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/addQuyenTruyCap.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
