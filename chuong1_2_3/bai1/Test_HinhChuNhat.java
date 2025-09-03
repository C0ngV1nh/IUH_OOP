package chuong1_2_3.bai1;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * 
 * Test_HinhChuNhat.java
 * NguyenVanCongVinh_24681851
 */
public class Test_HinhChuNhat {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] vinhArgs) {
		
		
		System.out.print("nhap so luong hinh chu nhat: ");
		int n = scanner.nextInt();
		ArrayList<HinhChuNhat> listHcn = new ArrayList<>();
		for(int i = 0 ; i <  n; i++) {
			HinhChuNhat temp = new HinhChuNhat();
			System.out.print("nhap chieu dai: ");
			double cd = scanner.nextDouble();
			temp.setChieuDai(cd);
			System.out.print("nhap chieu rong: ");
			double cr = scanner.nextDouble();
			temp.setChieuRong(cr);
			
			listHcn.add(temp);
		}
		
		
		System.out.println("\n");
		for(HinhChuNhat hcn : listHcn) {
				System.out.println(hcn);
		}
		
	}	

}
