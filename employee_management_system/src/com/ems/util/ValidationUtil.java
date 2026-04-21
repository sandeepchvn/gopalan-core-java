package com.ems.util;

import com.ems.model.Employee;

public class ValidationUtil {

    public static void validateEmployee(Employee emp) {

        if (emp.getEmployeeId() <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }

        if (emp.getName() == null || emp.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (emp.getSalary() <= 0) {
            throw new IllegalArgumentException("Salary must be greater than 0");
        }

        if (emp.getEmail() == null || !emp.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
}