package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.AnhNhaTaiTro;
import model.DanhMuc;



public class AnhNhaTaiTroDAO {
	//Lấy danh sách ảnh
	public List<AnhNhaTaiTro> getAllAnh() {
		Connection conn = KetNoiCSDL.getConnection();
		List<AnhNhaTaiTro> list = new ArrayList<AnhNhaTaiTro>();
		AnhNhaTaiTro anhNhaTaiTro = null;
		try {
			String sql = "select * from anhnhataitro";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				anhNhaTaiTro = new AnhNhaTaiTro();
				anhNhaTaiTro.setMaanhntt(rs.getInt(1));
				anhNhaTaiTro.setTenanh(rs.getString(2));
				anhNhaTaiTro.setAnhnhatt(rs.getString(3));
				list.add(anhNhaTaiTro);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	//Thêm mới ảnh
			public boolean insert(AnhNhaTaiTro anhNhaTaiTro) {
				boolean check = false;
				Connection conn = KetNoiCSDL.getConnection();
				try {
					String sql = "insert into anhnhataitro(tenanh, anhnhatt) values(?,?)";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, anhNhaTaiTro.getTenanh());
					ps.setString(2, anhNhaTaiTro.getAnhnhatt());
					
					
					int i = ps.executeUpdate();
					if(i==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
			
			//Lấy ảnh theo mã
			public AnhNhaTaiTro getAnhNhaTaiTroById(int maanhntt) {
				Connection conn = KetNoiCSDL.getConnection();
				AnhNhaTaiTro anhNhaTaiTro = null;
				try {
					String sql = "select * from anhnhataitro where maanhntt=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, maanhntt);
					
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						anhNhaTaiTro = new AnhNhaTaiTro();
						anhNhaTaiTro.setMaanhntt(rs.getInt(1));
						anhNhaTaiTro.setTenanh(rs.getString(2));
						anhNhaTaiTro.setAnhnhatt(rs.getString(3));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return anhNhaTaiTro;
			}
			
			//Cập nhật danh mục
			public boolean update(AnhNhaTaiTro anhNhaTaiTro) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = false;
				try {
					String sql = "update anhnhataitro set tenanh=?,anhnhatt=? where maanhntt=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, anhNhaTaiTro.getTenanh());
					ps.setString(2, anhNhaTaiTro.getAnhnhatt());
					ps.setInt(3, anhNhaTaiTro.getMaanhntt());
					
					
					int row =ps.executeUpdate();
					if(row==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
			
			//Xóa danh mục
			public boolean delete(int maanhntt) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = false;
				try {
					String sql = "delete from anhnhataitro where maanhntt=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, maanhntt);
					int row = ps.executeUpdate();
					if(row==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
}
