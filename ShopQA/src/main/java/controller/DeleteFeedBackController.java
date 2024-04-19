package controller;

import java.io.IOException;

import dao.DanhMucDAO;
import dao.FeedbackDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/deleteFeedback"})
public class DeleteFeedBackController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int mafeedback = Integer.parseInt(req.getParameter("mafeedback"));
			FeedbackDAO feedbackDAO = new FeedbackDAO();
			boolean check = feedbackDAO.delete(mafeedback);
			
			HttpSession session = req.getSession();
			if(check){
				session.setAttribute("succMsg", "Xóa thành công");
				resp.sendRedirect("admin/listFeedback.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/listFeedback.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
