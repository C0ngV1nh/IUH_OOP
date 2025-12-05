package nguyenvancongvinh_24681851;

public abstract class TuyenXe {
	protected final String maXe;
	protected String tenTuyen;
	protected int soChuyen;
	protected int soNgay;
	public TuyenXe(String maXe, String tenTuyen, int soChuyen,int soNgay) {
		if(maXe == null || maXe.isEmpty()) {
			throw new IllegalArgumentException("Ma tuyen khong hop le");
		}
		this.maXe = maXe;
		setTenTuyen(tenTuyen);
		setSoChuyen(soChuyen);
	}
	public int getSoChuyen() {
		return soChuyen;
	}
	public void setSoChuyen(int soChuyen) {
		if(soChuyen <= 0) throw new IllegalArgumentException("So chuyen khong duoc bang 0");
		this.soChuyen = soChuyen;
	}
	public String getMaXe() {
		return maXe;
	}
	public String getTenTuyen() {
		return tenTuyen;
	}
	public void setTenTuyen(String tenTuyen) {
		if(tenTuyen == null || tenTuyen.isEmpty()) {
			throw new IllegalArgumentException("Ten tuyen khong hop le");
		}
		this.tenTuyen = tenTuyen;
	}
	public void setSoNgay(int soNgay) {
		if(soNgay <=0) throw new IllegalArgumentException("So ngay khong duoc bang 0");
	}
	public int getSoNgay() {
		return soNgay;
	}
	public abstract double tinhDoanhThu();
	
	@Override
	public String toString() {
		return String.format("%-10s | %-15s | %5s  ",  
				maXe
				,tenTuyen
				,soChuyen
				);
	}
	
	
}
