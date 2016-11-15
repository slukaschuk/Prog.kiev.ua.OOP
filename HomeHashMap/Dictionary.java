package HomeHashMap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 16.01.2016.
 */
public class Dictionary implements Serializable{
    private Map<String, String> mydict;

    public Dictionary() {
        this.mydict = new HashMap<String, String>();
    }

    public Map<String, String> getMydict() {
        return mydict;
    }

    public void setWord(String rus, String eng) {
        mydict.put(rus,eng);
    }

    public String translateWord(String rus){
        String eng = rus;
        for (Map.Entry<String, String> entry : mydict.entrySet()) {
            if(entry.getKey().equals(rus)){
                eng = entry.getValue();
                return eng;
            }

        }
        return eng;
    }

    public String translateText(String rus){
        StringBuilder sb = new StringBuilder();
        sb.append("");
        String[] arrstr = rus.split(" ");
        for (String str:arrstr){
            sb.append(translateWord(str)+" ");
        }
        return sb.toString();
    }


}
