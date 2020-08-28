package humanResouces2.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import humanResouces2.entities.Employee;
import humanResouces2.entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<Employee>();

		System.out.print("Enter the number of employees: ");
		int numberEmployees = sc.nextInt();

		for (int i = 1; i <= numberEmployees; i++) {

			System.out.println("Employee #" + i + " data:");

			System.out.print("Outsouced (y/n): ");
			char outsourcedEployee = sc.next().charAt(0);
			sc.nextLine();

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Hours: ");
			Integer hours = sc.nextInt();
			sc.nextLine();

			System.out.print("Value Per Hour: ");
			Double valuePerHour = sc.nextDouble();
			sc.nextLine();

			if (outsourcedEployee == 'y') {
				System.out.print("Additional charge: ");
				Double additionalCharge = sc.nextDouble();
				employees.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			} else {
				employees.add(new Employee(name, hours, valuePerHour));
			}
		}

		System.out.println();
		System.out.println("PAYMENTS:");
		for (Employee e : employees) {
			System.out.println(e.getName() + " - $ " + String.format("%.2f", e.payment()));
		}
		sc.close();
	}
}
