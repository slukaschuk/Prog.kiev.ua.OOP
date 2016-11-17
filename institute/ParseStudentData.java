package institute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ParseStudentData {

    public void inputStudent(StudentList list) {
        String name, surname, strbirthday;
        Date dbirthday = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Input student's name ");
            name = br.readLine();
            checkString(name);
            System.out.println("Input student's surname ");
            surname = br.readLine();
            checkString(surname);
            System.out.println("Input student's birthday in format dd/MM/yyyy ");
            strbirthday = br.readLine();
            try {
                dbirthday = sdf.parse(strbirthday);
                list.add(new Student(name, surname, dbirthday));
            } catch (Exception ex) {
                System.out.println("Wrong date format");
            }
        } catch (IOException | MyClass.IllegalFormatException e) {
            System.out.println(e.toString());
        }

    }

    public void checkString(String str) throws MyClass.IllegalFormatException {
        if (str.length() == 0) throw new MyClass.IllegalFormatException();
        str = str.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < 65) || (str.charAt(i) > 90)) {
                throw new MyClass.IllegalFormatException();
            }

        }
    }

    public void findByName(StudentList list) {
        String name;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Input student's name ");
            name = br.readLine();
            checkString(name);
            int pos = list.find(name);
            if (pos < 0) throw new MyClass.NoStudentByNameException();
            Student std = list.get(pos);
            System.out.println(std.toString());
        } catch (IOException | MyClass.IllegalFormatException | MyClass.NoStudentByNameException e) {
            System.out.println(e.toString());
        }
    }

    public void findBySurname(StudentList list) {
        String surname;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Input student's surname ");
            surname = br.readLine();
            checkString(surname);
            int pos = list.findSurname(surname);
            if (pos < 0) throw new MyClass.NoStudentBySurnameException();
            Student std = list.get(pos);
            System.out.println(std.toString());
        } catch (IOException | MyClass.IllegalFormatException | MyClass.NoStudentBySurnameException e) {
            System.out.println(e.toString());
        }
    }

    public void findByDate(StudentList list) {
        String strbirthday;
        Date dbirthday = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Input student's birthday ");
            strbirthday = br.readLine();
            try {
                dbirthday = sdf.parse(strbirthday);
            } catch (Exception ex) {
                System.out.println("Wrong date format");
            }
            int pos = list.findbyDate(dbirthday);
            if (pos < 0) throw new MyClass.NoStudentBySurnameException();
            Student std = list.get(pos);
            System.out.println(std.toString());
        } catch (IOException | MyClass.NoStudentBySurnameException e) {
            System.out.println(e.toString());
        }
    }

    public void delByIndex(StudentList list) {
        int pos;
        Scanner br = new Scanner(System.in);
        try {
            System.out.println("Input position in list");
            pos = br.nextInt();
            if ((pos < 0) || (pos >= list.getp())) throw new MyClass.OutOfBoundInStrudentsList();
            Student std = list.get(pos);
            list.delstudent(pos);
            System.out.println("From position - "+pos+" was deleted student - "+ std.toString() );
        } catch (MyClass.OutOfBoundInStrudentsList e )
        {
            System.out.println(e.toString());
        }
    }
}
