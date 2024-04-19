package controller;

import java.io.IOException;

import dao.AnhNhaTaiTroDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AnhNhaTaiTro;
import model.DanhMuc;
@WebServlet(urlPatterns = {"/updateAnhNTT"})
public class UpdateAnhNhaTaiTroController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int maanhntt = Integer.parseInt(req.getParameter("maanhntt"));
			String tenanh = req.getParameter("tenanh");
			String anhnhatt = req.getParameter("anhnhatt");
			
			AnhNhaTaiTro anhNhaTaiTro = new AnhNhaTaiTro();
			anhNhaTaiTro.setMaanhntt(maanhntt);
			anhNhaTaiTro.setTenanh(tenanh);
			anhNhaTaiTro.setAnhnhatt(anhnhatt);
			
			AnhNhaTaiTroDAO anhNhaTaiTroDAO = new AnhNhaTaiTroDAO();
			boolean check = anhNhaTaiTroDAO.update(anhNhaTaiTro);
			
			
			HttpSession session = req.getSession();
			if(check){
				session.setAttribute("succMsg", "Cập nhật thành công");
				resp.sendRedirect("admin/listAnhNTT.jsp");
			}else {
				session.setAttribute("failedMsg", "Có gì đó sai sai");
				resp.sendRedirect("admin/updateAnhNTT.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
