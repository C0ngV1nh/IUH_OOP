package nguyenvancongvinh_24681851;

import java.util.List;

public class TestTuyenXe {
//	 Khi chạy tự thêm cứng sẵn 10 chuyến xe trong đó 4 chuyến nội tỉnh và 6 chuyến liên tỉnh
	
	public static void main(String[] args) {
		TuyenLienTinh t1 = new TuyenLienTinh("HP123","HaiPhong",15,10,DonViGhe.DON_GIA_GHE,Tinh.HAIPHONG,Tinh.HANOI,12);
		TuyenLienTinh t2 = new TuyenLienTinh("HN123","HaNoi",21,11,DonViGhe.DON_GIA_GHE,Tinh.HANOI,Tinh.HCM,10);
		TuyenLienTinh t3 = new TuyenLienTinh("HCM123","HoChiMinh",5,4,DonViGhe.DON_GIA_GHE,Tinh.HCM,Tinh.HAIPHONG,299);
		TuyenLienTinh t4 = new TuyenLienTinh("DL123","DakLak",19,7,DonViGhe.DON_GIA_GHE,Tinh.DAKLAK,Tinh.HUE,199);
		TuyenLienTinh t5 = new TuyenLienTinh("DN123","DaNang",17,101,DonViGhe.DON_GIA_GHE,Tinh.DANANG,Tinh.HANOI,552);
		TuyenLienTinh t6 = new TuyenLienTinh("H123","Hue",5,2,DonViGhe.DON_GIA_GHE,Tinh.HUE,Tinh.HANOI,212);
		
		TuyenNoiTinh nt1 = new TuyenNoiTinh("TB155","TanBinh",25,29,DonVi.DON_GIA_KM,159.0,true);
		TuyenNoiTinh nt2 = new TuyenNoiTinh("PN335","PhuNhuan",155,259,DonVi.DON_GIA_KM,129.0,false);
		TuyenNoiTinh nt3 = new TuyenNoiTinh("TD515","ThuDuc",125,219,DonVi.DON_GIA_KM,222.0,false);
		TuyenNoiTinh nt4 = new TuyenNoiTinh("QT215","QuangTrung",61,42,DonVi.DON_GIA_KM,519.0,true);
		
		String troll = "dfafad";
		String header = String.format("%-10s | %-15s | %5s | %10s | %-15s | %-15s | %-15s",  
				 "tenTuyen"
				,"soChuyen"
				,"soNgay"
				,"donViGhe"
				,"tinhXuatPhat"
				,"tinhDen"
				,"soLuongGhe"
				);
		
		QuanLyTuyenXe QuanLy = new QuanLyTuyenXe();
		
		System.out.println(header);
		System.out.println("\n");
		System.out.println(QuanLy.themTuyenXe(nt1));
		System.out.println(QuanLy.themTuyenXe(nt2));
		System.out.println(QuanLy.themTuyenXe(nt3));
		System.out.println(QuanLy.themTuyenXe(nt4));
		System.out.println(QuanLy.themTuyenXe(t1));
		System.out.println(QuanLy.themTuyenXe(t2));
		System.out.println(QuanLy.themTuyenXe(t3));
		System.out.println(QuanLy.themTuyenXe(t4));
		System.out.println(QuanLy.themTuyenXe(t5));
		System.out.println(QuanLy.themTuyenXe(t6));
		System.out.println("\n");
		System.out.println("Danh Sach co luong ghe ngoi be hon 20");
		System.out.println("\n");
		List<TuyenLienTinh> danhSachBeHon20  = QuanLy.soLuongGheNgoiNhoHon20();
		
		
		
		danhSachBeHon20.forEach(t -> System.out.println(t));
		System.out.println("\n");
		System.out.println("XapXepGiamDanTheoDoanhThuNeuTrungDoanhThuThiTangDanTheoLop");
		
		
		
		
		
	}
	
	
	
}

