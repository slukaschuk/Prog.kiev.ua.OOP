package dev;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		// MiddleDeveloper
		/*Developer[] list = {
				new JuniorDeveloper("Mike", 500, 0),
				new JuniorDeveloper("Dima", 500, 1),
				new JuniorDeveloper("Vova", 500, 2),
				new SeniorDeveloper("Jack", 500, 5),
				//����� �����
				new MiddleDeveloper("Alex", 500, 3),
				new MiddleDeveloper("Sergey", 500, 3),
				new TeamLeadDeveloper("Robby", 500, 7)
		};
		StringBuilder sb;
		
		for (Developer d : list) {
			sb = new StringBuilder() // !!!
				.append(d.getName())
				.append(": ")
				.append(d.getBasicSalary())
				.append(" -> ")
				.append(d.getSalary());
			
			System.out.println(sb.toString());
		}*/
		Developer[] list = {
				new JuniorDeveloper("Mike", 500, 0),
				new MiddleDeveloper("Alex", 500, 3),
				new SeniorDeveloper("Jack", 300, 5),
				new JuniorDeveloper("Dima", 500, 1),
				new SeniorDeveloper("Bob", 500, 5),
				new JuniorDeveloper("Vova", 500, 2),
				new SeniorDeveloper("Marry", 500, 5),
				new MiddleDeveloper("Sergey", 500, 3),
				new TeamLeadDeveloper("Robby", 500, 7)
		};
		StringBuilder sb;
		for (Developer d : list) {
			sb = new StringBuilder() // !!!
				.append(d.getName())
				.append(": ")
				.append(d.getBasicSalary())
				.append(" -> ")
				.append(d.getSalary());
			
			System.out.println(sb.toString());
		}
		JuniorDeveloper[] listjuniour 	= new JuniorDeveloper[list.length];
		SeniorDeveloper[] listseniour 	= new SeniorDeveloper[list.length];
		TeamLeadDeveloper[] listteamlead 	= new TeamLeadDeveloper[list.length];
	
		int countjunior=0, countteamlead=0, countsenior=0;
		for (Developer d : list) {
			if (d instanceof JuniorDeveloper){
				listjuniour[countjunior++]=(JuniorDeveloper)d;
			}
			else if (d instanceof SeniorDeveloper){
				listseniour[countsenior++]=(SeniorDeveloper)d;
			}
			else if (d instanceof TeamLeadDeveloper)
			{
				listteamlead[countteamlead++]=(TeamLeadDeveloper)d;
			}
		}
		
		System.out.println("Junior");
		listjuniour = Arrays.copyOf(listjuniour, countjunior);
		listseniour = Arrays.copyOf(listseniour, countsenior);
		listteamlead = Arrays.copyOf(listteamlead, countteamlead);
		for (JuniorDeveloper d : listjuniour) {
			sb = new StringBuilder()
			.append(d.getName())
			.append(": ")
			.append(d.getBasicSalary())
			.append(" -> ")
			.append(d.getSalary());
		
		System.out.println(sb.toString());
		}
		System.out.println("Senior");
		for (SeniorDeveloper d : listseniour) {
			sb = new StringBuilder() 
			.append(d.getName())
			.append(": ")
			.append(d.getBasicSalary())
			.append(" -> ")
			.append(d.getSalary());
		
		System.out.println(sb.toString());
		}
		System.out.println("Teamlead");
		for (TeamLeadDeveloper d : listteamlead) {
			sb = new StringBuilder() 
			.append(d.getName())
			.append(": ")
			.append(d.getBasicSalary())
			.append(" -> ")
			.append(d.getSalary());
		
		System.out.println(sb.toString());
		}
	}
}
