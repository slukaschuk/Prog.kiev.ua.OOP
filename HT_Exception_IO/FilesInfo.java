package HT_Exception_IO;


import java.io.*;
import java.util.Date;

/**
 * Write a program that will create a text file and write it
 *   a list of files (path, name, date of creation) from a given directory.
 */
public class FilesInfo {

    private static void listAll(String path, RandomAccessFile fos)
            throws IOException {
        File dir = new File(path);
        File[] list = dir.listFiles();
        for (File f : list) {
            if (f.isFile()) {
                long datem = f.lastModified();
                Date filedate = new Date(datem);
                fos.write(("Path - " + f.getParent() + " Name - " + f.getName() + " Date - " + filedate + System.getProperty("line.separator")).getBytes());
            }
        }
    }

    public static void main(String[] args) {
        final String path = "c:\\";
        final String outfile = "C:\\result.txt";
        try (RandomAccessFile fos = new RandomAccessFile(outfile, "rw")) {
            listAll(path, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
