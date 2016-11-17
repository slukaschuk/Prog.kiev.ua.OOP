package Phone;


public class SamsungS4 extends Phone {
	
	public SamsungS4(String phonenumber) {
		System.out.println("Samsung S4 constructor");
		
		touch = true;
		hasWifi = true;
		screenSize = 5;
		setPhoneNumber(phonenumber);
	}
	
	@Override
	public void call(String number, Net net) {
		super.call(number, net);
		System.out.println("Samsung S4 class is calling " + number);
	}
	
	@Override
	public void sendSMS(String number, String message) {
		System.out.println("Hello. Samsung S4 class is sending sms " + message + " to " + number);
		this.smscount++;
	}
}
