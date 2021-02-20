package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.Department;
import entities.enums.*;
import entities.Worker;
import entities.HourContract;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department´s name: ");
		String dName = sc.nextLine();
		Department department = new Department(dName);

		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String wName = sc.nextLine();

		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		Double bSalary = sc.nextDouble();

		Worker worker = new Worker(wName, bSalary, WorkerLevel.valueOf(level), department);

		System.out.print("How many contracts to this worker?: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data: ");

			System.out.println("Date: dd/MM/yyyy");
			Date contractDate = sdf.parse(sc.next());

			System.out.println("Value per hour: ");
			Double vp = sc.nextDouble();
			System.out.println("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract hc = new HourContract(contractDate, vp, hours);
			worker.addContract(hc); // * Método para adicionar na lista de contratos *//

		}
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
	    String monthAndYear = sc.next();
	    
	    int month = Integer.valueOf(monthAndYear.substring(0, 2));
	    int year = Integer.valueOf(monthAndYear.substring(3, 6));
		
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.println("Income for "+monthAndYear+": "+String.format("%.2f",worker.income(year, month)));
		
		
		

		sc.close();
	}

}
