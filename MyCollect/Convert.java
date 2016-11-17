package MyCollect;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method to convert an array of strings / numbers in the list.
 */
public class Convert<T>{

    public void convert (T[] arr, ArrayList<T> list){
        for (int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
    }


    public static void main(String[] args){
        Integer[] arr = {1,2,3,4};
        String[] arrs = {"qw", "er","tt"};
        ArrayList<Integer> list = new ArrayList<Integer>();
        Convert c = new Convert();
        c.<Integer>convert(arr, list);
        for (int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

}
