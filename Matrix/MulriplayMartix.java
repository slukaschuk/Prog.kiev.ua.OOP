package Matrix;

import java.util.Arrays;

//matrix multiplication in multithreading
public class MulriplayMartix {
    public static void matrmult(int[][] arrA, int[][] arrB) {
        int[][] arrC;
        int n1 = arrA.length;//lines
        int m1 = arrA[0].length;//columns
        int n2 = arrB.length;//lines
        int m2 = arrB[0].length;//columns
        arrC = new int[n1][m2];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                if (j < m1 - 1) {
                    System.out.print(arrA[i][j] + ",");
                } else {
                    System.out.print(arrA[i][j]);
                }
            }
            System.out.println("");
        }
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                if (j < m2 - 1) {
                    System.out.print(arrB[i][j] + ",");
                } else {
                    System.out.print(arrB[i][j]);
                }
            }
            System.out.println("");
        }
        ///matrix multiplication
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                for (int r = 0; r < n2; r++) {
                    arrC[i][j] += arrA[i][r] * arrB[r][j];
                }
            }
        }
        //**********
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m2; j++) {
                if (j < m2 - 1) {
                    System.out.print(arrC[i][j] + ",");
                } else {
                    System.out.print(arrC[i][j]);
                }
            }
            System.out.println("");
        }

    }

    public static class MyThread implements Runnable {
        Thread t;
        private int[][] arrA;
        private int[][] arrB;
        private MainMatrix arrC;
        private int count;

        MyThread(int[][] arrA, int[][] arrB, MainMatrix arrC, int count) {
            t = new Thread(this);
            this.arrA = arrA;
            this.arrB = arrB;
            this.arrC = arrC;
            this.count = count;
            t.start();
        }

        @Override
        public void run() {
            ///matrix multiplication
            for (int i = count; i <= count; i++) {
                for (int j = 0; j < arrB.length; j++) {
                    int res = 0;
                    for (int r = 0; r < arrB.length; r++) {
                        res += arrA[i][r] * arrB[r][j];
                    }
                    arrC.setIndex(i, j, res);
                }
                break;
            }

        }
    }

    public static void main(String[] args) {
        int[][] arrA, arrB;
        arrA = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        arrB = new int[][]{{8, 7, 6, 5}, {4, 3, 2, 1}, {1, 2, 3, 4}, {5, 6, 7, 8}};
        long start = System.nanoTime();
        matrmult(arrA, arrB);
        long end = System.nanoTime();
        System.out.println("Fulltime = " + (end - start));

        //
        start = System.nanoTime();
        int n = arrA.length;//строк
        MainMatrix arrC = new MainMatrix(n, n);
        for (int i = 0; i < n; i++) {
            MyThread mt = new MyThread(arrA, arrB, arrC, i);
            try {
                mt.t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        end = System.nanoTime();
        System.out.println("Fulltime = " + (end - start));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    System.out.print(arrC.getIndex(i, j) + ",");
                } else {
                    System.out.print(arrC.getIndex(i, j));
                }
            }
            System.out.println("");
        }

    }
}
