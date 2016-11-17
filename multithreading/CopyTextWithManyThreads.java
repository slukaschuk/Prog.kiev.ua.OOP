package multithreading;

import java.io.*;

/**
 * Write a class that enables you to record
  * Text data in one file from different flows ..
 */
public class CopyTextWithManyThreads {


    public static void main(String[] args) throws IOException, InterruptedException {
        MainOutput mainout = new MainOutput("C:\\test\\5.txt");
        CopyFileThread[] filelist = {new CopyFileThread(new File("C:\\test\\1.txt"), mainout),
                new CopyFileThread(new File("C:\\test\\2.txt"), mainout),
                new CopyFileThread(new File("C:\\test\\3.txt"), mainout),
                new CopyFileThread(new File("C:\\test\\4.txt"), mainout)};
        long start = System.currentTimeMillis();
        for (CopyFileThread cft : filelist) {
            cft.t.start();
        }
        long res = System.currentTimeMillis() - start;
        System.out.println("\n time(ms) = " + res);

    }

    public static class CopyFileThread implements Runnable {
        Thread t;
        private File source;
        private MainOutput out;

        CopyFileThread(File source, MainOutput output) {
            t = new Thread(this);
            this.source = source;
            this.out = output;

        }

        public void run() {
            synchronized (out) {
                try (RandomAccessFile fis = new RandomAccessFile(source, "r");
                     RandomAccessFile fos = new RandomAccessFile(out.getfile(), "rw")) {
                    System.out.println("source - "+source.getName());
                    long begin = out.getFlength();
                    fos.seek(begin);
                    long i = 0;
                    while (i < source.length()) {
                        fos.write(fis.read());
                        i++;
                    }
                    out.setFlength(begin+source.length());
                    out.setfile(out.getfile());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
            System.out.println("Копирование потоком с номером " + t.getId() + " завершено");
        }
    }
}






