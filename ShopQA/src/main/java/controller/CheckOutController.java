package controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.DonHangDAO;
import dao.KetNoiCSDL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.DonHang;
import model.GioHang;
import model.User;
@WebServlet(urlPatterns = {"/checkout"})
public class CheckOutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(PrintWriter out = resp.getWriter()) {
			HttpSession session = req.getSession();
			
			
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			 java.util.Date utilDate = new java.util.Date();
			 java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	            //retrive all cart
               ArrayList<GioHang> cart_list = (ArrayList<GioHang>) req.getSession().getAttribute("cart-list");
               //user authen
               User user = (User) req.getSession().getAttribute("khachhang");
               //check người dùng và cart
               if(cart_list != null && user != null) {
               	for(GioHang c:cart_list) {
               		DonHang order = new DonHang();
               		order.setMasanpham(c.getMasanpham());
               		order.setUserid(user.getUserid());
               		order.setHoten(user.getHoten());
               		order.setEmail(user.getEmail());
               		order.setSodienthoai(user.getDiachi());
               		order.setDiachi(user.getNgaysinh());
               		
               		order.setSoluong(c.getSoluong());
               		order.setDate(formatter.format(utilDate));
               		
               		DonHangDAO orderDAO = new DonHangDAO(KetNoiCSDL.getConnection());
               		boolean result = orderDAO.insertDonHang(order);
               		
               		
               		if(!result) break;
               		
               	}
               	
               	cart_list.clear();
               	session.setAttribute("succMsg", "Mua hàng thành công");
               	resp.sendRedirect("index.jsp");
               }else {
               	if(user==null) resp.sendRedirect("dangNhap.jsp");
               	resp.sendRedirect("giohang.jsp");
               }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
