package HumanHome;

/*Modify the code for sorting to Human
members ranked their descending.*/

public class Human implements Comparable {
    private int age;

    public Human(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
