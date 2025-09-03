package chuong1_2_3.bai3b;

import java.time.LocalDate;
import java.util.Scanner;

public class Test_HangThucPham {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		LocalDate ngaySX = LocalDate.of(2025,9,1);
		LocalDate ngayHH = ngaySX.plusMonths(12);
		HangThucPham tp = new HangThucPham("304G","Logitech",4000,ngaySX,ngayHH);
		
		
		HangThucPham tp2 = new HangThucPham("405G");
		
		System.out.println(tp);
		System.out.println(tp2);
		
	}
	
}
