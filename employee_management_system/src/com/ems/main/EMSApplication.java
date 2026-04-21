package com.ems.main;

import java.util.Scanner;
import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.util.LoginManager;

public class EMSApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();
        LoginManager login = new LoginManager();

        //Login
        while (true) {
            System.out.print("Username: ");
            String user = sc.nextLine();

            System.out.print("Password: ");
            String pass = sc.nextLine();

            if (login.authenticate(user, pass)) {
                break;
            } else {
                System.out.println("Invalid credentials!");
            }
        }

        //Menu Loop
        while (true) {
            System.out.println("\n1.Add 2.View 3.Search 4.Update 5.Delete 6.Exit");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.println("Enter ID:");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Name:");
                        String name = sc.nextLine();

                        System.out.println("Dept:");
                        String dept = sc.nextLine();

                        System.out.println("Salary:");
                        double sal = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Email:");
                        String email = sc.nextLine();

                        service.addEmployee(new Employee(id, name, dept, sal, email));
                        break;

                    case 2:
                        service.getAllEmployees().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.println("Enter name:");
                        String search = sc.next();
                        service.searchByName(search).forEach(System.out::println);
                        break;

                    case 4:
                        System.out.println("Enter ID:");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.println("New Name:");
                        String n = sc.nextLine();

                        System.out.println("Dept:");
                        String d = sc.nextLine();

                        System.out.println("Salary:");
                        double s = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Email:");
                        String e = sc.nextLine();

                        service.updateEmployee(uid, n, d, s, e);
                        break;

                    case 5:
                        System.out.println("Enter ID:");
                        int did = sc.nextInt();
                        service.deleteEmployee(did);
                        break;

                    case 6:
                        System.exit(0);
                }

            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}