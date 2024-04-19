package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GioHang;
@WebServlet(urlPatterns = {"/tanggiam"})
public class TangGiamGioHangController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = resp.getWriter();){
			String action = req.getParameter("action");
			int masanpham = Integer.parseInt(req.getParameter("masanpham"));
			ArrayList<GioHang> cart_list = (ArrayList<GioHang>)req.getSession().getAttribute("cart-list");
			if(action!=null && masanpham>=1) {
				if(action.equals("tang")) {
					for(GioHang c:cart_list) {
						if(c.getMasanpham()==masanpham) {
							int soluong = c.getSoluong();
							soluong++;
							c.setSoluong(soluong);
							resp.sendRedirect("giohang.jsp");
						}
					}
				}
				
				if(action.equals("giam")) {
					for(GioHang c:cart_list) {
						if(c.getMasanpham()==masanpham && c.getSoluong() >1) {
							int soluong = c.getSoluong();
							soluong--;
							c.setSoluong(soluong);
							break;
							
						}
					}
					resp.sendRedirect("giohang.jsp");
				}
			}else {
				resp.sendRedirect("giohang.jsp");
			}
		}
	}
}
