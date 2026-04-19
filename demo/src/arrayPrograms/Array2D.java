package arrayPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class Array2D {

	public static void main(String[] args) {
//		m1();
//		m2();
		m3();
		
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
	// taking elements in 2D array
	public static void m3() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter numbers of rows");
		int r=sc.nextInt();
		System.out.println("enter numbers of colums");
		int c=sc.nextInt();
		int[][] arr=new int[r][c];
		for(int i=0;i<arr.length;i++) {
			System.out.println("enter "+arr[i].length+" elements");
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		print2DArray(arr);
	}
	public static void print2DArray(int[][] arr) {
		//arr.length -> number of rows will be given
		for(int r=0;r<arr.length;r++) {
			System.out.println(Arrays.toString(arr[r]));
			System.out.println();
		}
	}
	
}
