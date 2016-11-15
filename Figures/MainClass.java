package Figures;

import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		Rectangle r = new Rectangle(5, 4);
		System.out.println(r.getS());
		r.drawRectangle((char)4, (char)10);
		Figure r1 = new Circle(2);
		System.out.println(r1.getS());
		Figure r2 = new Triangle(2,3,4,4);
		System.out.println(r2.getS());
		
		Figure[] list = {r1,r2,r};
		Arrays.sort(list , new FigureComparator());
		for (Figure l:list){
			System.out.println(l.getS());
		}

	}

}
