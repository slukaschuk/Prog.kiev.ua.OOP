package multithreading;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MainArray {
    private int sum = 0;
    private int[] arr;

    MainArray(int[] arr) {
        this.arr = arr;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int[] getarr(int start, int end) {
        return Arrays.copyOfRange(arr, start, end);
    }


}
