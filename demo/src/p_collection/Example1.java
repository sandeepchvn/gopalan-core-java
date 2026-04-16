package p_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Example1 {

	public static void main(String[] args) {
//		Iterator<E>-> hasNext() , next() , remove() , forEachRemaining(Consumer) 
//		Iterable<T> -> iterator(), forEach(Consumer), spliterator()
//      ListIterator -> remove(), set(E e) , add(E e)
//		m1();
		m2();
	}

	public static void m1() {
		List<String> data = Arrays.asList("Header", "Item1", "Item2", "Item3");
		Iterator<String> it = data.iterator();
		// 1. Process the first element specifically
		if (it.hasNext()) {
			System.out.println("Processing Title: " + it.next().toUpperCase());
		}

		// 2. Process all remaining elements the same way
		it.forEachRemaining(item -> System.out.println("Saving data: " + item));
	}

	public static void m2() {
		List<String> data = Arrays.asList("Header", "Item1", "Item2", "Item3");
		Spliterator<String> spliterator = data.spliterator();
			spliterator.forEachRemaining(s->System.out.println(s));
	}
	//Collection -> contains(object) , containsAll(Collection)
	public static void m3() {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
		boolean hasApple = fruits.contains("Apple"); // true
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> checkList = Arrays.asList(2, 4);

		boolean result = numbers.containsAll(checkList); // true
	}
	//Collection -> remove(object) , removeAll(Collection)
	public static void m4() {
		List<String> list = new ArrayList<>(Arrays.asList("A", "B", "A", "C"));
		list.remove("A"); 
		// Result: ["B", "A", "C"] (Only the fi	rst 'A' is gone)
		
		List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "A", "C"));
		list2.removeAll(Arrays.asList("A", "C")); 
		// Result: ["B"] (All 'A's and the 'C' are gone)
	}
	//public static void m4() {
	public static void m5() {
		List<String> list = new ArrayList<>(Arrays.asList("A", "B", "A", "C"));
		Object[] arr = list.toArray();

		Integer[] arr2 = list.toArray(new Integer[0]);
	}
	//Use of removeIf() -> Removes elements based on condition
	public static void m6() {
		List<Integer> list = new ArrayList<>(Arrays.asList(5,4,2,6,9));
		list.removeIf(n -> n % 2 == 0);
		System.out.println(list);
	}
	//Use of retainAll() -> Keeps only common elements
	public static void m7() {
		List<Integer> list = new ArrayList<>(Arrays.asList(5,4,2,6,9));
		list.retainAll(Arrays.asList(4,6));
		System.out.println(list);
	}
	//sort(Comparator) -> used to sort elements
	public static void m8() {
		List<Integer> list = new ArrayList<>(Arrays.asList(5,4,2,6,9));
		list.sort(Comparator.naturalOrder());
		list.sort(Comparator.reverseOrder());
		System.out.println(list);
	}
	//ConcurrentModificationException
	public static void m9() {
		List<Integer> list = new ArrayList<>(Arrays.asList(5,4,2,6,9));
		for (Integer i : list) {
		    list.remove(i); // ❌
		}
	}
	//UnsupportedOperationException
	public static void m10() {
		List<Integer> list = new ArrayList<>(Arrays.asList(5,4,2,6,9));
		List.of(1,2,3).add(4); // ❌
	}
	
	public static void m11() {
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(10, "A");
		map.put(11, "B");
		map.put(12, "C");
		
		Collection<String> values= map.values();
		Set<Integer> keys=map.keySet();
		Set<Entry<Integer, String>> set=map.entrySet();
		boolean r1=map.containsKey(3);
		boolean r2=map.containsValue("A");
	}
//	comparingByKey() -> Used to sort map entries by key
	public static void m12() {
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(10, "A");
		map.put(21, "B");
		map.put(12, "C");
		
		map.entrySet().stream().sorted(Entry.comparingByKey());
	}
//	forEach(BiConsumer)
	public static void m13() {
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(10, "A");
		map.put(21, "B");
		map.put(12, "C");
		
		map.forEach((k,v)->System.out.println(k+" ->"+v));
	}
//	replaceAll(BiFunction)--> Updates all values using function
	public static void m14() {
		Map<Integer, String> map=new HashMap<Integer, String>();
		map.put(10, "A");
		map.put(21, "B");
		map.put(12, "C");
		
		map.replaceAll((k,v)-> v+" end");
	}
	
	
	
	
	
	
	
	
	
	
}
