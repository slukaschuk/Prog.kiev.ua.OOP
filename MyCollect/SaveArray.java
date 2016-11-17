package MyCollect;

/**
 * Write a method that creates a list, put it
 *  10 elements, then delete the first two and the last, and
 *   And then displays the result on the screen...
 */
public class SaveArray<T extends Number> {
    private T[] arr;

    SaveArray(T[] arr) {
        this.arr = arr;
    }

    public T getbyindex(int index) {
        return arr[index];
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        Long[] arrl = {15L, 20L};
        Byte[] arrb = {1, 2, 3};
        SaveArray<Integer> saI = new SaveArray<Integer>(arr);
        System.out.println(saI.getbyindex(3));
        SaveArray<Long> saL = new SaveArray<Long>(arrl);
        System.out.println(saL.getbyindex(0));
    }
}
