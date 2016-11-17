package Phone;


public class IPhone extends Phone {
	public IPhone() {
		System.out.println("IPhone constructor");
		touch = true;
		hasWifi = true;
		screenSize = 3;
	}
	
	public IPhone(String phonenumber) {
		System.out.println("IPhone constructor");
		
		touch = true;
		hasWifi = true;
		screenSize = 3;
		setPhoneNumber(phonenumber);
	}
	
	@Override
	public void call(String number, Net net) {
		super.call(number, net);
		System.out.println("IPhone class is calling " + number);
	}
	
	@Override
	public void sendSMS(String number, String message) {
		System.out.println("IPhone class is sending sms " + message + " to " + number);	
		this.smscount++;
	}
}
