package arrayPrograms;

import java.util.Arrays;

public class Program1 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int[] res = reverse(arr);
		System.out.println(Arrays.toString(res));
		int[] a = { 1, 3,5 };
		int[] b = { 1,2,4, 6 };
		System.out.println(Arrays.toString(merge2ArrayElemetsIntoSingle(a, b)));
		System.out.println(Arrays.toString(mergeSortedArrayInSortedManner(a, b)));
	}

	public static int[] reverse(int[] arr) {
		int i = 0, j = arr.length - 1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return arr;
	}

	public static int[] merge2ArrayElemetsIntoSingle(int[] a, int[] b) {
		int[] res = new int[a.length + b.length];
		int i = 0;
		for (int j = 0; j < a.length; j++) {
			res[i] = a[j];
			i++;
		}
		for (int j = 0; j < b.length; j++) {
			res[i] = b[j];
			i++;
		}
		return res;
	}

	public static int[] ZigZagMerge(int[] a, int[] b) {
		int[] res = new int[a.length + b.length];
		int i = 0;
		int k = 0;
		while (i < a.length && i < b.length) {
			res[k] = a[i];
			k++;
			res[k] = b[i];
			i++;
			k++;
		}
		while (i < a.length) {
			res[k] = a[i];
			k++;
			i++;
		}
		while (i < b.length) {
			res[k] = b[i];
			k++;
			i++;
		}
		return res;
	}

	public static int[] mergeSortedArrayInSortedManner(int[] a, int[] b) {
		int[] res=new int[a.length+b.length];
		int k=0;
		int i=0;
		int j=0;
		
		while(i<a.length && j<b.length) {
			if(a[i]<b[j]) {
				res[k]=a[i];
				k++;
				i++;
			}else {
				res[k]=b[j];
				k++;
				j++;
			}
		}
		while(i<a.length) {
			res[k]=a[i];
			k++;
			i++;
		}
		while(j<b.length) {
			res[k]=b[j];
			k++;
			j++;
		}
		return res;
	}
}


















