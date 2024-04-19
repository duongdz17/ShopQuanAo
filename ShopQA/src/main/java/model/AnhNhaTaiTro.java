package model;

public class AnhNhaTaiTro {
	private int maanhntt;
	private String tenanh;
	private String anhnhatt;
	public int getMaanhntt() {
		return maanhntt;
	}
	public void setMaanhntt(int maanhntt) {
		this.maanhntt = maanhntt;
	}
	public String getTenanh() {
		return tenanh;
	}
	public void setTenanh(String tenanh) {
		this.tenanh = tenanh;
	}
	public String getAnhnhatt() {
		return anhnhatt;
	}
	public void setAnhnhatt(String anhnhatt) {
		this.anhnhatt = anhnhatt;
	}
	/**
	 * 
	 */
	public AnhNhaTaiTro() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param maanhntt
	 * @param tenanh
	 * @param anhnhatt
	 */
	public AnhNhaTaiTro(int maanhntt, String tenanh, String anhnhatt) {
		super();
		this.maanhntt = maanhntt;
		this.tenanh = tenanh;
		this.anhnhatt = anhnhatt;
	}
	
}
