package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DanhMuc;
import model.Feedback;

public class FeedbackDAO {
	// Lấy danh sách danh mục
	public List<Feedback> getAll() {
		Connection conn = KetNoiCSDL.getConnection();
		List<Feedback> list = new ArrayList<Feedback>();
		Feedback feedback = null;
		try {
			String sql = "select * from feedback";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				feedback = new Feedback();
				feedback.setMafeedback(rs.getInt(1));
				feedback.setPhanhoi(rs.getString(2));

				list.add(feedback);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	//Thêm mới feedback
			public boolean insert(Feedback feedback) {
				boolean check = false;
				Connection conn = KetNoiCSDL.getConnection();
				try {
					String sql = "insert into feedback(phanhoi) values(?)";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, feedback.getPhanhoi());
					
					
					
					int i = ps.executeUpdate();
					if(i==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
			//Xóa feedback
			public boolean delete(int mafeedback) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = false;
				try {
					String sql = "delete from feedback where mafeedback=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, mafeedback);
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
