package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutSourcedEmployee;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<Employee>();
		
		System.out.print("Enter the number of employees: ");
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++ ) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hour = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			if (c == 'y') {
				System.out.println("Additional Charge: ");
				double additionalCharge = sc.nextDouble();
				list.add(new OutSourcedEmployee(name, hour, valuePerHour, additionalCharge));
			} else {
				list.add(new Employee(name, hour, valuePerHour));
			}			
		}
		
		System.out.println();
		
		System.out.println("PAYMENTS: ");
		for(Employee emp : list) {
			System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()));
		}
		
		sc.close();
		
	}

}
