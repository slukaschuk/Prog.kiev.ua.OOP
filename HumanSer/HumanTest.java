
/*
1. Написать класс «человек». Реализовать его методы clone,
equals, hashCode, toString.
2. Реализовать возможность сериализации для класса «человек».
3. Написать программу, которая запросит ввести с консоли
информацию о 10 людях, запишет ее на диск, а при следующем
старте прочитает записи и выведет сохраненные данные на
экран. Одинаковые записи должны игнорироваться (Set +
equals*).*/
package HumanSer;

import java.io.*;
import java.util.Iterator;

/*
* 1. Write a class of "man." To realize his methods clone,
equals, hashCode, toString.
2. Implement the ability to serialize the class "man".
3. Write a program that asks for input from the console
about 10 people will write it to disk, and the next
read start recording and display the saved data on
screen. Identical records should be ignored (Set +
equals *).*/
public class HumanTest {

    public static void main(String[] args) {
        //1 and 2 task
        /*try {
			Human h1 = new Human(28,"Serg", Sex.male, Temperament.sanguine);
			Human h2 = new Human(33, "Sveta", Sex.female, Temperament.choleric);
			System.out.println(h1.toString());
			System.out.println(h1.hashCode());
			FileOutputStream fos = new FileOutputStream("c:\\humanout.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			try {
				oos.writeObject(h1);
				} finally {
				oos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/

        //3 task
        // HumanList hl = new HumanList();
        boolean exit = false;
        String choise = "";
        ParseHuman parshum = new ParseHuman();
        HumanList hlist = new HumanList();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("Choose action.");
                System.out.println("1 - Input information about 10 human.");
                System.out.println("2 - Show information about human from HumanList.");
                System.out.println("3 - Save human list.");
                System.out.println("4 - Restore human list.");
                System.out.println("q - Exit.");
                choise = br.readLine();
                switch (choise) {
                    case "1": {
                        try {
                            for (int i = 0; i < 2; i++) {
                                parshum.inputStudent(hlist);
                            }
                        } catch (Exception ex) {
                            ex.toString();
                        }
                        break;
                    }
                    case "2": {
                        Iterator<Human> it = hlist.getlist().iterator();
                        while (it.hasNext()) {
                            System.out.println(it.next());
                        }
                        break;
                    }
                    case "3": {
                        FileOutputStream fos = new FileOutputStream("c:\\humanlist.txt");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        try {
                            oos.writeObject(hlist);
                            System.out.println("Human list was saved");
                        } finally {
                            oos.close();
                        }
                        break;
                    }
                    case "4": {
                        FileInputStream fis = new FileInputStream("c:\\humanlist.txt");
                        ObjectInputStream oin = new ObjectInputStream(fis);
                        try {
                            hlist = (HumanList) oin.readObject();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } finally {
                            oin.close();
                        }
                        System.out.println("Imported list");
                        Iterator<Human> it = hlist.getlist().iterator();
                        while (it.hasNext()) {
                            System.out.println(it.next());
                        }
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
