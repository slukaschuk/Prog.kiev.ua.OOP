package MyCollect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Write a method that creates a list, put it
 *   * 10 elements, then delete the first two and the last, and
 *   * And then displays the result on the screen
 */
public class MakeList {
    private List<Integer> l;

    MakeList() {
        this.l = new ArrayList<Integer>();
    }

    public List<Integer> makenewlist() {
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        l.remove(0);
        l.remove(0);
        l.remove(l.size() - 1);
        return l;
    }

    public static void main(String[] args) {
        MakeList ml = new MakeList();
        List<Integer> list = new ArrayList<Integer>();
        list = ml.makenewlist();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }

    }
}
