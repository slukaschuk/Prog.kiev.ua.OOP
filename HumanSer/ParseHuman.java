package HumanSer;

import institute.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ParseHuman {

    public static class IllegalFormatException extends Exception {

        @Override
        public String toString() {
            return "Incorrect input.";
        }
    }


    public void inputStudent(HumanList list) {
       String name,sexstr,tempstr;
        int age;
        Sex sex;
        Temperament tpr;
        Scanner br = new Scanner(System.in);
        try {
            System.out.println("Input human name ");
            name = br.nextLine();
            checkString(name);
            System.out.println("Input human age ");
            age = br.nextInt();
            System.out.println("Input human sex m=male, f=female (male - default)");
            sexstr = br.next();
            sex = checkSex(sexstr);
            System.out.println("Input human temperament s=sanguine, c=choleric, p=phlegmatic, m=melancholiac (sanguine - default)");
            tempstr = br.next();
            tpr = checkTemperament(sexstr);
            list.addhuman(new Human(age, name, sex, tpr));
        }catch (IllegalFormatException e){
            System.out.println(e.toString());
        }


    }

    public void checkString(String str) throws IllegalFormatException {
        if (str.length() == 0) throw new IllegalFormatException();

        str = str.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < 65) || (str.charAt(i) > 90)) {
                System.out.println("Error input string");
            }

        }
    }
    public Sex checkSex(String str) {
        if (str.length() == 0) {return Sex.male;
        }
        str = str.toUpperCase();
        if(str == "M") {return Sex.male;}
        if(str == "F") {return Sex.female;}
        else {return  Sex.male;}
    }

    public Temperament checkTemperament(String str) {
        if (str.length() == 0) {return Temperament.sanguine;
        }
        str = str.toUpperCase();
        if(str == "S") {return Temperament.sanguine;}
        if(str == "C") {return Temperament.choleric;}
        if(str == "P") {return Temperament.phlegmatic;}
        if(str == "M") {return Temperament.melancholiac;}
        else {return Temperament.sanguine;}

    }

}
