package controller;

import java.util.Scanner;

import exception.InvalidAgeExcetion;
import exception.StudentCountExceededException;
import exception.StudentNotFoundException;
import model.Student;
import model.User;
import service.StudentService;
import service.StudentServiceImp;
import service.UserService;

public class Driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentServiceImp(50);
        UserService userService = new UserService();

        User loggedInUser = null;

        // 🔐 LOGIN / SIGNUP LOOP
        while (loggedInUser == null) {
            try {
                System.out.println("\n-------- LOGIN PAGE --------");
                System.out.println("1. Sign Up");
                System.out.println("2. Sign In");
                System.out.print("Enter choice: ");

                int loginChoice = Integer.parseInt(sc.nextLine());

                switch (loginChoice) {

                case 1:
                    System.out.print("Enter username: ");
                    String newUser = sc.nextLine();

                    System.out.print("Enter password: ");
                    String newPass = sc.nextLine();

                    userService.register(newUser, newPass);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    loggedInUser = userService.login(username, password);
                    System.out.println("Login successful! Role: " + loggedInUser.getRole());
                    break;

                default:
                    System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String role = loggedInUser.getRole();

        // 🔁 MAIN MENU LOOP
        while (true) {
            try {

                System.out.println("\n===== Student Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");

                if (role.equals("ADMIN")) {
                    System.out.println("5. Delete Student");
                }

                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    if (id < 1) {
                        throw new IllegalArgumentException("Student Id cannot be 0 or negative");
                    }

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
                    if (course == null || course.trim().isEmpty()) {
                        throw new IllegalArgumentException("Course cannot be empty");
                    }

                    System.out.print("Enter Marks: ");
                    double marks = Double.parseDouble(sc.nextLine());
                    if (marks < 0 || marks > 100) {
                        throw new IllegalArgumentException("Marks must be between 0 and 100");
                    }

                    service.addStudent(new Student(id, name.trim(), age, course.trim(), marks));
                    break;

                case 2:
                    if (!role.equals("ADMIN")) {
                        throw new IllegalAccessException("Only admin can view all students");
                    }
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
                    if (!role.equals("ADMIN")) {
                        throw new IllegalAccessException("Only admin can delete students");
                    }
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
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
            }
        }
    }
}