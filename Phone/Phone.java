package Phone;


public abstract class Phone {
	
	protected boolean touch;
	protected boolean hasWifi;
	protected int screenSize;
	protected int callcount;
	protected int smscount;
	protected String phonenumber;
	
	
	public Phone() {
		System.out.println("Phone constructor");
		callcount = 0;
		smscount = 0;
	}
	
	protected String getPhoneNumber(){
		return phonenumber;
	}
	
	protected void setPhoneNumber(String phonenumber){
		this.phonenumber = phonenumber;
	}
	
	public boolean isTouch() {
		return touch;
	}
	
	public boolean isHasWifi() {
		return hasWifi;
	}
	
	public int getScreenSize() {
		return screenSize;
	}
	
	public int getSMScount() {
		return smscount;
	}
	
	public int getcallcount() {
		return callcount;
	}
	
	public void call(String number, Net net) {
		System.out.println("Phone class is calling " + number);
		callcount++;
		if (net.isPhone(number)){
			net.getPhoneByNumber(number).answer(this);
			}
		else{System.out.println("The network does not have a phone with this number!");}
		
	}
	
	public void answer(Phone obj){
		System.out.println("Answer to-"+ obj.getPhoneNumber());
		
	}
	
	public abstract void sendSMS(String number, String message);
}
