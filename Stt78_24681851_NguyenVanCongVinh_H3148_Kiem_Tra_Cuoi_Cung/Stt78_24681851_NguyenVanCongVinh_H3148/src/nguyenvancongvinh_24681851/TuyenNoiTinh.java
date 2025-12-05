package nguyenvancongvinh_24681851;

public class TuyenNoiTinh extends TuyenXe{
	public TuyenNoiTinh(String maXe, String tenTuyen, int soChuyen, int soNgay,DonVi donVi,double quangDuong,boolean coDieuHoa) {
		super(maXe, tenTuyen, soChuyen, soNgay);
		setQuangDuong(quangDuong);
		setCoDieuHoa(coDieuHoa);
		setDonVi(donVi);
		// TODO Auto-generated constructor stub
	}
	public DonVi getDonVi() {
		return donVi;
	}

	public void setDonVi(DonVi donVi) {
		if(!(donVi instanceof DonVi))	 throw new IllegalArgumentException("don vi khong ton tai");	
			this.donVi = donVi;
	}
	
	private double quangDuong;
	private boolean coDieuHoa;
	private DonVi donVi;
	public double getQuangDuong() {
		return quangDuong;
	}

	public void setQuangDuong(double quangDuong) {
		if(quangDuong <= 0) throw new IllegalArgumentException("Quang duong khong hop le");
		this.quangDuong = quangDuong;
	}

	public boolean isCoDieuHoa() {
		return coDieuHoa;
	}

	public void setCoDieuHoa(boolean coDieuHoa) {
		coDieuHoa = coDieuHoa;
	}

	@Override
	public double tinhDoanhThu() {
		if(this.coDieuHoa == true) {
			return this.quangDuong * (donVi.getGia() + donVi.getGia()*0.05); 
		}else {
			return this.quangDuong * donVi.getGia();
		}
		
	}
	@Override
	public String toString() {
		return String.format("%s | %10s | %-15s | %-15s ",  
				super.toString()
				,quangDuong
				,coDieuHoa
				,donVi
				);
	}
	
}
