package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DanhMuc;

public class DanhMucDAO {
	//Lấy danh sách danh mục
		public List<DanhMuc> getAllDanhMuc(){
			Connection conn = KetNoiCSDL.getConnection();
			List<DanhMuc> list = new ArrayList<DanhMuc>();
			DanhMuc danhMuc = null;
			try {
				String sql = "select * from danhmuc";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					danhMuc = new DanhMuc();
					danhMuc.setMadanhmuc(rs.getInt(1));
					danhMuc.setTendanhmuc(rs.getString(2));
					danhMuc.setAnhdanhmuc(rs.getString(3));
					list.add(danhMuc);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return list;
		}
		
		//Thêm mới danh mục
		public boolean insert(DanhMuc danhMuc) {
			boolean check = false;
			Connection conn = KetNoiCSDL.getConnection();
			try {
				String sql = "insert into danhmuc(tendanhmuc, anhdanhmuc) values(?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, danhMuc.getTendanhmuc());
				ps.setString(2, danhMuc.getAnhdanhmuc());
				
				
				int i = ps.executeUpdate();
				if(i==1) {
					check=true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return check;
		}
		
		//Lấy danh mục theo mã danh mục
		public DanhMuc getDanhMucById(int madanhmuc) {
			Connection conn = KetNoiCSDL.getConnection();
			DanhMuc danhMuc = null;
			try {
				String sql = "select * from danhmuc where madanhmuc=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, madanhmuc);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					danhMuc = new DanhMuc();
					danhMuc.setMadanhmuc(rs.getInt(1));
					danhMuc.setTendanhmuc(rs.getString(2));
					danhMuc.setAnhdanhmuc(rs.getString(3));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return danhMuc;
		}
		
		//Cập nhật danh mục
		public boolean update(DanhMuc danhMuc) {
			Connection conn = KetNoiCSDL.getConnection();
			boolean check = false;
			try {
				String sql = "update danhmuc set tendanhmuc=?,anhdanhmuc=? where madanhmuc=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,danhMuc.getTendanhmuc());
				ps.setString(2, danhMuc.getAnhdanhmuc());
				ps.setInt(3, danhMuc.getMadanhmuc());
				
				
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
		public boolean delete(int madanhmuc) {
			Connection conn = KetNoiCSDL.getConnection();
			boolean check = false;
			try {
				String sql = "delete from danhmuc where madanhmuc=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, madanhmuc);
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
