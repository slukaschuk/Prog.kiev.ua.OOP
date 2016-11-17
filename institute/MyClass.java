package institute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyClass {
    public static class IllegalFormatException extends Exception {

        @Override
        public String toString() {
            return "Incorrect input.";
        }
    }

    public static class NoStudentBySurnameException extends Exception {

        @Override
        public String toString() {
            return "There is no student with this surname.";
        }
    }

    public static class NoStudentByNameException extends Exception {

        @Override
        public String toString() {
            return "There is no student with this name.";
        }
    }

    public static class OutOfBoundInStrudentsList extends Exception {

        @Override
        public String toString() {
            return "There is no data on selected position";
        }
    }


    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        StudentList sl = new StudentList();
        ParseStudentData parsd = new ParseStudentData();
        boolean exit = false;
        String choise = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("Choose action.");
                System.out.println("1 - Input information about student.");
                System.out.println("2 - Find student by Name.");
                System.out.println("3 - Find student by Surname.");
                System.out.println("4 - Find student by Birthday.");
                System.out.println("5 - Delete student by position in list.");
                System.out.println("6 - Show all students.");
                System.out.println("q - Exit.");
                choise = br.readLine();
                switch (choise) {
                    case "1": {
                        try {
                            parsd.inputStudent(sl);
                        } catch (Exception ex) {
                            ex.toString();
                        }
                        break;
                    }
                    case "2": {
                        parsd.findByName(sl);
                        break;
                    }
                    case "3": {
                        parsd.findBySurname(sl);
                        break;
                    }
                    case "4": {
                        parsd.findByDate(sl);
                        break;
                    }
                    case "5": {
                        parsd.delByIndex(sl);
                        break;
                    }
                    case "6": {
                        System.out.println("Our students.");
                        sl.showlist();
                        break;
                    }
                    case "q": {
                        System.out.println("The end of action.");
                        exit = true;
                        break;
                    }
                    default: {
                        System.out.println("Incorrect input. Try again");
                    }

                }
            } while (!exit);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
