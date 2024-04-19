package model;

public class Feedback {
	private int mafeedback;
	private String phanhoi;
	public int getMafeedback() {
		return mafeedback;
	}
	public void setMafeedback(int mafeedback) {
		this.mafeedback = mafeedback;
	}
	public String getPhanhoi() {
		return phanhoi;
	}
	public void setPhanhoi(String phanhoi) {
		this.phanhoi = phanhoi;
	}
	/**
	 * 
	 */
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param mafeedback
	 * @param phanhoi
	 */
	public Feedback(int mafeedback, String phanhoi) {
		super();
		this.mafeedback = mafeedback;
		this.phanhoi = phanhoi;
	}
	
}
