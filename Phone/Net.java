package Phone;

public class Net {
	protected Phone[] phonelist;
	private static int phonecount = 0;

	Net() {
		phonelist = new Phone[100];
	}

	public void AddToNet(Phone obj) {
		phonelist[phonecount++] = obj;
	}

	public void ShowNet() {
		for (int i = 0; i < phonecount; i++) {
			System.out.println("Telephone-" + phonelist[i].getPhoneNumber());
		}
	}

	public boolean isPhone(String number) {
		for (int i = 0; i < phonecount; i++) {
			if (number == phonelist[i].phonenumber) {
				return true;
			}
			
		}
		return false;
	}

	public Phone getPhoneByNumber(String number){
		for (int i = 0; i < phonecount; i++) {
			if (number == phonelist[i].phonenumber) {
				return phonelist[i];
			}
			
		}
		return null;
		
	}
}
