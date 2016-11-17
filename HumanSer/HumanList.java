package HumanSer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class HumanList implements Serializable {
    private Set<Human> humanlist;

    HumanList(){
        this.humanlist = new HashSet<Human>(10);
    }

    public void addhuman(Human h){
        humanlist.add(h);
    }

    public Set<Human> getlist(){
        return humanlist;
    }

}
