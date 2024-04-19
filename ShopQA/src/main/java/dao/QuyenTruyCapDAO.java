package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.QuyenTruyCap;

public class QuyenTruyCapDAO {
	//Lấy danh sách quyền truy cập
		public List<QuyenTruyCap> getAllQuyenTruyCap(){
			Connection conn = KetNoiCSDL.getConnection();
			List<QuyenTruyCap> quyentruycaps = new ArrayList<QuyenTruyCap>();
			QuyenTruyCap quyenTruyCap = null;
			try {
				String sql = "select * from quyentruycap";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					quyenTruyCap = new QuyenTruyCap();
					quyenTruyCap.setMaquyentruycap(rs.getInt(1));
					quyenTruyCap.setTenquyentruycap(rs.getString(2));
					quyentruycaps.add(quyenTruyCap);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return quyentruycaps;
		}
		
		//Thêm mới quyền truy cập
			public boolean insert(QuyenTruyCap quyenTruyCap) {
				boolean check = false;
				Connection conn = KetNoiCSDL.getConnection();
				try {
					String sql = "insert into quyentruycap(tenquyentruycap) values(?)";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, quyenTruyCap.getTenquyentruycap());
					int i = ps.executeUpdate();
					if(i==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
		
			//Lấy quyền truy cập theo mã
			public QuyenTruyCap getQuyenTruyCapById(int maquyentruycap) {
				Connection conn = KetNoiCSDL.getConnection();
				QuyenTruyCap quyenTruyCap = null;
				try {
					String sql = "select * from quyentruycap where maquyentruycap=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, maquyentruycap);
					
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						quyenTruyCap = new QuyenTruyCap();
						quyenTruyCap.setMaquyentruycap(rs.getInt(1));
						quyenTruyCap.setTenquyentruycap(rs.getString(2));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return quyenTruyCap;
			}
			
			//Cập nhật quyền truy cập
			public boolean update(QuyenTruyCap quyenTruyCap) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = false;
				try {
					String sql = "update quyentruycap set tenquyentruycap=? where maquyentruycap=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1,quyenTruyCap.getTenquyentruycap());
					ps.setInt(2, quyenTruyCap.getMaquyentruycap());
					
					
					int row =ps.executeUpdate();
					if(row==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
			
			//Xóa quyền truy cập
			public boolean delete(int maquyentruycap) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = false;
				try {
					String sql = "delete from quyentruycap where maquyentruycap=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, maquyentruycap);
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
