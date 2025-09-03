package chuong1_2_3.bai2;

public class SinhVien {
	
	private int svId;
	private String name;
	private float pointLT;
	private float pointTH;
	
	
	public SinhVien() {
		setSvId(1);
		setName("no_name");
		setPointTH((float)0.0);
		setPointLT((float)0.0);
		
	}
	
	public SinhVien(int svId,String name, float pointLT,float pointTH) {
		
		setSvId(svId);
		setName(name);
		setPointTH(pointLT);
		setPointLT(pointTH);
	}

	public int getSvId() {
		return svId;
	}

	public void setSvId(int svId) {
		if(svId < 0 ) throw new IllegalArgumentException();
		this.svId = svId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name.isEmpty()) throw new IllegalArgumentException();
		this.name = name;
	}

	public float getPointLT() {
		return pointLT;
	}

	public void setPointLT(float pointLT) {
		if(pointLT < 0 ) throw new IllegalArgumentException();
		this.pointLT = pointLT;
	}

	public float getPointTH() {
		return pointTH;
	}

	public void setPointTH(float pointTH) {
		if(pointTH < 0 ) throw new IllegalArgumentException();
		this.pointTH = pointTH;
	}
	
	
	@Override
	public String toString() {
		return String.format("ID: %d, NAME: %-30s, DIEMTH: %5.2f, DIEMLT: %5.2f, Average: %5.2f ",this.svId,this.name,this.pointTH,this.pointLT,Average());
	}
	
	public float Average() {
		return (this.pointLT + this.pointTH)/2;
	}
	

}
