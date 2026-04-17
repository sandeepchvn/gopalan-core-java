package arrayPrograms;

import java.util.Arrays;

public class Array2D {

	public static void main(String[] args) {
//		m1();
		m2();
	}
	//printing 2d array
	public static void m1() {
		int[][] arr= {
				{1,2,3,4},
				{5,6},
				{7,8,9}
		};
		//arr.length -> number of rows will be given
		for(int r=0;r<arr.length;r++) {
			for(int c=0;c<arr[r].length;c++) {
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
	}
	//printing 2d array by using Arrays.toString() method
	public static void m2() {
		int[][] arr= {
				{1,2,3,4},
				{5,6},
				{7,8,9}
		};
		//arr.length -> number of rows will be given
		for(int r=0;r<arr.length;r++) {
			System.out.println(Arrays.toString(arr[r]));
			System.out.println();
		}
	}
}
