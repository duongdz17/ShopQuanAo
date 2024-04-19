package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.GioHang;
import model.SanPham;

public class SanPhamDAO {
	//Lấy danh sách sản phẩm
		public List<SanPham> getAllSanPham(){
			Connection conn = KetNoiCSDL.getConnection();
			List<SanPham> sanPhams = new ArrayList<SanPham>();
			SanPham sanPham = null;
			try {
				String sql = "select * from sanpham";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					sanPham = new SanPham();
					sanPham.setMasanpham(rs.getInt(1));
					sanPham.setTensanpham(rs.getString(2));
					sanPham.setMota(rs.getString(3));
					
					sanPham.setGia(rs.getDouble(4));
					sanPham.setGiamgia(rs.getDouble(5));
					sanPham.setHinhanh(rs.getString(6));
					sanPham.setMadanhmuc(rs.getInt(7));
					sanPham.setNgaytao(rs.getString(8));
					sanPhams.add(sanPham);
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return sanPhams;
		}
		
		//Lấy danh sách sản phẩm mới nhất
				public List<SanPham> getNewSanPham(){
					Connection conn = KetNoiCSDL.getConnection();
					List<SanPham> sanPhams = new ArrayList<SanPham>();
					SanPham sanPham = null;
					try {
						String sql = "SELECT *FROM sanpham ORDER BY ngaytao DESC LIMIT 8;";
						PreparedStatement ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						while(rs.next()) {
							sanPham = new SanPham();
							sanPham.setMasanpham(rs.getInt(1));
							sanPham.setTensanpham(rs.getString(2));
							sanPham.setMota(rs.getString(3));
							
							sanPham.setGia(rs.getDouble(4));
							sanPham.setGiamgia(rs.getDouble(5));
							sanPham.setHinhanh(rs.getString(6));
							sanPham.setMadanhmuc(rs.getInt(7));
							sanPham.setNgaytao(rs.getString(8));
							sanPhams.add(sanPham);
							
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					return sanPhams;
				}
		
		//Thêm mới sản phẩm
		public boolean insert(SanPham sanPham) {
			boolean check = false;
			Connection conn = KetNoiCSDL.getConnection();
			try {
				String sql = "insert into sanpham(tensanpham,mota,gia,giamgia,hinhanh,madanhmuc,ngaytao) values(?,?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, sanPham.getTensanpham());
				ps.setString(2, sanPham.getMota());
				ps.setDouble(3, sanPham.getGia());
				ps.setDouble(4, sanPham.getGiamgia());
				ps.setString(5, sanPham.getHinhanh());
				ps.setInt(6, sanPham.getMadanhmuc());
				ps.setString(7, sanPham.getNgaytao());
				
				
				int i = ps.executeUpdate();
				if(i==1) {
					check=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return check;
		}
		
		//Lấy sản phẩm theo mã sản phẩm
		public SanPham getSanPhamById(int masanpham) {
			Connection conn = KetNoiCSDL.getConnection();
			SanPham sanPham = null;
			try {
				String sql = "select * from sanpham where masanpham=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, masanpham);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					sanPham = new SanPham();
					sanPham.setMasanpham(rs.getInt(1));
					sanPham.setTensanpham(rs.getString(2));
					sanPham.setMota(rs.getString(3));
					sanPham.setGia(rs.getDouble(4));
					sanPham.setGiamgia(rs.getDouble(5));
					sanPham.setHinhanh(rs.getString(6));
					sanPham.setMadanhmuc(rs.getInt(7));
					sanPham.setNgaytao(rs.getString(8));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return sanPham;
		}
		
		//Cập nhật sản phẩm
			public boolean update(SanPham sanPham) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = false;
				try {
					String sql = "update sanpham set tensanpham=?,mota=?,gia=?,giamgia=?,hinhanh=?,madanhmuc=?,ngaytao=? where masanpham=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, sanPham.getTensanpham());
					ps.setString(2, sanPham.getMota());
					ps.setDouble(3, sanPham.getGia());
					ps.setDouble(4, sanPham.getGiamgia());
					ps.setString(5, sanPham.getHinhanh());
					ps.setInt(6, sanPham.getMadanhmuc());
					ps.setString(7, sanPham.getNgaytao());
					ps.setInt(8, sanPham.getMasanpham());
					
					
					int row =ps.executeUpdate();
					if(row==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
			
			//Xóa sản phẩm
			public boolean delete(int masanpham) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = false;
				try {
					String sql = "delete from sanpham where masanpham=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, masanpham);
					int row = ps.executeUpdate();
					if(row==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
			
			//Lấy sản phẩm theo danh mục
			public List<SanPham> getSanPhamByDanhMuc(String madanhmuc){
				Connection conn = KetNoiCSDL.getConnection();
				List<SanPham> sanPhams = new ArrayList<SanPham>();
				SanPham sanPham = null;
				try {
					String sql = "select * from sanpham where madanhmuc=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, madanhmuc);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						sanPham = new SanPham();
						sanPham.setMasanpham(rs.getInt(1));
						sanPham.setTensanpham(rs.getString(2));
						sanPham.setMota(rs.getString(3));
						sanPham.setGia(rs.getDouble(4));
						sanPham.setGiamgia(rs.getDouble(5));
						sanPham.setHinhanh(rs.getString(6));
						sanPham.setMadanhmuc(rs.getInt(7));
						sanPham.setNgaytao(rs.getString(8));
						sanPhams.add(sanPham);
						
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return sanPhams;
			}
			//Tìm kiếm sản phẩm
			public List<SanPham> getTimKiemSanPham(String timKiem){
				Connection conn = KetNoiCSDL.getConnection();
				String sql = "select * from sanpham where tensanpham like?";
				List<SanPham> sanPhams = new ArrayList<SanPham>();
				try {
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, "%"+timKiem+"%");
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						SanPham sanPham = new SanPham();
						sanPham.setMasanpham(rs.getInt(1));
						sanPham.setTensanpham(rs.getString(2));
						sanPham.setMota(rs.getString(3));
						sanPham.setGia(rs.getDouble(4));
						sanPham.setGiamgia(rs.getDouble(5));
						sanPham.setHinhanh(rs.getString(6));
						sanPham.setMadanhmuc(rs.getInt(7));
						sanPham.setNgaytao(rs.getString(8));
						sanPhams.add(sanPham);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return sanPhams;
			}
			
			//Lấy danh sách giỏ hàng
			public List<GioHang> getGioHang(ArrayList<GioHang> cartList){
				Connection conn = KetNoiCSDL.getConnection();
				List<GioHang> giohangs = new ArrayList<GioHang>();
				try {
					if(cartList.size()>0) {
						for(GioHang item:cartList) {
							String sql="select * from sanpham where masanpham=?";
							PreparedStatement ps = conn.prepareStatement(sql);
							ps.setInt(1, item.getMasanpham());
							ResultSet rs = ps.executeQuery();
							while(rs.next()) {
								GioHang row = new GioHang();
								row.setMasanpham(rs.getInt("masanpham"));
								row.setTensanpham(rs.getString("tensanpham"));
								row.setMota(rs.getString("mota"));
								row.setGia(rs.getDouble("gia"));
								row.setGiamgia(rs.getDouble("giamgia"));
								row.setHinhanh(rs.getString("hinhanh"));
								row.setMadanhmuc(rs.getInt("madanhmuc"));
								row.setNgaytao(rs.getString("ngaytao"));
								row.setSoluong(item.getSoluong());
								
								giohangs.add(row);
								
							}
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
					//e.printStackTrace();
				}
				return giohangs;
			}
			//Tổng tiền của giỏ hàng
			public double getTotal(ArrayList<GioHang> cartList) {
				double sum = 0;
				Connection conn = KetNoiCSDL.getConnection();
				try {
					if(cartList.size()>0) {
						for(GioHang item:cartList) {
							String sql ="select gia from sanpham where masanpham=?";
							PreparedStatement ps =conn.prepareStatement(sql);
							ps.setInt(1, item.getMasanpham());
							ResultSet rs =ps.executeQuery();
							while(rs.next()) {
								sum+=rs.getDouble("gia")*item.getSoluong();
							}
						}
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return sum;
			}
			
			
			
			
			
}
