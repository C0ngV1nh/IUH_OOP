package nguyenvancongvinh_24681851;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class QuanLyTuyenXe implements TuyenXeIm {
	private List<TuyenXe> danhSach;

	public QuanLyTuyenXe() {
		this.danhSach = new ArrayList<TuyenXe>();
	}

	public List<TuyenXe> getDanhSach() {
		return new ArrayList<TuyenXe>(danhSach);
	}
	
	public int soLuongChuyenXe() {
		return this.danhSach.size();
	}

	@Override
	public TuyenXe themTuyenXe(TuyenXe t) {
		if(t== null) return null;
		
		List<TuyenXe> temp = getDanhSach();
		
		for(int i = 0 ; i < temp.size(); i++) {
			if(temp.get(i).getMaXe().equalsIgnoreCase(t.getMaXe())) return null;
		}
		temp.add(t);
		this.danhSach = temp;
		
		return t;
	}

	@Override
	public TuyenLienTinh capNhat(String maXe,Tinh tinhDen, Tinh TinhXuatPhat) {
		if(maXe == null || maXe.isEmpty()) throw new IllegalArgumentException("Ma Xe khong duoc rong");		
		
		List<TuyenXe> temp = getDanhSach();
		
		for(int i = 0 ; i < temp.size(); i++) {
			if(temp.get(i).getMaXe().contentEquals(maXe)) {
				TuyenLienTinh t1 = (TuyenLienTinh)temp.get(i);
				t1.setTinhDen(tinhDen);
				t1.setTinhXuatPhat(TinhXuatPhat);
				temp.set(i, t1);
				this.danhSach = temp;
				return t1;
			}
		}
		return null;
		
	}

	@Override
	public List<TuyenLienTinh> soLuongGheNgoiNhoHon20() {
		
		List<TuyenLienTinh> temp =  danhSach.stream()
				.filter(t -> t instanceof TuyenLienTinh)
				.map(t -> (TuyenLienTinh)t )
				.collect(Collectors.toList());
		
		return temp.stream()
				.filter( t -> t.getSoLuongGhe() < 20)
				.toList();
	}

	@Override
	public List<TuyenXe> XapXepGiamDanTheoDoanhThuNeuTrungDoanhThuThiTangDanTheoLop() {	
		return	this.danhSach.stream()
				.sorted(Comparator.comparing(TuyenXe::tinhDoanhThu)
				.reversed()
				.thenComparing(T -> T.getClass().getSimpleName()))
				.toList();	
	}

		@Override
		public Map<String, Integer> gomNhomTheoLoaiTheoTongChuyenVaNgay() {
			
			return this.danhSach.stream()
					.collect(Collectors.groupingBy(T -> T.getClass().getSimpleName(),
													Collectors.summingInt( t -> t.getSoNgay() + t.getSoChuyen())));
							
						
				

				
	}
	
	
}
