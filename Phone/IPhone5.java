package Phone;


public class IPhone5 extends IPhone {
	public IPhone5(String phonenumber) {
		System.out.println("IPhone5 constructor");

		screenSize = 4;
		setPhoneNumber(phonenumber);
	}
	
	@Override
	public void call(String number, Net net) {
		super.call(number, net);
		System.out.println("IPhone class is calling " + number);
	} 
	
	@Override
	public void sendSMS(String number, String message) {
		super.sendSMS(number, message);
		System.out.println("IPhone5 class is sending sms " + message + " to " + number);
		}
}
