package chuong1_2_3.bai3a;
/**
 * 
 * Vehicle.java
 * NguyenVanCongVinh_24681851
 */
public class Vehicle {
	private String loaiXe;
	private int dungTich;
	private double triGia;
	
	public Vehicle() {
		this.loaiXe = " ";
		this.dungTich = 0;
		this.triGia = 0.0;
	}
	
	
	public Vehicle(String loaiXe, int dungTich, double triGia) {
		
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}
	
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public int getDungTich() {
		return dungTich;
	}
	public void setDungTich(int dungTich) {
		if(dungTich < 0) throw new IllegalArgumentException();
		this.dungTich = dungTich;
	}
	public double getTriGia() {
		return triGia;
	}
	public void setTriGia(double triGia) {
		if(triGia < 0) throw new IllegalArgumentException();
		this.triGia = triGia;
	}
	
	public double thue() {
		if(dungTich >= 0 && dungTich < 100) {
			return triGia*0.01;
		}else if(dungTich >= 100 && dungTich <= 200) {
			return triGia*0.03;
		}else {
			return triGia*0.05;
		}
	}
	
	@Override
	public String toString() {
		return String.format("Loai xe: %s, Dung tich: %d, Tri gia: %.2f, Thue: %.2f",this.loaiXe,this.dungTich,this.triGia,thue());
	}
	
	
}
