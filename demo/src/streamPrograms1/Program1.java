package streamPrograms1;

import java.lang.StackWalker.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program1 {

	public static void main(String[] args) {
//		limit();
//		skip();
//		intStream();
//		reduce();
		parallelStream();
	}

	public static void flatMap() {
		List<List<String>> sentenceList = Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C", "D"));
		List<String> st = sentenceList.stream().flatMap((List<String> s) -> s.stream()).collect(Collectors.toList());
		System.out.println(st);// o/p -> A,B,C,D

		Stream<String> stream = sentenceList.stream().flatMap(s -> s.stream().map(n -> n.toLowerCase()));
		System.out.println(stream.collect(Collectors.toList()));// a,b,c,d
	}

	public static void peek() {
		List<Integer> list = Arrays.asList(4, 2, 7, 9, 3, 2);
		List<Integer> res = list.stream().filter(n -> n > 3).peek(n -> {
			System.out.println(n);
		}).collect(Collectors.toList());
	}

	public static void limit() {
		List<Integer> list = Arrays.asList(4, 2, 7, 9, 3, 2);
		List<Integer> res = list.stream().limit(3).collect(Collectors.toList());
		System.out.println(res);
	}

	public static void skip() {
		List<Integer> list = Arrays.asList(4, 2, 7, 9, 3, 2);
		List<Integer> res = list.stream().skip(3).collect(Collectors.toList());
		System.out.println(res);
	}

	public static void intStream() {
//		List<Integer> list = Arrays.asList(4,2,7,9,3,2);
//			list.stream().filter(n->n%2==0).mapToInt(n-> Integer.parseInt(n));
	}

	// terminal op
	public static void forEachDemo() {
		List<Integer> list = Arrays.asList(4, 2, 7, 9, 3, 2);
		list.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));
	}

	// terminal op
	public static void toArray() {
		List<Integer> list = Arrays.asList(4, 2, 7, 9, 3, 2);
		Object[] ar = list.stream().filter(n -> n % 2 == 0).toArray();
		Integer[] ar2 = list.stream().filter(n -> n % 2 == 0).toArray(size -> new Integer[size]);
	}

	// terminal op
	public static void reduce() {
		List<Integer> list = Arrays.asList(4, 2, 7, 9, 3, 2);
		Optional<Integer> integer = list.stream().reduce((n1, n2) -> n1 + n2);
		System.out.println(integer.get());
	}
	// parallel stream is faster
	public static void parallelStream() {
		List<Integer> list = Arrays.asList(4, 2, 7, 9, 3, 2);
		long time=System.currentTimeMillis();
		list.stream().map(n->n*n).forEach(n->System.out.println(n));
		System.out.println("Sequential processing time "+(System.currentTimeMillis()-time));
		long time2=System.currentTimeMillis();
		list.parallelStream().map(n->n*n).forEach(n->System.out.println(n));
		System.out.println("parallel processing time "+(System.currentTimeMillis()-time2));
	}
}
