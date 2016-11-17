package Phone;


public class Nokia3310 extends Phone {
	
	public Nokia3310(String phonenumber) {
		System.out.println("Nokia3310 constructor");
		
		touch = false;
		hasWifi = false;
		screenSize = 2;
		setPhoneNumber(phonenumber);
	}
	
	@Override
	public void call(String number, Net net) {
		super.call(number, net);
		System.out.println("Nokia3310 class is calling " + number);
	}
	
	@Override
	public void sendSMS(String number, String message) {
		System.out.println("Nokia3310 class is sending sms " + message + " to " + number);	
		this.smscount++;
	}
}
