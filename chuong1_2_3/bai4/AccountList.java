package chuong1_2_3.bai4;



public class AccountList {
	private  int count;
	private Account[] accList;
	
	public AccountList() {
		Account[] accList = new Account[10];
		this.accList = accList;
		count = 0;
		
	} 
	
	public AccountList(int n) {
		if(n<=0) {
			count = 0;
			Account[] acc = new Account[10];
			this.accList = acc;
			
		}else {
			count=0;
			Account[] acc = new Account[n];
			this.accList = acc;
			
		}
		
		
	}
	
	
	public void themTk(long stk, String tenTk, double balance) {
		
		if(count < accList.length){
			Account acc = new Account(stk,tenTk,balance);
			this.accList[count] = acc;
			count++;
		}else {
			System.out.println("mang day");
		}
		
	}
	
	public Account[] getAccList() {
		return this.accList;
	}


	public void xoaTk(long stk) {
		int len = this.accList.length;
		for(int i = 0  ; i <  len; i++){
			if(accList[i].getStk() == stk) {
				accList[i] = null;
				for(int j = i+1 ; j < len ; j++) {
					accList[j-1] = accList[j];
				}
				accList[len-1] = null;
				count--;
				break;
			}
		}
	}
	
	
	public Account findTk(long stk) {
		
		for(int i = 0  ; i <  this.accList.length; i++){
			if(this.accList[i].getStk() == stk) {
				return this.accList[i];
			}
			
		}
		
		System.out.println("khong tim thay tai khoan");
		return null;
		
	}
	
	
	public int getCount() {
		return count;
	}

	public void inToanBoTk() {
		
		for(Account acc : this.accList) {
			if (acc != null) {
				System.out.println(acc);
			}
			
		}
		
	}
}
