package nguyenvancongvinh_24681851;

import java.util.List;
import java.util.Map;

public interface TuyenXeIm {
	
	
//	2.1.  Thêm một đối tượng  chuyến xe  vào danh sách, không được thêm khi trùng mã  xe  và phải 
	
//	ném ra ngoại lệ cho người dùng biết khi chương trình có lỗi.
	abstract TuyenXe themTuyenXe(TuyenXe t);
//	2.2. Cập nhật tỉnh đến và tỉnh đi của một chuyến xe khi biết mã xe. 
	
	abstract TuyenLienTinh capNhat(String maXe, Tinh tinhDen, Tinh tinhXuatPhat);
	
//	2.3. Lấy danh sách chuyến xe có số lượng ghế ngồi nhỏ hơn 20 cái.
	
	abstract List<TuyenLienTinh> soLuongGheNgoiNhoHon20();
//	2.4.  Sắp xếp  giảm  dần chuyến xe  theo  doanh thu mỗi  chuyến,  nếu trùng  doanh thu  thì tiếp tục 
//	sắp xếp tăng dần theo loại (tên lớp) chuyến xe.
	
	abstract List<TuyenXe> XapXepGiamDanTheoDoanhThuNeuTrungDoanhThuThiTangDanTheoLop();
//	2.5.  Gom nhóm các  chuyến xe  theo loại (tên lớp) chuyến xe  và tổng số chuyến/ngày của mỗi 
//	nhóm.
	abstract Map<String ,Integer> gomNhomTheoLoaiTheoTongChuyenVaNgay();
}
