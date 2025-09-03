package chuong1_2_3.bai2;

import java.util.Scanner;

public class Test_SinhVien {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		SinhVien sv2 = new SinhVien(23145123,"Tran Minh Thang",10.0f,5.0f);
		SinhVien sv1 = new SinhVien(24681851,"Nguyen Van Cong Vinh",9.0f,8.0f);
		SinhVien sv3 = new SinhVien();
		
		System.out.println("nhap mssv: ");
		int mssv = scanner.nextInt();
		sv3.setSvId(mssv);
		scanner.nextLine();
		
		System.out.println("nhap ten sv: ");
		String name = scanner.nextLine();
		sv3.setName(name);
		
		System.out.println("nhap diem TH sv: ");
		float pointTH= scanner.nextFloat();
		sv3.setPointTH(pointTH);
		scanner.nextLine();
		
		System.out.println("nhap diem LT sv: ");
		float pointLT= scanner.nextFloat();
		sv3.setPointLT(pointLT);
		
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
	
		
		
		
	}
}
