package Phone;


public class MainClass {

	public static void main(String[] args) {
		Net net = new Net();
		IPhone5 iphone5 = new IPhone5("12345");
		net.AddToNet(iphone5);
		//IPhone5 iphone5 = new IPhone5();
		System.out.println("IPhone screent size: " + iphone5.getScreenSize()+" and number - " +iphone5.getPhoneNumber());
		iphone5.call("123-45-67",net);
		iphone5.call("123-45-68",net);
		iphone5.sendSMS("567-78-88", "text message");
		iphone5.sendSMS("567-78-89", "text message");
		iphone5.sendSMS("567-78-90", "text message");
		
		SamsungS4 samsung = new SamsungS4("34432");
		net.AddToNet(samsung);
		System.out.println("Samsung S4 screent size: " + samsung.getScreenSize());
		samsung.call("12345",net);
		samsung.sendSMS("567-78-89", "text message");
		samsung.call("123",net);
		samsung.call("123-55",net);
		System.out.println("Number of calls from Samsung - " + samsung.getcallcount());
		System.out.println("Number of calls from  iphone5 - " + iphone5.getcallcount());
		System.out.println("Number of sms from Samsung - " + samsung.getSMScount());
		System.out.println("Number of sms from iphone5 - " + iphone5.getSMScount());
		
		System.out.println("----------------------------------");
		net.ShowNet();
	}
}
