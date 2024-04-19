package model;

public class DonHang extends SanPham  {
	private int madonhang;
	private int userid;
	private String hoten;
	private String email;
	private String sodienthoai;
	private String diachi;
	private int soluong;
	
	private String date;
	private String trangthai;
	/**
	 * 
	 */
	public int getMadonhang() {
		return madonhang;
	}
	public void setMadonhang(int madonhang) {
		this.madonhang = madonhang;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonHang(int masanpham, String tensanpham, String mota, double gia, double giamgia, String hinhanh,
			int madanhmuc, String ngaytao) {
		super(masanpham, tensanpham, mota, gia, giamgia, hinhanh, madanhmuc, ngaytao);
		// TODO Auto-generated constructor stub
	}
	public DonHang(int madonhang, int userid, String hoten, String email, String sodienthoai, String diachi,
			int soluong, String date, String trangthai) {
		super();
		this.madonhang = madonhang;
		this.userid = userid;
		this.hoten = hoten;
		this.email = email;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.soluong = soluong;
		this.date = date;
		this.trangthai = trangthai;
	}
	
	
	
}
