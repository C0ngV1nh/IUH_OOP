package nguyenvancongvinh_24681851;

public class TuyenLienTinh  extends TuyenXe{
	
	
	public TuyenLienTinh(String maXe, String tenTuyen, int soChuyen, int soNgay,DonViGhe donViGhe,Tinh tinhXuatPhat,Tinh tinhDen,int soLuongGhe) {
		super(maXe, tenTuyen, soChuyen, soNgay);
		setTinhXuatPhat(tinhXuatPhat);
		setTinhDen(tinhDen);
		setSoLuongGhe(soLuongGhe);
		
		
	}
	public DonViGhe getDonViGhe() {
		return donViGhe;
	}


	public void setDonViGhe(DonViGhe donViGhe) {
		this.donViGhe = donViGhe;
	}
	private Tinh tinhXuatPhat;
	private Tinh tinhDen;
	private int soLuongGhe;
	private DonViGhe donViGhe;
	
	
	public Tinh getTinhXuatPhat() {
		return tinhXuatPhat;
	}


	public void setTinhXuatPhat(Tinh tinhXuatPhat) {
		if( !(tinhXuatPhat instanceof Tinh)) throw new IllegalArgumentException("Tinh khong hop le");
		this.tinhXuatPhat = tinhXuatPhat;
	}


	public Tinh getTinhDen() {
		return tinhDen;
	}


	public void setTinhDen(Tinh tinhDen) {
		if( !(tinhDen instanceof Tinh)) throw new IllegalArgumentException("Tinh khong hop le");
		this.tinhDen = tinhDen;
	}


	public int getSoLuongGhe() {
		return soLuongGhe;
	}


	public void setSoLuongGhe(int soLuongGhe) {
		if(soLuongGhe <= 0) throw new IllegalArgumentException("SO luong ghe khong hop le");
		this.soLuongGhe = soLuongGhe;
	}


	@Override
	public double tinhDoanhThu() {
		
		if(this.soLuongGhe <= 16) {
			return this.soLuongGhe * this.donViGhe.getGia();
		}else {
			return (this.soLuongGhe * this.donViGhe.getGia() ) -  (this.soLuongGhe * this.donViGhe.getGia() * 0.1) ;
		}
	}
	
//	public TuyenLienTinh(String maXe, String tenTuyen, int soChuyen, int soNgay,DonViGhe donViGhe,Tinh tinhXuatPhat,Tinh tinhDen,int soLuongGhe) {
//		super(maXe, tenTuyen, soChuyen, soNgay);
//		setTinhXuatPhat(tinhXuatPhat);
//		setTinhDen(tinhDen);
//		setSoLuongGhe(soLuongGhe);
//		
//		
//	}
	@Override
	public String toString() {
		return String.format("%5s | %10s | %-15s | %-15s | %-15s | %5s",  
				super.toString()
				,soNgay
				,donViGhe
				,tinhXuatPhat
				,tinhDen
				,soLuongGhe);
	}
	
	
	
	
}
