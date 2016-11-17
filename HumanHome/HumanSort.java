package HumanHome;

import java.util.Arrays;

/*Modify the code for sorting to Human
members ranked their descending.*/
public class HumanSort {

    public static void main(String[] args) {
        Human[] list = {new Human(10), new Human(20), new Human(35), new Human(7)};
        Arrays.sort(list, new HumanComparator());
        for (Human h : list)
            System.out.println(h.getAge());

    }

}
