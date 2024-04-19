package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DanhMuc;
import model.User;

public class UserDAO {
	//Đăng nhập admin
		public User dangNhapAdmin(String tendangnhap, String matkhau) {
			User user = null;
			Connection conn = KetNoiCSDL.getConnection();
			try {
				String sql = "select * from user where tendangnhap=? and matkhau=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, tendangnhap);
				ps.setString(2, matkhau);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					user = new User();
					user.setUserid(rs.getInt(1));
					user.setHoten(rs.getString(2));
					user.setTendangnhap(rs.getString(3));
					user.setMatkhau(rs.getString(4));
					user.setEmail(rs.getString(5));
					user.setDiachi(rs.getString(6));
					user.setNgaysinh(rs.getString(7));
					user.setMaquyentruycap(rs.getInt(8));
					user.setAnhnguoidung(rs.getString(9));
					

				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return user;
		}
		//Lấy danh sách người dùng
		public List<User> getAllUser(){
			Connection conn = KetNoiCSDL.getConnection();
			List<User> users = new ArrayList<User>();
			User user = null;
			try {
				String sql = "select * from user";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					user = new User();
					user.setUserid(rs.getInt(1));
					user.setHoten(rs.getString(2));
					user.setTendangnhap(rs.getString(3));
					user.setMatkhau(rs.getString(4));
					user.setEmail(rs.getString(5));
					user.setSodienthoai(rs.getString(6));
					user.setDiachi(rs.getString(7));
					user.setNgaysinh(rs.getString(8));
					user.setMaquyentruycap(rs.getInt(9));
					user.setAnhnguoidung(rs.getString(10));
					users.add(user);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return users;
		}
		
		//Đăng ký khách hàng
		public boolean DangKyKhachHang(User user) {
			boolean check = false;
			Connection conn = KetNoiCSDL.getConnection();
			
			try {
				String sql = "insert into user(hoten,tendangnhap,matkhau,email,sodienthoai,diachi,ngaysinh,maquyentruycap) values(?,?,?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getHoten());
				ps.setString(2, user.getTendangnhap());
				ps.setString(3, user.getMatkhau());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getSodienthoai());
				ps.setString(6, user.getDiachi());
				ps.setString(7, user.getNgaysinh());
				ps.setInt(8, 2);
				
				int i = ps.executeUpdate();
				if(i==1) {
					check = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return check;
		}
		
		// Không để khách hàng trùng tên đăng nhập
			public boolean KiemTraTenDangNhap(String kiemtratendangnhap) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = true;
				try {
					String sql = "select * from user where tendangnhap = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, kiemtratendangnhap);

					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						check = false;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return check;
			}
		
			// Không để khách hàng trùng email
			public boolean KiemTraEmail(String kiemtraemail) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = true;
				try {
					String sql = "select * from user where email = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, kiemtraemail);

					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						check = false;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return check;
			}
			
			// Không để khách hàng trùng số điện thoại
			public boolean KiemTraSoDienThoai(String kiemtrasodienthoai) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = true;
				try {
					String sql = "select * from user where sodienthoai = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, kiemtrasodienthoai);

					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						check = false;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				return check;
			}
			
			// Đăng nhập khách hàng
			public User dangNhapKhachHang(String tendangnhap, String matkhau, int maquyentruycap) {
				User user = null;
				Connection conn = KetNoiCSDL.getConnection();
				try {
					String sql = "select * from user where tendangnhap=? and matkhau=? and maquyentruycap=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, tendangnhap);
					ps.setString(2, matkhau);
					ps.setInt(3, 2);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						user = new User();
						user.setUserid(rs.getInt(1));
						user.setHoten(rs.getString(2));
						user.setTendangnhap(rs.getString(3));
						user.setMatkhau(rs.getString(4));
						user.setEmail(rs.getString(5));
						user.setDiachi(rs.getString(6));
						user.setNgaysinh(rs.getString(7));
						user.setMaquyentruycap(rs.getInt(8));
						user.setAnhnguoidung(rs.getString(9));

					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return user;

			}
			
			//Thêm mới người dùng
			public boolean insert(User user) {
				boolean check = false;
				Connection conn = KetNoiCSDL.getConnection();
				try {
					String sql = "insert into user(hoten,tendangnhap,matkhau,email,sodienthoai,diachi,ngaysinh,maquyentruycap,anhnguoidung) values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, user.getHoten());
					ps.setString(2, user.getTendangnhap());
					ps.setString(3, user.getMatkhau());
					ps.setString(4, user.getEmail());
					ps.setString(5, user.getSodienthoai());
					ps.setString(6, user.getDiachi());
					ps.setString(7, user.getNgaysinh());
					ps.setInt(8, user.getMaquyentruycap());
					ps.setString(9, user.getAnhnguoidung());
					
					
					int i = ps.executeUpdate();
					if(i==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
			
			//Lấy id người dùng
			public User getUserById(int userid) {
				Connection conn = KetNoiCSDL.getConnection();
				User user = null;
				try {
					String sql = "select * from user where userid=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, userid);
					
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						user = new User();
						user.setUserid(rs.getInt(1));
						user.setHoten(rs.getString(2));
						user.setTendangnhap(rs.getString(3));
						user.setMatkhau(rs.getString(4));
						user.setEmail(rs.getString(5));
						user.setDiachi(rs.getString(6));
						user.setNgaysinh(rs.getString(7));
						user.setMaquyentruycap(rs.getInt(8));
						user.setAnhnguoidung(rs.getString(9));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return user;
			}
			
			//Cập nhật người dùng
			public boolean update(User user) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = false;
				try {
					String sql = "update user set hoten=?,tendangnhap=?,matkhau=?,email=?,sodienthoai=?,diachi=?,ngaysinh=?,maquyentruycap=?,anhnguoidung=? where userid=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, user.getHoten());
					ps.setString(2, user.getTendangnhap());
					ps.setString(3, user.getMatkhau());
					ps.setString(4, user.getEmail());
					ps.setString(5, user.getSodienthoai());
					ps.setString(6, user.getDiachi());
					ps.setString(7, user.getNgaysinh());
					ps.setInt(8, user.getMaquyentruycap());
					ps.setString(9, user.getAnhnguoidung());
					ps.setInt(10, user.getUserid());
					
					
					int row =ps.executeUpdate();
					if(row==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
			
			//Xóa người dùng
			public boolean delete(int userid) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = false;
				try {
					String sql = "delete from user where userid=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, userid);
					int row = ps.executeUpdate();
					if(row==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
			
			//Kiểm tra mật khẩu
			public boolean kiemTraMatKhau(int userid, String matkhau) {
				boolean check = true;
				Connection conn = KetNoiCSDL.getConnection();
				try {
					String sql = "select * from user where userid = ? and matkhau =?";
					PreparedStatement ps =conn.prepareStatement(sql);
					ps.setInt(1, userid);
					ps.setString(2, matkhau);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						check = false;
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return check;
			}
			
			//Cập nhật hồ sơ người dùng
			public boolean updateProfile(User user) {
				boolean check = false;
				Connection conn = KetNoiCSDL.getConnection();
				try {
					String sql = "update user set hoten=?, email =?, sodienthoai=?, diachi=?where userid=?";
					PreparedStatement ps =conn.prepareStatement(sql);
					ps.setString(1, user.getHoten());
					ps.setString(2, user.getEmail());
					ps.setString(3, user.getSodienthoai());
					ps.setString(4, user.getDiachi());
				
					ps.setInt(5, user.getUserid());
					int row = ps.executeUpdate();
					if(row==1) {
						check = true;
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return check;
			}
}
