/*����� � ����������� ���������� 5 �������, ������ �������
������ ���������� � �������� ������ ���� ��� �� ���������
(������: Integer.parseInt).*/

package HT_Exception_IO;

import java.util.Date;

public class exeption2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try{
			int newstr = Integer.decode("hhjjh");
			System.out.println(newstr);
		}
		catch(NumberFormatException e){
			System.out.println(e);
			
		}
		
		 try{
	            Date date=new Date();
	            date.compareTo(null);
	        }
	        catch(NullPointerException e){
	            System.out.println("You can't compare to non-object.");
	        }
	        
	        try{
	            Thread pac1=new Thread();
	            pac1.destroy();
	        }
	        catch(NoSuchMethodError e){
	            System.out.println("There is no such method");
	        }
	        
	        try{
	            System.load("a");
	        }
	        catch(UnsatisfiedLinkError e){
	            System.out.println("The file doesn't exist.");
	        }
	        
	        try{
	            char[] ch={'a', 'b'};
	            int i=Character.codePointAt(ch, -2);
	        }
	        catch(IndexOutOfBoundsException e){
	            System.out.println("Incorrect input.");
	        }
	    }
		
		
		
	}


