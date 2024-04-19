package controller;

import java.io.IOException;

import dao.QuyenTruyCapDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/deleteQuyenTruyCap"})
public class DeleteQuyenTruyCapController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int maquyentruycap = Integer.parseInt(req.getParameter("maquyentruycap"));
			QuyenTruyCapDAO quyenTruyCapDAO = new QuyenTruyCapDAO();
			boolean check = quyenTruyCapDAO.delete(maquyentruycap);
			HttpSession session = req.getSession();
			if(check){
				session.setAttribute("succMsg", "Xóa thành công");
				resp.sendRedirect("admin/listQuyenTruyCap.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/listQuyenTruyCap.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
