package chuong1_2_3.bai5;

public class CDList {
	private int count;
	private CD[] cdList;
	
	public CDList(int n) {
		count = 0;
		this.cdList = new CD[n];
	}
	
	public int getCount() {
		return this.count;
	}
	public CD[] getCDList() {
		return this.cdList;
	}
	
	public boolean findCD(long maCD) {
        for (int i = 0; i < count; i++) {
            if (this.cdList[i].getMaCD() == maCD) {
                return true;
            }
        }
        return false;
    }
	
	public void addCD(CD newCd) {
		if(this.count < cdList.length && !findCD(newCd.getMaCD())) {
			this.cdList[count] = newCd;
			count++;
		}else {
			System.out.println("the CDlist  is already full!");
		}
	}
	
	public void soLuongCd() {
		 System.out.println("So luong CD trong danh sach: " + getCount()); 
	}
	
	public double tongGia() {
		double sum = 0.0;
		
		for(CD cd : cdList) {
			if(cd!=null)
			sum+=cd.getGia();
		}
		
		return sum;
		
	}
	
	
	public void thongTinTatCa() {
		for(CD cd : cdList) {
			if(cd!=null)
			System.out.println(cd);
		}
	}
	
	public void tangDanTheoTuaCD() {
		
		int i = 0,j = 0;
		
		for(i = 0 ; i < count-1 ; i++) {
			for(j = i+1 ; j < count ; j++) {
				if(this.cdList[i].getTuaCD().compareTo(this.cdList[j].getTuaCD()) > 0) {
					CD temp = new CD();
					temp = this.cdList[i];
					this.cdList[i] = this.cdList[j];
					this.cdList[j] = temp;
				}
			}
		}
		
		
	}
	
	
	public void sapXepGiamDanTheoMaCD() {
		
		int i = 0,j = 0;
		
		for(i = 0 ; i < count-1 ; i++) {
			for(j = i+1 ; j < count ; j++) {
				if(this.cdList[i].getMaCD() < this.cdList[j].getMaCD()) {
					CD temp = new CD();
					temp = this.cdList[i];
					this.cdList[i] = this.cdList[j];
					this.cdList[j] = temp;
				}
			}
		}
		
		
	}
}
