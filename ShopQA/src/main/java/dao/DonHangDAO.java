package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DanhMuc;
import model.DonHang;
import model.SanPham;

public class DonHangDAO {
	private Connection conn;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    

	public DonHangDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	//Lấy danh sách đơn hàng
			public List<DonHang> getAllDonHang(){
				Connection conn = KetNoiCSDL.getConnection();
				List<DonHang> list = new ArrayList<DonHang>();
				DonHang donHang = null;
				try {
					String sql = "select * from donhang";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						donHang = new DonHang();
						donHang.setMadonhang(rs.getInt(1));
						donHang.setMasanpham(rs.getInt(2));
						donHang.setUserid(rs.getInt(3));
						donHang.setHoten(rs.getString(4));
						donHang.setEmail(rs.getString(5));
						donHang.setSodienthoai(rs.getString(6));
						donHang.setDiachi(rs.getString(7));
						donHang.setSoluong(rs.getInt(8));
						donHang.setDate(rs.getString(9));
						donHang.setTrangthai(rs.getString(10));
						
						list.add(donHang);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return list;
			}
			//Thêm mới đơn hàng
	public boolean insertDonHang(DonHang model) {
        boolean result = false;
        try {
            query = "insert into donhang(masanpham, userid, hoten, email, sodienthoai,diachi, soluong, ngaydat) values(?,?,?,?,?,?,?,?)";
            pst = this.conn.prepareStatement(query);
            pst.setInt(1, model.getMasanpham());
            pst.setInt(2, model.getUserid());
            pst.setString(3, model.getHoten());
            pst.setString(4, model.getEmail());
            pst.setString(5, model.getSodienthoai());
            pst.setString(6, model.getDiachi());
            pst.setInt(7, model.getSoluong());
            pst.setString(8, model.getDate());
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
	//Xóa đơn hàng
			public boolean delete(int madonhang) {
				Connection conn = KetNoiCSDL.getConnection();
				boolean check = false;
				try {
					String sql = "delete from donhang where madonhang=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, madonhang);
					int row = ps.executeUpdate();
					if(row==1) {
						check=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return check;
			}
	//Lấy danh sách đơn hàng của người dùng
			public List<DonHang> userOrders(int userid) {
		        List<DonHang> list = new ArrayList<>();
		        try {
		            query = "select * from donhang where userid=? order by donhang.madonhang desc";
		            pst = this.conn.prepareStatement(query);
		            pst.setInt(1, userid);
		            rs = pst.executeQuery();
		            while (rs.next()) {
		            	DonHang donHang = new DonHang();
		                SanPhamDAO sanPhamDAO = new SanPhamDAO();
		               
		                int masanpham = rs.getInt("masanpham");
		                SanPham sanPham = sanPhamDAO.getSanPhamById(masanpham);
		                donHang.setMadonhang(rs.getInt("madonhang"));
		                donHang.setMasanpham(masanpham);
		                donHang.setTensanpham(sanPham.getTensanpham());
		                donHang.setHinhanh(sanPham.getHinhanh());
		                donHang.setSoluong(rs.getInt("soluong"));
		                donHang.setGia(sanPham.getGia()*rs.getInt("soluong"));
		                donHang.setDate(rs.getString("ngaydat"));
		                donHang.setTrangthai(rs.getString("trangthai"));
		                
		                list.add(donHang);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		            System.out.println(e.getMessage());
		        }
		        return list;
		    }
}
