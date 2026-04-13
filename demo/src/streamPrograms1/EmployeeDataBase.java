package streamPrograms1;

import java.util.Arrays;
import java.util.List;

public class EmployeeDataBase {

	public static List<Employee> getAllEmployees() {

		return Arrays.asList(

				new Employee(1, "Sandeep", "IT",
						Arrays.asList(new Project("P101", "Payment System", "Amazon", "Rahul"),
								new Project("P102", "Order Service", "Flipkart", "Anita")),
						75000, "Male"),

				new Employee(2, "Priya", "HR",
						Arrays.asList(new Project("P103", "Recruitment Portal", "Infosys", "Kiran")), 50000, "Female"),

				new Employee(3, "Rahul", "Finance",
						Arrays.asList(new Project("P104", "Billing System", "TCS", "Suresh"),
								new Project("P105", "Tax Automation", "Wipro", "Meena")),
						65000, "Male"),

				new Employee(4, "Anjali", "IT",
						Arrays.asList(new Project("P106", "Inventory System", "Amazon", "Rahul")), 80000, "Female"),

				new Employee(5, "Kiran", "IT", Arrays.asList(new Project("P107", "Search Engine", "Google", "Amit"),
						new Project("P108", "Ad Service", "Google", "Amit")), 90000, "Male"));
	}
}