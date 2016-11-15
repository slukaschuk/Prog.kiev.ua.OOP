package Figures;

import java.util.Comparator;

public class FigureComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2){
        Figure h1=(Figure) o1;
        Figure h2=(Figure) o2;
        
        if(h1.getS()<h2.getS())
            return -1;
        else if(h1.getS()==h2.getS())
            return 0;
        else if(h1.getS()>h2.getS())
            return 1;
        return 0;
    }
}