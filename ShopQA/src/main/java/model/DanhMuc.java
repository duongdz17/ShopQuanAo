package model;

public class DanhMuc {
	private int madanhmuc;
	private String tendanhmuc;
	private String anhdanhmuc;
	public int getMadanhmuc() {
		return madanhmuc;
	}
	public void setMadanhmuc(int madanhmuc) {
		this.madanhmuc = madanhmuc;
	}
	public String getTendanhmuc() {
		return tendanhmuc;
	}
	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}
	public String getAnhdanhmuc() {
		return anhdanhmuc;
	}
	public void setAnhdanhmuc(String anhdanhmuc) {
		this.anhdanhmuc = anhdanhmuc;
	}
	/**
	 * 
	 */
	public DanhMuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param madanhmuc
	 * @param tendanhmuc
	 * @param anhdanhmuc
	 */
	public DanhMuc(int madanhmuc, String tendanhmuc, String anhdanhmuc) {
		super();
		this.madanhmuc = madanhmuc;
		this.tendanhmuc = tendanhmuc;
		this.anhdanhmuc = anhdanhmuc;
	}
	
}
