package MyCollect;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Write a function to save the contents of a directory in the list and displays the first 5 items on the screen
 */
public class FiveFilesFromDir {

    public List<String> getfive(File dir, List<String> l){
        String[] filelist = dir.list();
        for (int i = 0; i<5;i++){
            l.add(filelist[i]);
        }
        return l;
    }

    public static void main(String[] args){
        FiveFilesFromDir ff = new FiveFilesFromDir();
        List<String> filelist = new ArrayList<String>();
        filelist = ff.getfive(new File("N:\\Music\\"),filelist);
        Iterator<String> it = filelist.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
