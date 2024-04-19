package model;

public class QuyenTruyCap {
	private int maquyentruycap;
	private String tenquyentruycap;
	public int getMaquyentruycap() {
		return maquyentruycap;
	}
	public void setMaquyentruycap(int maquyentruycap) {
		this.maquyentruycap = maquyentruycap;
	}
	public String getTenquyentruycap() {
		return tenquyentruycap;
	}
	public void setTenquyentruycap(String tenquyentruycap) {
		this.tenquyentruycap = tenquyentruycap;
	}
	/**
	 * 
	 */
	public QuyenTruyCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param maquyentruycap
	 * @param tenquyentruycap
	 */
	public QuyenTruyCap(int maquyentruycap, String tenquyentruycap) {
		super();
		this.maquyentruycap = maquyentruycap;
		this.tenquyentruycap = tenquyentruycap;
	}
	
}
