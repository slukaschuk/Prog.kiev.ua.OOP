/*Write a list of parsing method parameters in the URL format:
para1 = value1 & param2 = value2 & param3 = value3. In case of errors in
format throw an exception.*/
package HT_Exception_IO;

import java.util.Arrays;

public class parsparam {
	public static class MyException extends Exception {
		public MyException(String message) {
			super(message);
		}

		@Override
		public String getMessage() {
			return "Invalid line set url: " + super.getMessage();
		}

	}

	public static class Parser {
		public void parsstring(String url) throws MyException {
			int count1 = 0;
			
			String[] par1 = url.split("&");
			
			System.out.println(Arrays.toString(par1));
			for (String s : par1) {
				String[] substring = s.split("=");
				if (substring.length != 2) {
					throw new  MyException("Error string");
				}
			}
			

		}

	}

	public static void main(String[] args) {
		String url = "paramvalue1&param2=value2&param3=value3";
		Parser parser = new Parser();
		try {
			parser.parsstring(url);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
