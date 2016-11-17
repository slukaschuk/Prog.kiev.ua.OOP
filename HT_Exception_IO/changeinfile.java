package HT_Exception_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class changeinfile {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("c:\\1.txt");
        String finstr = "";
        try {
            byte[] buf = new byte[1024];
            int r;
            FileOutputStream fos = new FileOutputStream("c:\\2.txt");
            try {
                do {
                    r = fis.read(buf, 0, buf.length);

                    if (r > 0) {
                        finstr = finstr.concat(new String(buf, 0, r));
                        System.out.println(finstr);
                    }
                } while (r > 0);
                finstr = finstr.replaceAll("hello", "1234");
                byte[] bufwr = finstr.getBytes();
                fos.write(bufwr);
            } finally {
                fos.close();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            fis.close();

        }
    }
}
