package institute;

import java.util.Date;


public class StudentList {
	private Student[] list = new Student[100];
	private int p = 0;//index
	
	public void add(Student s) {
		if (p + 1 == list.length) {
			Student[] t = new Student[list.length * 2];
			System.arraycopy(list, 0, t, 0, list.length);
			list = t;
			}
			list[p++] = s;
	}
	
	public void delstudent(int n){
		if (n < 0 || n >= list.length)
			return; // index out of bounds
			Student[] t = new Student[list.length - 1];
			System.arraycopy(list, 0, t, 0, n);
			System.arraycopy(list, n + 1, t, n, t.length - n);
			list = t;
		    p--;
	}
	
	public Student get(int n) {
		return list[n];
	}
	
	public int find(String name) {
		for (int i = 0; i < p; i++) {
			if (list[i].getName().equalsIgnoreCase(name))
				return i;
		}
		
		return -1;
	}
	public int findSurname(String surname) {
		for (int i = 0; i < p; i++) {
			if (list[i].getSurname().equalsIgnoreCase(surname))
				return i;
		}
		
		return -1;
	}
	public int findbyDate(Date dateOfBirth) {
		for (int i = 0; i < p; i++) {
			if (list[i].getBirth().equals(dateOfBirth))
				return i;
		}
		
		return -1;
	}

	public void showlist(){
		if(p==0) System.out.println("Our student's list is empty.");
        for(int i=0; i<p;i++){
			System.out.println("Student name - "+list[i].getName()+" , surname - "+list[i].getSurname()+" , birthday - "+list[i].getBirth());
		}
	}

	public int getp(){
		return p;
	}

}
