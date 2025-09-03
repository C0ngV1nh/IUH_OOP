package chuong1_2_3.bai3a;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Test_Vehicle.java
 * NguyenVanCongVinh_24681851
 */
public class Test_Vehicle {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {	
		
		System.out.print("nhap so luong phuong tien: ");
		int n = scanner.nextInt();
		ArrayList<Vehicle> listVehicle = new ArrayList<>();
		
		for(int i = 0 ; i < n ; i++) {
			
			Vehicle v = new Vehicle();
			
			System.out.print("Loai xe: ");
			String loaiXe  = scanner.nextLine();
			scanner.nextLine();
			v.setLoaiXe(loaiXe);
			
			System.out.print("dung tich: ");
			int dungTich  = scanner.nextInt();
			v.setDungTich(dungTich);
			
			System.out.print("tri Gia: ");
			double triGia  = scanner.nextDouble();
			v.setTriGia(triGia);
			
			listVehicle.add(v);
			
		}
		
	for(Vehicle temp : listVehicle) {
		System.out.println(temp);
	}
		
		
		
	}
}
