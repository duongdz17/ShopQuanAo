package model;

public class User {
	private int userid;
	private String hoten;
	private String tendangnhap;
	private String matkhau;
	private String email;
	private String sodienthoai;
	private String diachi;
	private String ngaysinh;
	private int maquyentruycap;
	private String anhnguoidung;
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
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
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
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public int getMaquyentruycap() {
		return maquyentruycap;
	}
	public void setMaquyentruycap(int maquyentruycap) {
		this.maquyentruycap = maquyentruycap;
	}
	public String getAnhnguoidung() {
		return anhnguoidung;
	}
	public void setAnhnguoidung(String anhnguoidung) {
		this.anhnguoidung = anhnguoidung;
	}
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param userid
	 * @param hoten
	 * @param tendangnhap
	 * @param matkhau
	 * @param email
	 * @param sodienthoai
	 * @param diachi
	 * @param ngaysinh
	 * @param maquyentruycap
	 * @param anhnguoidung
	 */
	public User(int userid, String hoten, String tendangnhap, String matkhau, String email, String sodienthoai,
			String diachi, String ngaysinh, int maquyentruycap, String anhnguoidung) {
		super();
		this.userid = userid;
		this.hoten = hoten;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.email = email;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.ngaysinh = ngaysinh;
		this.maquyentruycap = maquyentruycap;
		this.anhnguoidung = anhnguoidung;
	}
	
}
