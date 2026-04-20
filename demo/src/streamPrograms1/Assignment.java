package streamPrograms1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Assignment {
	public static void main(String[] args) {
		m2();
	}
/*1. Employee Department Count
You are given a list of Employee objects with fields: id, name, department, salary.
Write a Stream pipeline to group employees by department and return the count of employees in each department.
Ensure the result is sorted by department name.
*/
	public static void m1() {
		List<Employee> list = EmployeeDataBase.getAllEmployees();
		Map<String, Long> map=list.stream()
		.collect(Collectors.groupingBy(
//				Employee::getDept,
//			    TreeMap::new,
				   e -> e.getDept(),          // instead of Employee::getDept
                   () -> new TreeMap<>(),     // instead of TreeMap::new
				Collectors.counting()));
		
		map.forEach((dep,count)->System.out.println(dep+"->"+count));
	}
	/*2. Highest Salary Per Department
Given a list of employees,
 Group employees by department and find the employee with the highest salary in each department.
 If multiple employees have same salary, return all of them.

	 * */
	public static void m2() {
		List<Employee> list = EmployeeDataBase.getAllEmployees();
		Map<String, List<Employee>> groupByDep=list.stream().collect(Collectors.groupingBy((e)->e.getDept()));
		
	    Map<String, List<Employee>> result = new HashMap<>();

		for(Map.Entry<String, List<Employee>>  entry : groupByDep.entrySet()) {
			List<Employee> employees=entry.getValue();
		double maxSal=employees.stream().mapToDouble(e->e.getSalary()).max().orElse(0);
		
			List<Employee> highestPaid =employees.stream()
			.filter(e->e.getSalary()==maxSal).collect(Collectors.toList());
		
			result.put(entry.getKey(), highestPaid );
		}
		
		result.forEach((dep,emps)->System.out.println(dep+"->"+emps));
	}
/*3. Second Highest Salary
You are given a list of employee salaries.
Find the second highest salary.
Handle duplicate values correctly.
What will you return if all salaries are same?
 * */
	public static void m3() {
		List<Employee> list = EmployeeDataBase.getAllEmployees();
		list.stream()
		.mapToDouble(e->e.getSalary())
		.sorted(Comparator.reverseOrder())
		.skip(1);
		
		
}
