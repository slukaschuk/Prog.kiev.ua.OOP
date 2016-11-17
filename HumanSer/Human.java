package HumanSer;

import java.io.Serializable;

public class Human implements Serializable, Cloneable {
    private int age;
    private String name;
    private Temperament persontemperament;
    private Sex personsex;


    public Human(int age, String n, Sex s, Temperament t) {
        this.age = age;
        this.name = n;
        this.persontemperament = t;
        this.personsex = s;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (personsex != other.personsex)
            return false;
        if (persontemperament != other.persontemperament)
            return false;
        return true;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return personsex;
    }

    public Temperament getTemperament() {
        return persontemperament;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((personsex == null) ? 0 : personsex.hashCode());
        result = prime * result + ((persontemperament == null) ? 0 : persontemperament.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Human. Name - " + getName() + " age - " + getAge() + " year's, sex - " + getSex() + ", Temperament- " + getTemperament();

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Human obj = (Human) super.clone();
        return obj;

    }

}
