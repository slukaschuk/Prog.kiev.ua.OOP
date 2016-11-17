/*Написать рекурсивную ф-ю для вывода на экран всех файлов и каталогов, имя которых
длиннее 5 символов и вторая буква равна ‘A’.*/

package recursion_project;
/*
* Write a recursive function to display all files and directories with names
longer than 5 characters, and the second letter is 'A'.
*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyClass {

    private static void listAll(String path, ArrayList<String> res)
            throws IOException {
        File dir = new File(path);
        File[] list = dir.listFiles();

        for (File f : list) {
            if (f.isFile()) {
                if ((f.getName().length() > 5) & (f.getName().charAt(1) == 'A')) {
                    res.add("F: " + f.getCanonicalPath());
                }

            } else {
                if ((f.getName().length() > 5) & (f.getName().charAt(1) == 'A')) {
                    res.add("D: " + f.getCanonicalPath());
                }
                listAll(f.getCanonicalPath(), res);
            }
        }
    }

    public static void main(String[] args) {
        final String path = "E:\\Java\\Doc";
        ArrayList<String> res = new ArrayList<String>();

        try {
            listAll(path, res);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : res)
            System.out.println(s);


    }
}