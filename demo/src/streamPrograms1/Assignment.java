package streamPrograms1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Assignment {
	public static void main(String[] args) {
		m10();
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
*/
	public static void m3() {
		List<Employee> list = EmployeeDataBase.getAllEmployees();
		Optional<Double> secondHightest=list.stream()
		.map(e->e.getSalary())
		.distinct()
		.sorted(Comparator.reverseOrder())
		.skip(1)
		.findFirst();
		
		secondHightest.ifPresentOrElse(
		sal->System.out.println("second highest sal "+sal), 
		()-> System.out.println("no second highest sal"));
	}
	
/*4. Top N Employees Per Department
Given a list of employees,
Group them by department
Within each department, find top 3 highest-paid employees
Sort each group in descending order of salary
*/
	public static void m4() {
		List<Employee> employees = EmployeeDataBase.getAllEmployees();
		
		Map<String, List<Employee>> result =
			    employees.stream()
			        .collect(Collectors.groupingBy(
			            Employee::getDept,
			            Collectors.collectingAndThen(
			                Collectors.toList(),
			                list -> list.stream()
			                        .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
			                        .limit(3)
			                        .collect(Collectors.toList())
			            )
			        ));
	}
/*5. Duplicate Detection (Optimized)
Given a list of integers,
Find all duplicate elements using Streams
Avoid using Collections.frequency() (optimize for performance)
 * */
	public static void m5() {
		List<Integer> list=Arrays.asList(6,3,9,2,5,6,3,5,7);
		Set<Integer> seen = new HashSet<>();

		Set<Integer> duplicates =
				list.stream()
		        .filter(n -> !seen.add(n))
		        .collect(Collectors.toSet());
	}
/*7. Custom Sorting Scenario
Given a list of employees,
Sort employees first by department (ascending)
Then by salary (descending)
Then by name (ascending)
*/
	public static void m8() {
		List<Employee> employees = EmployeeDataBase.getAllEmployees();
		List<Employee> sortedList =
			    employees.stream()
			        .sorted(
			            Comparator.comparing(Employee::getDept)                 // 1. Dept ASC
			                      .thenComparing(Employee::getSalary, Comparator.reverseOrder()) // 2. Salary DESC
			                      .thenComparing(Employee::getName)                  // 3. Name ASC
			        )
			        .collect(Collectors.toList());
	}
/*Given a list of employees,
Partition them into two groups:
•	salary > 50,000 
•	salary ≤ 50,000
Also count how many employees fall into each group 
 * */
	public static void m9() {
		List<Employee> employees = EmployeeDataBase.getAllEmployees();
		Map<Boolean, Long> countMap =
			    employees.stream()
			        .collect(Collectors.partitioningBy(
			            e -> e.getSalary() > 50000,
			            Collectors.counting()
			        ));
	}
/*11. Flatten Nested Collections
You are given:
List<List<Integer>> numbers
Flatten this into a single list
Remove duplicates
Sort in ascending order
 * */
	public static void m10() {
		List<List<Integer>> numbers = new ArrayList<>();

		// Add the first row
		numbers.add(new ArrayList<>()); 
		numbers.get(0).add(20);
		numbers.get(0).add(10);
		numbers.get(0).add(20);

		// Add the second row
		numbers.add(new ArrayList<>());
		numbers.get(1).add(30);
		numbers.get(1).add(10);
		
		List<Integer> res=numbers.stream()
		.flatMap(list-> list.stream())
		.distinct()
		.sorted()
		.collect(Collectors.toList());
		
		System.out.println(res);
		
		
		
		
	}
}
