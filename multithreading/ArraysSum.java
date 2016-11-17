package multithreading;

import java.util.Arrays;

public class ArraysSum {

    static public class SumOfArray implements Runnable {
        private MainArray arr;
        private int startindex;
        private int endindex;
        Thread t;


        SumOfArray(MainArray arr, int begin, int end) {
            t = new Thread(this);
            this.arr = arr;
            this.startindex = begin;
            this.endindex = end;
            t.start();
        }

        @Override
        public void run() {
            synchronized (arr) {
                int sum = arr.getSum();
                int[] ourarr = arr.getarr(startindex, endindex);
                for (int i = 0; i < ourarr.length; i++) {
                    sum += ourarr[i];
                }
                arr.setSum(sum);
            }
        }
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] arr = new int[10000000];
        Arrays.fill(arr, 10);
        int res = 0;
        for (int i : arr) {
            res += i;
        }
        long end = System.nanoTime() - start;
        System.out.println("Simple way, res = " + res);
        System.out.println("Fulltime = " + end);

        //***********другой способ
        start = System.nanoTime();
        MainArray mr = new MainArray(arr);
        int num = 100;
        int tcount = arr.length / num;
        int count = 0;
        SumOfArray[] resarrays = new SumOfArray[num];
        for (int i = 0; i < num; i++) {
            SumOfArray soa = new SumOfArray(mr, i * tcount, (i + 1) * tcount);
            resarrays[i] = soa;
        }
        res = 0;
        for (SumOfArray i : resarrays) {
            try {
                i.t.join();
                res += i.arr.getSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        end = System.nanoTime() - start;
        System.out.println("res = " + mr.getSum());
        System.out.println("Fulltime = " + end);

    }
}
