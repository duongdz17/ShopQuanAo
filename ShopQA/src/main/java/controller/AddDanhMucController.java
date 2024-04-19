package controller;

import java.io.IOException;

import dao.DanhMucDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DanhMuc;
@WebServlet(urlPatterns = {"/addDanhMuc"})
public class AddDanhMucController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String tenDanhMuc = req.getParameter("tendanhmuc");
			String anhDanhMuc = req.getParameter("anhdanhmuc");
			
			DanhMuc danhMuc = new DanhMuc(0, tenDanhMuc, anhDanhMuc);
			DanhMucDAO danhMucDAO = new DanhMucDAO();
			boolean check = danhMucDAO.insert(danhMuc);
			
			HttpSession session = req.getSession();
			if(check) {
				session.setAttribute("succMsg", "Thêm danh mục thành công");
				resp.sendRedirect("admin/listDanhMuc.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/addDanhMuc.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
