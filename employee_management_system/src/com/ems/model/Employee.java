package com.ems.model;

public class Employee {

		private int employeeId;
	    private String name;
	    private String department;
	    private double salary;
	    private String email;

	    // Constructor
	    public Employee(int employeeId, String name, String department, double salary, String email) {
	        this.employeeId = employeeId;
	        this.name = name;
	        this.department = department;
	        this.salary = salary;
	        this.email = email;
	    }

	    // Getters & Setters
	    public int getEmployeeId() { return employeeId; }
	    public String getName() { return name; }
	    public String getDepartment() { return department; }
	    public double getSalary() { return salary; }
	    public String getEmail() { return email; }

	    public void setName(String name) { this.name = name; }
	    public void setDepartment(String department) { this.department = department; }
	    public void setSalary(double salary) { this.salary = salary; }
	    public void setEmail(String email) { this.email = email; }

	    @Override
	    public String toString() {
	        return employeeId + " | " + name + " | " + department + " | " + salary + " | " + email;
	    }}
