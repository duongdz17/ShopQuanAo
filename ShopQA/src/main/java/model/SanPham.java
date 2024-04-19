package model;

public class SanPham 

{
	private int masanpham;
	private String tensanpham;
	private String mota;
	
	private double gia;
	private double giamgia;
	private String hinhanh;
	private int madanhmuc;
	private String ngaytao;
	public int getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public double getGiamgia() {
		return giamgia;
	}
	public void setGiamgia(double giamgia) {
		this.giamgia = giamgia;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public int getMadanhmuc() {
		return madanhmuc;
	}
	public void setMadanhmuc(int madanhmuc) {
		this.madanhmuc = madanhmuc;
	}
	public String getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(String ngaytao) {
		this.ngaytao = ngaytao;
	}
	/**
	 * 
	 */
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param masanpham
	 * @param tensanpham
	 * @param mota
	 * @param gia
	 * @param giamgia
	 * @param hinhanh
	 * @param madanhmuc
	 * @param ngaytao
	 */
	public SanPham(int masanpham, String tensanpham, String mota, double gia, double giamgia, String hinhanh,
			int madanhmuc, String ngaytao) {
		super();
		this.masanpham = masanpham;
		this.tensanpham = tensanpham;
		this.mota = mota;
		this.gia = gia;
		this.giamgia = giamgia;
		this.hinhanh = hinhanh;
		this.madanhmuc = madanhmuc;
		this.ngaytao = ngaytao;
	}
	
	
	
}
