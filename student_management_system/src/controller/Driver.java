package controller;

import java.util.Scanner;

import exception.InvalidAgeExcetion;
import exception.StudentCountExceededException;
import exception.StudentNotFoundException;
import model.Student;
import service.StudentService;
import service.StudentServiceImp;

public class Driver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentServiceImp(50);

		while (true) {
			try {
				System.out.println("\n===== Student Management System =====");
				System.out.println("1. Add Student");
				System.out.println("2. View All Students");
				System.out.println("3. Search Student");
				System.out.println("4. Update Student");
				System.out.println("5. Delete Student");
				System.out.println("6. Exit");
				System.out.print("Enter choice: ");

				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {

				case 1:
					System.out.print("Enter ID: ");
					int id = Integer.parseInt(sc.nextLine());

					System.out.print("Enter Name: ");
					String name = sc.nextLine();
					if (name == null || name.trim().isEmpty()) {
					    throw new IllegalArgumentException("Student name cannot be null or empty");
					}
					System.out.print("Enter Age: ");
					int age = Integer.parseInt(sc.nextLine());
					if (age <= 0) {
						throw new InvalidAgeExcetion("Student Age " + age + " is invalid");
					}
					System.out.print("Enter Course: ");
					String course = sc.nextLine();

					System.out.print("Enter Marks: ");
					double marks = Double.parseDouble(sc.nextLine());
					if (marks <= 0) {
						throw new InvalidAgeExcetion("Student Marks " + marks + " is invalid");
					}
					service.addStudent(new Student(id, name, age, course, marks));
					break;

				case 2:
					service.viewAllStudents();
					break;

				case 3:
					System.out.print("Enter ID to search: ");
					int searchId = Integer.parseInt(sc.nextLine());
					System.out.println(service.findStudentByID(searchId));
					break;

				case 4:
					System.out.print("Enter ID to update: ");
					int updateId = Integer.parseInt(sc.nextLine());
					service.updateStudentByID(updateId);
					break;

				case 5:
					System.out.print("Enter ID to delete: ");
					int deleteId = Integer.parseInt(sc.nextLine());
					service.deleteStudentByID(deleteId);
					break;

				case 6:
					System.out.println("Exiting... Thank you!");
					System.exit(0);

				default:
					System.out.println("Invalid choice");
				}

			} catch (StudentNotFoundException | StudentCountExceededException e) {
				System.out.println(e.getMessage());
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("Invalid input! Try again.");
			}
		}
	}
}
