package HT_Exception_IO;

import java.io.*;

/**
 * Write a program to copy all files from one directory to
 *   other.
 */
public class copyfiles {


    public static void main(String[] args) throws IOException {
        //
        File dirs = new File("c:\\test\\");
        File[] list = dirs.listFiles();
        File diro = new File("c:\\test2\\");
        File newfile;
        byte[] buf = new byte[1024];
        int r;
        long start = System.currentTimeMillis();
        for (File f : list) {
            if (f.isFile()) {
                newfile = new File("c:\\test2\\" + f.getName());
                newfile.createNewFile();
                try (FileInputStream fis = new FileInputStream("c:\\test\\" + f.getName());
                     FileOutputStream fos = new FileOutputStream("c:\\test2\\" + f.getName())) {
                    do {
                        r = fis.read(buf, 0, buf.length);
                        if (r > 0)
                            fos.write(buf, 0, r);
                    } while (r > 0);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        long res = System.currentTimeMillis() - start;
        System.out.print(res);
    }

}


