package threads;

import java.util.Arrays;
import java.util.List;

public class EvenAndOdd {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(8,6,5,9,2,4,3,3);
		
		Thread even=new Thread(
				()-> {
					for(int n:list) {
						if(n%2==0) System.out.println("even "+n);
					}
				}
				);
		Thread odd=new Thread(()->{
			for(int n:list) {
				if(n%2!=0) {
					System.out.println("odd "+n);
				}
			}
		}
				);
		
		even.start();
		odd.start();
	}
}
