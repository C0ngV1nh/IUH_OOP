package chuong1_2_3.bai4;

import java.util.Scanner;

public class AccountTest {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		
//		private long stk ;
//		private String tenTk;
//		private double balance;
//		private String status;
//		private final double interest;
		
		String menu = """
				1.Them Tai khoan
				2.So tai khoan hien co
				3.In thong tin tat ca TK
				4.Nap tien vao TK
				5.Rut Tien
				6.Chuyen tien
				7.Ket thuc
				""";
		
		int option;
		
		AccountList acc = new AccountList();
		
		do {
			System.out.println(menu);
			
			System.out.print("Ban muon su dung chuc nang nao?: ");
			option = scanner.nextInt();
			
			switch(option) {
				case 1:
					System.out.print("nhap stk: ");
					long stk = scanner.nextLong();
					System.out.print("nhap ten tk: ");
					String name = scanner.nextLine();
					scanner.nextLine();
					System.out.print("nhap so du: ");
					double sodu = scanner.nextDouble();
					acc.themTk(stk, name, sodu);
					break;
					
				case 2:
					System.out.print("so tai khoan hien co: ");
					System.out.println(acc.getCount());
					break;
				case 3:
					System.out.println("thong tin tat ca tai khoan: ");
					acc.inToanBoTk();
					break;
				case 4:
					
					System.out.println("tai khoan cua ban?: ");
					long stkChuyen = scanner.nextLong();
					Account tkChuyen = acc.findTk(stkChuyen);
					
					
					
					System.out.print("so tien nap: ");
					double tienNap = scanner.nextDouble();
					
					tkChuyen.napTien(tienNap);
					break;
				case 5:
					System.out.println("tai khoan cua ban?: ");
					long stkRut = scanner.nextLong();
					Account tkRut = acc.findTk(stkRut);
					
					
					
					System.out.print("so tien rut: ");
					double tienRut = scanner.nextDouble();
					
					tkRut.rutTien(tienRut);
					break;
				case 6:
					System.out.println("tai khoan cua ban?: ");
					long stkNguoiChuyen = scanner.nextLong();
					Account tkNguoiChuyen = acc.findTk(stkNguoiChuyen);
					
					System.out.print("so tien chuyen: ");
					Double tienChuyen = scanner.nextDouble();
					
					
					System.out.println("tai khoan cua nguoi thu huong?: ");
					long stkNguoiThuHuong = scanner.nextLong();
					Account tkNguoiThuHuong = acc.findTk(stkNguoiThuHuong);
					
					tkNguoiChuyen.chuyenKhoan(tkNguoiThuHuong, tienChuyen);
					break;
					
				
			}
			
			
		}while(option != 7);
		System.out.println("cam on da su dung dich vu!");
		
	}
}
