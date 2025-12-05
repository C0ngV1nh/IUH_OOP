package nguyenvancongvinh_24681851;

public enum DonViGhe {
	DON_GIA_GHE(75000);
	
	private double gia ;

	private DonViGhe(double gia) {
		setGia(gia);
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		if(gia <=0) throw new IllegalArgumentException("Gia khong hop le");
		this.gia = gia;
	}
	
}
