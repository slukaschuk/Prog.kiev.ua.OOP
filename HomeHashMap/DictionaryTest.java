package HomeHashMap;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

/**
 * Created on 16.01.2016.
 */
public class DictionaryTest {
    public static void main(String[] args) {
        Dictionary lingvo = new Dictionary();
        String choise = "";
        String rus, eng;
        boolean exit = false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("Choose action.");
                System.out.println("1 - Input new word into Dictionary.");
                System.out.println("2 - Translate word.");
                System.out.println("3 - Translate text.");
                System.out.println("4 - Show dictionary.");
                System.out.println("5 - Save dictionary.");
                System.out.println("6 - Restore dictionary.");
                System.out.println("q - Exit.");
                choise = br.readLine();
                switch (choise) {
                    case "1": {
                        System.out.println("Input russian word");
                        rus = br.readLine();
                        System.out.println("Input english word");
                        eng = br.readLine();
                        lingvo.setWord(rus,eng);
                        break;
                    }
                    case "2": {
                        System.out.println("Input russian word");
                        rus = br.readLine();
                        eng = lingvo.translateWord(rus);
                        System.out.println("Result - "+ eng);
                        break;
                    }
                    case "3": {
                       System.out.println("Input text for translation");
                        rus = br.readLine();
                        eng = lingvo.translateText(rus);
                        System.out.println("Result - "+ eng);
                        break;
                    }
                    case "4": {
                        Iterator<Map.Entry<String, String>> itr = lingvo.getMydict().entrySet().iterator();
                        while (itr.hasNext())
                            System.out.println(itr.next());
                        break;
                    }
                    case "5": {
                       FileOutputStream fos = new FileOutputStream("c:\\lingvo.txt");
                       ObjectOutputStream oos = new ObjectOutputStream(fos);
                       try {
                           oos.writeObject(lingvo);
                           System.out.println("My dictionary was saved");
                       } finally {
                           oos.close();
                       }
                        break;
                    }
                    case "6": {
                       FileInputStream fis = new FileInputStream("c:\\lingvo.txt");
                       ObjectInputStream oin = new ObjectInputStream(fis);
                       try {
                           lingvo = (Dictionary) oin.readObject();
                       } catch (ClassNotFoundException e) {
                           e.printStackTrace();
                       } finally {
                           oin.close();
                       }
                       System.out.println("Dictionary was impported");
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

