package chuong1_2_3.bai5;

public class CD {
	private long maCD;
	private String tuaCD;
	private long soBaiHat;
	private double Gia;
	
	public CD() {
		this.maCD = 999999;
		this.tuaCD = "chua xac dinh";
	}
	
	
	public CD(long maCD, String tuaCD, long soBaiHat, double gia) {
		
		setMaCD(maCD) ;
		setTuaCD(tuaCD);
		setSoBaiHat(soBaiHat);
		setGia(gia);
	}

	public long getMaCD() {
		return maCD;
	}
	public void setMaCD(long maCD) {
		if(maCD <= 0 ) throw new IllegalArgumentException();
		this.maCD = maCD;
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) {
		if(tuaCD.isEmpty()) throw new IllegalArgumentException();
		this.tuaCD = tuaCD;
	}
	public long getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(long soBaiHat) {
		if(soBaiHat <= 0 ) throw  new IllegalArgumentException();
		this.soBaiHat = soBaiHat;
	}
	public double getGia() {
		return Gia;
	}
	public void setGia(double gia) {
		if(gia <= 0 ) throw  new IllegalArgumentException();
		Gia = gia;
	}
	
	@Override
	public String toString() {
		return "CD [maCD=" + maCD + ", tuaCD=" + tuaCD + ", soBaiHat=" + soBaiHat + ", Gia=" + Gia + "]";
	}
	
}
