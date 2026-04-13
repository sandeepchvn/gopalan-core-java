package streamPrograms1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8MethodCheatSheet {

	public static void main(String[] args) {
		
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		
	}
	//filter stream and return in List
	public static void m1() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
					employees.stream()
					.filter(e->e.getDept().equals("Development")&& e.getSalary()>650000)
					.collect(Collectors.toList());
				System.out.println(employees);
					
	}
	//filter stream and return in Set
	public static void m2() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		Set<Employee> resu=employees.stream()
		.filter(e->e.getDept().equals("Development")&& e.getSalary()>650000)
		.collect(Collectors.toSet());
		System.out.println(employees);
		
	}
	//filter stream and return in Map<ID,NAME>
	public static void m3() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		Map<Integer,String> resu=employees.stream()
				.filter(e->e.getDept().equals("Development")&& e.getSalary()>650000)
				.collect(Collectors.toMap(e->e.getId(), e->e.getName()));
		System.out.println(employees);
		
	}
	//to fetch all departments 
	public static void m4() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		List<String> resu=employees.stream()
		.map(e->e.getDept())	
		.distinct()
		.collect(Collectors.toList());
		System.out.println(employees);
		
	}
	//coverting list of list to one stream and performing oper
	public static void m5() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
//		List<Stream<String>> resu=employees.stream()
//				.map(e->e.getProjects().stream().map(p-> p.getName()))
//				.collect(Collectors.toList());
//		System.out.println(employees);
		List<String> res=employees.stream()
		.flatMap(e->e.getProjects().stream())
		.map(p->p.getName())
		.collect(Collectors.toList());
		System.out.println(res);
	}
	//sorting employee by Salary
	public static void m6() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		List<Employee> resu=employees.stream()
		.sorted(Comparator.comparing(e->e.getSalary()))
//		.sorted(Comparator.comparing(e->e.getSalary()).reversed())
//		.sorted(Collections.reverseOrder(Comparator.comparing(e->e.getSalary())))
		.collect(Collectors.toList());
	}
	public static void m7() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		Optional<Employee> resu=employees.stream()
//		.max(Comparator.comparing(e->e.getSalary()));	
		.min(Comparator.comparing(e->e.getSalary()));	
		System.out.println(resu);
		
	}
	public static void m8() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		Map<String, List<Employee>> employeeGroup=employees.stream()
		.collect(Collectors.groupingBy(e->e.getGender()));
		System.out.println(employeeGroup);
	}
	public static void m9() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		Map<String, List<String>> employeeGroup=employees.stream()
				.collect(Collectors.groupingBy(e->e.getGender(),Collectors.mapping(e->e.getName(), Collectors.toList())));
		System.out.println(employeeGroup);
	}
	//gender count
	public static void m10() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		Map<String, Long> count=employees.stream()
		.collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting()));
		System.out.println(count);
	}
	public static void m11() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		Optional<Employee> optional=employees.stream()
		.filter(e->e.getDept().equals("Development"))
		.findFirst();
	}
	public static void m12() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		boolean dev=employees.stream()
				.anyMatch(e-> e.getDept().equals("dev"));
	}
	public static void m13() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		boolean dev=employees.stream()
				.allMatch(e-> e.getDept().equals("dev"));
	}
	public static void m14() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		boolean dev=employees.stream()
				.noneMatch(e-> e.getDept().equals("dev"));
	}
	public static void m15() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		List<Employee> res	=employees.stream()
		.sorted(Comparator.comparing(Employee::getSalary).reversed())
		.limit(3)
		.collect(Collectors.toList());
	}
	public static void m16() {
		List<Employee> employees =EmployeeDataBase.getAllEmployees();
		List<Employee> res	=employees.stream()
				.skip(10)
				.collect(Collectors.toList());
	}
}
