package com.ems.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ems.exception.DuplicateEmployeeException;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.model.Employee;

public class EmployeeService {

    private Map<Integer, Employee> employeeDatabase = new HashMap<>();

    // ✅ Add Employee
    public void addEmployee(Employee emp) {
        if (employeeDatabase.containsKey(emp.getEmployeeId())) {
            throw new DuplicateEmployeeException("Employee ID already exists");
        }
        employeeDatabase.put(emp.getEmployeeId(), emp);
    }

    // ✅ View All
    public Collection<Employee> getAllEmployees() {
        return employeeDatabase.values();
    }

    // ✅ Search by ID
    public Employee getEmployeeById(int id) {
        Employee emp = employeeDatabase.get(id);
        if (emp == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return emp;
    }

    // ✅ Search by Name (partial)
    public List<Employee> searchByName(String name) {
        return employeeDatabase.values().stream()
                .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    // ✅ Update
    public void updateEmployee(int id, String name, String dept, double salary, String email) {
        Employee emp = getEmployeeById(id);

        emp.setName(name);
        emp.setDepartment(dept);
        emp.setSalary(salary);
        emp.setEmail(email);
    }

    // ✅ Delete
    public void deleteEmployee(int id) {
        if (!employeeDatabase.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        employeeDatabase.remove(id);
    }
}