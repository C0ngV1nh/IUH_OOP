package chuong1_2_3.bai3b;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HangThucPham {
	private final String maHang;
	private String tenHang;
	private double donGia;
	private LocalDate ngaySX;
	private LocalDate ngayHH;
	
	public HangThucPham(String maHang) {
		this.maHang = maHang;
		setDonGia(0.0);
		setTenHang("no_name");
		LocalDate now = LocalDate.now();
		setNgaySX(now);
		setNgayHH(now.plusMonths(12));
	}
	
	public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySX, LocalDate ngayHH) {
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		setNgaySX(ngaySX);
		setNgayHH(ngayHH);
	
	}


	public LocalDate getNgaySX() {
		return this.ngaySX;
	}
	
	public void setNgaySX(LocalDate ngaySX) {
		
		if(ngaySX == null) {
			throw new IllegalArgumentException();
		}
		this.ngaySX = ngaySX;
		
	}
	
	public LocalDate getNgayHH() {
		
		return this.ngayHH;
	}
	
	public void setNgayHH(LocalDate ngayHH) {
		if(ngayHH == null || ngayHH.isBefore(ngaySX)) {
			throw new IllegalArgumentException();
		}
		this.ngayHH = ngayHH;
	}
	
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		if(tenHang.isEmpty()) throw new IllegalArgumentException();
		this.tenHang = tenHang;
	}
	public double getDonGia() {
		if(donGia < 0) throw new IllegalArgumentException();
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	public String getMaHang() {
		return maHang;
	}
	
	
	@Override
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("#,###.00");
		DateTimeFormatter dateF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		
		
		return String.format("ma hang: %-10s ; ten hang: %-20s ; don gia: " + df.format(this.donGia)  + "; ngaySX: " + dateF.format(this.ngaySX) + " ; "+ "ngayHH: " + dateF.format(this.ngayHH),this.maHang,this.tenHang);
	}
	
	public boolean daHetHan() {
		
		LocalDate today = LocalDate.now();
		if(today.isAfter(ngayHH)) return false;
		return true;
	}
	
	
}
