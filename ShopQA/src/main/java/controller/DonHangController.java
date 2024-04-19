package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dao.DonHangDAO;
import dao.KetNoiCSDL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DonHang;
import model.GioHang;
import model.User;
@WebServlet(urlPatterns = {"/addDonHang"})
public class DonHangController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(0);

            User user = (User) req.getSession().getAttribute("khachhang");
            
            if (user != null) {
                String productId = req.getParameter("masanpham");
                int productQuantity = Integer.parseInt(req.getParameter("soluong"));
                if (productQuantity <= 0) {
                	productQuantity = 1;
                }
                DonHang orderModel = new DonHang();
                orderModel.setMasanpham(Integer.parseInt(productId));
                orderModel.setUserid(user.getUserid());
                orderModel.setSoluong(productQuantity);
                orderModel.setDate(formatter.format(date));
                
                DonHangDAO orderDao = new DonHangDAO(KetNoiCSDL.getConnection());
                boolean result = orderDao.insertDonHang(orderModel);
                if (result) {
                    ArrayList<GioHang> cart_list = (ArrayList<GioHang>) req.getSession().getAttribute("cart-list");
                    if (cart_list != null) {
                        for (GioHang c : cart_list) {
                            if (c.getMasanpham() == Integer.parseInt(productId)) {
                                cart_list.remove(cart_list.indexOf(c));
                                break;
                            }
                        }
                    }
                    resp.sendRedirect("index.jsp");
                } else {
                    out.println("order failed");
                }
            } else {
                resp.sendRedirect("dangNhap.jsp");
            }

        } 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
