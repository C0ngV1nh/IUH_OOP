package chuong1_2_3.bai5;

import java.util.Scanner;

public class CDTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        CDList list = new CDList(10);
String menu = """
		
		    1. Them CD moi");
            2. Xem so luong CD");
            3. Tinh tong gia CD");
            4. Hien thi tat ca CD");
            5. Sap xep tang dan theo tua CD
            6. Sap xep giam dan theo ma CD
            7. thoat
		""";
        int choice;
        do {
            System.out.println(menu);
            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine(); // ăn Enter

            switch (choice) {
                case 1:
                    System.out.print("Nhap ma CD: ");
                    long ma = sc.nextLong();
                    sc.nextLine(); 

                    System.out.print("Nhap tua CD: ");
                    String tua = sc.nextLine();

                    System.out.print("Nhap so bai hat: ");
                    long soBH = sc.nextLong();
                    sc.nextLine(); 

                    System.out.print("Nhap gia: ");
                    double gia = sc.nextDouble();
                    sc.nextLine(); 

                    CD cd = new CD(ma,tua, soBH ,gia);
                    list.addCD(cd);
                    break;

                case 2:
                    list.soLuongCd();
                    break;

                case 3:
                    System.out.println("Tong gia CD: " + list.tongGia());
                    break;

                case 4:
                    list.thongTinTatCa();
                    break;

                case 5:
                    list.tangDanTheoTuaCD();
                    System.out.println("Da sap xep tang dan theo tua CD:");
                    break;

                case 6:
                    list.sapXepGiamDanTheoMaCD();
                    System.out.println("Da sap xep giam dan theo ma CD:");
                    break;

                case 7:
                   
                    System.out.println("Thoat chuong trinh!");
                    break;

            }

        } while (choice != 7);

        sc.close();
    }
}
