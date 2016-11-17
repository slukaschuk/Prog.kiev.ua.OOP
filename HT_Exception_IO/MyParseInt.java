package HT_Exception_IO;

public class MyParseInt {

    public static class MyExeption extends Exception {
        public MyExeption(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return "Not right given the string parsing, because " + super.getMessage();
        }
    }

    public int parseMyInt(String str) throws MyExeption {
        int res  = 0;
        boolean sing = false;
        int count=0;
        if (str.length()>0) {

            if (str == null) {
                throw new MyExeption("null");
            }
            if (str.charAt(0)==45) {
                sing = true;
                count++;
            }
            for (int i = (0+count); i<str.length();i++){

                if ((str.charAt(i)<48)||(str.charAt(i)>57)) {
                    throw new MyExeption("in position "+i+" not number");
                }
             res += (str.charAt(i)-48)*Math.pow(10,str.length()-i-1);
            }

        }
      return sing ? -res:res;
    }

    public static void main(String[] args) {
        try {
            int result = new MyParseInt().parseMyInt("234");
            System.out.println(result);
            result = new MyParseInt().parseMyInt("-2342");
            System.out.println(result);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}


