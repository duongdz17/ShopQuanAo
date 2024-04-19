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
@WebServlet(urlPatterns = {"/xoagiohang"})
public class XoaGioHangController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = resp.getWriter()) {
			String masanpham = req.getParameter("masanpham");
			if(masanpham!=null) {
				ArrayList<GioHang> cart_list = (ArrayList<GioHang>)req.getSession().getAttribute("cart-list"); 
				if(cart_list!=null) {
					for(GioHang c:cart_list) {
						if(c.getMasanpham()==Integer.parseInt(masanpham)) {
							cart_list.remove(cart_list.indexOf(c));
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
