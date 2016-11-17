package HT_Exception_IO;

import java.io.*;

/**
 * Created by Luka on 09.12.2015.
 * Write a program that will copy several files into one.
 * Think of how to use this java.io.SequenceInputStream.
 */
public class copyfilesfrom2in1 {


    public static void main(String[] args) throws IOException {
        //
        int r;
        try (FileInputStream fis1 = new FileInputStream("c:\\test\\1.txt");
             FileInputStream fis2 = new FileInputStream("c:\\test\\2.txt");
             SequenceInputStream sis = new SequenceInputStream(fis1, fis2);
             FileOutputStream fos = new FileOutputStream("c:\\test2\\result.txt")) {
            do {
                r = sis.read();
                if (r != -1)
                    fos.write(r);
            } while (r != -1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}




