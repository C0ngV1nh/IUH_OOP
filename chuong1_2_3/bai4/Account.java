package chuong1_2_3.bai4;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
	Locale local = new Locale("vi","VN");
	NumberFormat formatter = NumberFormat.getCurrencyInstance(local);
	private long stk ;
	private String tenTk;
	private double balance;
	private String status;
	private final double interest;
	
	public Account() {
		this.stk = 999999;
		this.tenTk = "Chưa Xác Định";
		this.balance = 50.0;
		this.status = ""; 
		this.interest = 0.035;
	}
	
	public Account(long stk, String tenTk) {
		this.stk = stk;
		this.tenTk = tenTk;
		this.balance = 50.0;
		this.interest = 0.035;
		
	}
	
	public Account(long stk, String tenTk, double balance) {
		
		this.stk = stk;
		this.tenTk = tenTk;
		this.balance = balance;
		this.status = ""; 
		this.interest = 0.035;
	}
	public long getStk() {
		return stk;
	}
	public void setStk(long stk) {
		if(stk <= 0 || stk == 999999) {
			System.out.println("STK khong hop le!");
			throw new IllegalArgumentException(status);
		}
		this.stk = stk;
	}
	
	public String getTenTk() {
		return tenTk;
	}
	public void setTenTk(String tenTk) {
		if(tenTk.isEmpty()) {
			System.out.println("tenTk khong hop le!");
			throw new IllegalArgumentException(status);
		}
		this.tenTk = tenTk;
	}
	
	public double getBalance() {
		if(balance < 50.0) {
			System.out.println("so tien khong hop le!");
			throw new IllegalArgumentException(status);
		}
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		
		return String.format("so TK: %d ; ten TK: %-20s ; " + formatter.format(getBalance()) + " ;" + "trang thai: %s",this.stk,this.tenTk,this.status);
	}
	
	public void napTien(double insertion) {
		double result = getBalance() + insertion;
		this.balance = result;
		System.out.println("da nap tien thanh cong");
	}
	
	public void rutTien(double takeAway) {
		if(takeAway <= 0 ) throw new IllegalArgumentException(status);
		double result = getBalance() - takeAway;
		if(result < 0) {
			throw new IllegalArgumentException(status);
		}
		this.balance = result;
		System.out.println("rut tien thanh cong!");
	}
	
	public void chuyenKhoan(Account acc , double soTien) {
		if(soTien <= 0 ) throw new IllegalArgumentException(status);
		double check = getBalance() - soTien;
		if(check < 0) {
			throw new IllegalArgumentException(status);
		}
		this.balance = getBalance() - soTien;
		acc.balance = acc.getBalance() + soTien;
		System.out.println("chuyen khoan thanh cong!");
		 
	}
	
	public void daoHan() {
		this.balance = getBalance() + getBalance() * getInterest();
	}

	public double getInterest() {
		return interest;
	}
	
	
	
}
