package streamPrograms1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MyPractice {

	public static List<Customer> getCustomers() {

		return Arrays.asList(

				new Customer(1, "Sandeep", "Bangalore", Arrays.asList(
						new Order(101, "Electronics", 50000, Arrays.asList(new Product(1, "Laptop", "Dell", 50000))),
						new Order(102, "Clothing", 3000, Arrays.asList(new Product(2, "Shirt", "Zara", 3000))))),

				new Customer(2, "Priya", "Hyderabad",
						Arrays.asList(new Order(103, "Electronics", 70000,
								Arrays.asList(new Product(3, "Mobile", "Samsung", 70000))))),

				new Customer(3, "Rahul", "Bangalore",
						Arrays.asList(new Order(104, "Furniture", 20000,
								Arrays.asList(new Product(4, "Table", "Ikea", 20000))))),

				new Customer(4, "Anjali", "Mumbai", Arrays.asList(
						new Order(105, "Electronics", 80000, Arrays.asList(new Product(5, "TV", "Sony", 80000))))));
	}

	public static void main(String[] args) {
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
//		m8();
//		m9();
//		m10();
//		m12();
//		m13();
//		m14();
//		m15();
//		m16();
		m18();
	}

	// Get all customer names
	public static void m1() {
		List<Customer> customers = getCustomers();
		List<String> names = customers.stream().map(c -> c.getName()).collect(Collectors.toList());
		System.out.println(names);
	}

	// Filter customers from Bangalore
	public static void m2() {
		List<Customer> customers = getCustomers();
		List<Customer> customersFromBangalore = customers.stream().filter(c -> c.getCity().equals("Bangalore"))
				.collect(Collectors.toList());
		System.out.println(customersFromBangalore);
	}

	// Get all orders
	public static void m3() {
		List<Customer> customers = getCustomers();
		List<Order> customersFromBangalore = customers.stream().flatMap(c -> c.getOrders().stream())
				.collect(Collectors.toList());
		System.out.println(customersFromBangalore);
	}

	// Count total customers
	public static void m4() {
		List<Customer> customers = getCustomers();
		long countOfCustomers = customers.stream().count();
		System.out.println(countOfCustomers);
	}

	// Find customer with max orders
	public static void m5() {
		List<Customer> customers = getCustomers();
		Optional<Customer> result = customers.stream().max(Comparator.comparing(c -> c.getOrders().size()));
		System.out.println(result.get());
	}

	/** Intermediate level */

	// Get all order amounts
	public static void m6() {
		List<Customer> customers = getCustomers();
		List<Double> orderAmountes = customers.stream().flatMap(c -> c.getOrders().stream().map(o -> o.getAmount()))
				.collect(Collectors.toList());
		System.out.println(orderAmountes);
	}

	// Total amount of all orders
	public static void m7() {
		List<Customer> customers = getCustomers();
		double sum = customers.stream().flatMap(c -> c.getOrders().stream()).mapToDouble(o -> o.getAmount()).sum();
		System.out.println(sum);
	}

//	Average order amount
	public static void m8() {
		List<Customer> customers = getCustomers();
//		double sum=customers.stream()
//				.flatMap(c->c.getOrders().stream())
//				.mapToDouble(o->o.getAmount())
//				.sum();
//		
//		long count=customers.stream()
//		.flatMap(c->c.getOrders().stream())
//		.count();
		double av = customers.stream().flatMap(c -> c.getOrders().stream()).mapToDouble(o -> o.getAmount()).average()
				.orElse(0.00);
		System.out.println("average order ammount " + av);
	}

//	Get all product names
	public static void m9() {
		List<Customer> customers = getCustomers();
		List<String> productName = customers.stream().flatMap(c -> c.getOrders().stream())// Customer → Order
				.flatMap(o -> o.getProducts().stream())// Order → Product
				.map(p -> p.getName())// Product → Name
				.toList();
		System.out.println(productName);
	}

//	 Get all products from all customers
	public static void m10() {
		List<Customer> customers = getCustomers();
		List<Product> products = customers.stream().flatMap(c -> c.getOrders().stream())
				.flatMap(o -> o.getProducts().stream()).collect(Collectors.toList());
		System.out.println(products);
	}

// Total revenue per city
	public static void m11() {
		List<Customer> customers = getCustomers();

		Map<String, Double> revenuePerCity = customers.stream().collect(Collectors.groupingBy(Customer::getCity,
				Collectors.flatMapping(c -> c.getOrders().stream(), Collectors.summingDouble(o -> o.getAmount()))));

		System.out.println(revenuePerCity);
	}

	// Customers grouped by city
	public static void m12() {
		List<Customer> customers = getCustomers();

		Map<String, List<Customer>> group = customers.stream().collect(Collectors.groupingBy(c -> c.getCity()));

		System.out.println(group);
	}

	// Most expensive product
	public static void m13() {
		List<Customer> customers = getCustomers();
		Optional<Product> expensiveProduct = customers.stream().flatMap(c -> c.getOrders().stream())
				.flatMap(o -> o.getProducts().stream()).max(Comparator.comparing(Product::getPrice));
		System.out.println(expensiveProduct);
	}

	// Orders above 50,000
	public static void m14() {
		List<Customer> customers = getCustomers();
		List<Order> orders = customers.stream().flatMap(c -> c.getOrders().stream()).filter(o -> o.getAmount() > 50000)
				.collect(Collectors.toList());
		System.out.println(orders);

	}

	// Get unique product brands
	public static void m15() {
		List<Customer> customers = getCustomers();
		List<String> brands = customers.stream().flatMap(c -> c.getOrders().stream())
				.flatMap(o -> o.getProducts().stream()).map(p -> p.getBrand()).distinct().toList();
		System.out.println(brands);
	}
	
	//Count orders per category
	public static void m16() {
		List<Customer> customers = getCustomers();
		Map<String,Long> orderPerCat=customers.stream()
		.flatMap(c->c.getOrders().stream())
		.collect(Collectors.groupingBy(c->c.getCategory(),Collectors.counting()));
		System.out.println(orderPerCat);
	}
	
	//Find customer who spent the most
	public static void m17() {
	    List<Customer> customers = getCustomers();

	    Customer result = customers.stream()
	        .max(Comparator.comparing(c ->
	            c.getOrders().stream()
	                .mapToDouble(Order::getAmount)
	                .sum()
	        ))
	        .orElse(null);

	    System.out.println(result);
	}
	// Get top 3 expensive orders
	public static void m18() {
	    List<Customer> customers = getCustomers();
	    	List<Order> orders=customers.stream()
	    	.flatMap(c->c.getOrders().stream())
	    	.sorted(Comparator.comparing(Order::getAmount).reversed())
	    	.limit(3)
	    	.toList();
	    	
	    	System.out.println(orders);
	}
	
	// Partition customers (spent > 50k or not)
	public static void m19() {
	    List<Customer> customers = getCustomers();
	   Map<Boolean, List<Customer>> map= customers.stream()
	    .collect(Collectors.partitioningBy(c->c.getOrders()
	    		.stream()
	    		.mapToDouble(o->o.getAmount())
	    		.sum()>50000
	    		));
	   System.out.println(map);
	
	}
	//Find duplicate product names
	public static void m20() {
		List<Customer> customers = getCustomers();

	    List<String> duplicates = customers.stream()
	        .flatMap(c -> c.getOrders().stream())
	        .flatMap(o -> o.getProducts().stream())
	        .map(Product::getName)
	        .collect(Collectors.groupingBy(
	            name -> name,
	            Collectors.counting()
	        ))
	        .entrySet().stream()
	        .filter(e -> e.getValue() > 1)
	        .map(e -> e.getKey())
	        .collect(Collectors.toList());

	    System.out.println(duplicates);
	    
//	    Collection<E>
		
	}
	//Sort customers by total spending
//	public static void m21() {
//		  List<Customer> customers = getCustomers();
//
//		    List<Customer> sortedCOustomers = customers.stream()
//		        .sorted(Comparator.comparing(c ->
//		            c.getOrders().stream()
//		                .mapToDouble(Order::getAmount)
//		                .sum()
//		        ).reversed()) // descending
//		        .collect(Collectors.toList());
//
//		    System.out.println(sortedCustomers);
//	}
	
	
}
