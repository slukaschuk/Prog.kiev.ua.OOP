package HT_Exception_IO;

import java.io.*;

/**
 * Write a program to copy all files from one directory to
 *   other.
 *   For the idea to create the files and take them by filling in the full record of the source code
 *   Deal with java.io.BufferedInputStream and java.io. BufferedOutputStream.
 *   №3 consider how to improve the program using these classes
 */
public class copyfileswithbuffer {


    public static void main(String[] args) throws IOException {
        //
        File dirs = new File("N:\\test\\");
        File[] list = dirs.listFiles();
        File diro = new File("N:\\test2\\");
        File newfile;

        long start = System.currentTimeMillis();
        int r;
        for (File f : list) {
            if (f.isFile()) {
                newfile = new File("N:\\test2\\" + f.getName());
                newfile.createNewFile();
                //first method
                try (FileInputStream fis = new FileInputStream("N:\\test\\" + f.getName());
                     FileOutputStream fos = new FileOutputStream("N:\\test2\\" + f.getName());
                     BufferedInputStream bis = new BufferedInputStream(fis);
                     BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                    byte[] buf = new byte[8192];
                    do {
                        r = bis.read(buf);
                        if (r > 0) {
                            bos.write(buf);
                        }
                    } while (r != -1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                //second method
                /* try (FileInputStream fis = new FileInputStream("N:\\test\\" + f.getName());
                     FileOutputStream fos = new FileOutputStream("N:\\test2\\" + f.getName())){
                    do {
                        r = fis.read();
                        if (r > 0){ fos.write(r);}
                    } while (r != -1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }*/

                //third method
                /* try (FileInputStream fis = new FileInputStream("N:\\test\\" + f.getName());
                     FileOutputStream fos = new FileOutputStream("N:\\test2\\" + f.getName())){
                      byte[] buf = new byte[8192];
                    do {
                        r = fis.read(buf);
                        if (r > 0){ fos.write(buf);}
                    } while (r != -1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }*/

            }
        }

        long res = System.currentTimeMillis() - start;
        System.out.print(res);
    }

}


