package com.ems.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ems.exception.DuplicateEmployeeException;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.model.Employee;
import com.ems.util.ValidationUtil;

public class EmployeeService {

    private Map<Integer, Employee> employeeDatabase = new HashMap<>();

    public void addEmployee(Employee emp) {
    	
    	 ValidationUtil.validateEmployee(emp);  // validation added

        if (employeeDatabase.containsKey(emp.getEmployeeId())) {
            throw new DuplicateEmployeeException("Employee ID already exists");
        }
        employeeDatabase.put(emp.getEmployeeId(), emp);
    }

    public Collection<Employee> getAllEmployees() {
        return employeeDatabase.values();
    }

    public Employee getEmployeeById(int id) {
        Employee emp = employeeDatabase.get(id);
        if (emp == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return emp;
    }

    public List<Employee> searchByName(String name) {
        return employeeDatabase.values().stream()
                .filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public void updateEmployee(int id, String name, String dept, double salary, String email) {
        Employee emp = getEmployeeById(id);

        emp.setName(name);
        emp.setDepartment(dept);
        emp.setSalary(salary);
        emp.setEmail(email);
        
        ValidationUtil.validateEmployee(emp);  // validate after update
    }

    public void deleteEmployee(int id) {
        if (!employeeDatabase.containsKey(id)) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        employeeDatabase.remove(id);
    }
}