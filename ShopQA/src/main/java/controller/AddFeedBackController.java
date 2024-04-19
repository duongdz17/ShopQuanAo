package controller;

import java.io.IOException;

import dao.FeedbackDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Feedback;

@WebServlet(urlPatterns = {"/feedback"})
public class AddFeedBackController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String phanhoi = req.getParameter("phanhoi");
            
            // Kiểm tra xem trường phản hồi có rỗng không
            if (phanhoi == null || phanhoi.trim().isEmpty()) {
                HttpSession session = req.getSession();
                session.setAttribute("failedMsg", "Vui lòng nhập phản hồi");
                resp.sendRedirect("index.jsp");
                return;
            }
            
            Feedback feedback = new Feedback(0, phanhoi);
            FeedbackDAO feedbackDAO = new FeedbackDAO();
            boolean check = feedbackDAO.insert(feedback);
            HttpSession session = req.getSession();
            if (check) {
                session.setAttribute("succMsg", "Gửi phản hồi thành công");
                resp.sendRedirect("index.jsp");
            } else {
                session.setAttribute("failedMsg", "Có gì đó sai sai");
                resp.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
        }
    }
}
