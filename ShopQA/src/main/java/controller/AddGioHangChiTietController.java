package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.GioHang;
@WebServlet(urlPatterns = {"/addgiohangchitiet"})
public class AddGioHangChiTietController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = resp.getWriter()) {
			ArrayList<GioHang> cartList = new ArrayList<>();
			
			int masanpham = Integer.parseInt(req.getParameter("masanpham"));
			GioHang gioHang = new GioHang();
			gioHang.setMasanpham(masanpham);
			gioHang.setSoluong(1);
			
			
			HttpSession session = req.getSession();
			ArrayList<GioHang> cart_list = (ArrayList<GioHang>) session.getAttribute("cart-list");
			if(cart_list == null) {
				cartList.add(gioHang);
				session.setAttribute("cart-list", cartList);
				resp.sendRedirect("giohang.jsp");
			}else {
				cartList = cart_list;
				boolean exist = false;
				
				
				
				for(GioHang c:cartList) {
					if(c.getMasanpham()==masanpham) {
						exist=true;
						out.print("<h3 style='color:crimson;text-align:center'>Sản phẩm đã có sẵn trong giỏ hàng.<a href='giohang.jsp'>Đi tới giỏ hàng</a></h3>");
					}
					
				
				}
				if(!exist) {
					cartList.add(gioHang);
					resp.sendRedirect("giohang.jsp");
				}
			}
			
		} 
	}
}
