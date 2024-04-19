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
@WebServlet(urlPatterns = {"/updateQuyenTruyCap"})
public class UpdateQuyenTruyCapController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int maquyentruycap = Integer.parseInt(req.getParameter("maquyentruycap"));
			String tenquyentruycap = req.getParameter("tenquyentruycap");
			
			QuyenTruyCap quyenTruyCap = new QuyenTruyCap();
			quyenTruyCap.setMaquyentruycap(maquyentruycap);
			quyenTruyCap.setTenquyentruycap(tenquyentruycap);
		
			QuyenTruyCapDAO quyenTruyCapDAO = new QuyenTruyCapDAO();
			boolean check = quyenTruyCapDAO.update(quyenTruyCap);
			
			HttpSession session = req.getSession();
			if(check){
				session.setAttribute("succMsg", "Cập nhật thành công");
				resp.sendRedirect("admin/listQuyenTruyCap.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/updateQuyenTruyCap.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
