package chuong1_2_3.bai1;
/**
 * 
 * HinhChuNhat.java
 * NguyenVanCongVinh_24681851
 */
public class HinhChuNhat {
	private double chieuDai;
	private double chieuRong;
	
	
	public HinhChuNhat() {
		setChieuDai(0.0);
		setChieuRong(0.0);
	}
	public HinhChuNhat(double chieuDai, double chieuRong) {
		setChieuDai(chieuDai);
		setChieuRong(chieuRong);
	}
	
	
	public double getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(double chieuDai) {
		if(chieuDai < 0 ) throw new IllegalArgumentException();
		this.chieuDai = chieuDai;
	}
	public double getChieuRong() {
		return chieuRong;
	}
	public void setChieuRong(double chieuRong) {
		if(chieuRong < 0 ) throw new IllegalArgumentException();
		this.chieuRong = chieuRong;
	}
	
	
	// methods
	
	public double dienTich() {
		return chieuDai*chieuRong;
	}
	public double chuVi() {
		return (chieuDai+chieuRong)*2;
	}
	
	@Override
	public String toString() {
		return String.format("chieu dai: %.2f ; chieu rong: %.2f; dien tich: %.2f ; chu vi: %.2f", this.chieuDai , this.chieuRong, dienTich(),chuVi());
	}
	
}
