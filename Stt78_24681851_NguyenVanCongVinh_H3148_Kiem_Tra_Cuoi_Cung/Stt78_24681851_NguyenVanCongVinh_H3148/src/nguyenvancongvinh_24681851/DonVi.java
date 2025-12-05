package nguyenvancongvinh_24681851;

public enum DonVi {
	DON_GIA_KM(4000);
	
	private double gia;
	
	private DonVi(double gia) {
		this.gia = gia;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}
	
}
