package arrayPrograms;

import java.util.Arrays;

public class Program1 {

	public static void main(String[] args) {
//		int[] arr = { 1, 2, 3, 4 };
//		int[] res = reverse(arr);
//		System.out.println(Arrays.toString(res));
//		int[] a = { 1, 3, 5 };
//		int[] b = { 1, 2, 4, 6 };
//		System.out.println(Arrays.toString(merge2ArrayElemetsIntoSingle(a, b)));
//		System.out.println(Arrays.toString(mergeSortedArrayInSortedManner(a, b)));
//	m1();
//	m2();
//		m3();
		m5();
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
		int[] res = new int[a.length + b.length];
		int k = 0;
		int i = 0;
		int j = 0;

		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				res[k] = a[i];
				k++;
				i++;
			} else {
				res[k] = b[j];
				k++;
				j++;
			}
		}
		while (i < a.length) {
			res[k] = a[i];
			k++;
			i++;
		}
		while (j < b.length) {
			res[k] = b[j];
			k++;
			j++;
		}
		return res;
	}

	// find Frequency of characters
	public static void m1() {
		int[] arr = { 2, 5, 3, 4, 3, 2, 4, 6, 7 };

		boolean[] isChecked = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (isChecked[i] == false) {
				int count = 1;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] == arr[j]) {
						isChecked[j] = true;
						count++;
					}
				}
				System.out.println(arr[i] + " -> " + count);
			}
		}
	}
	/*
	 * 3. Print characters that appear more than once in a string using only nested
	 * loops (no Map or Set).
	 **/

	public static void m2() {
		String st = "sandeepa";

		char[] ch = st.toCharArray();

		boolean[] isChecked = new boolean[ch.length];

		for (int i = 0; i < ch.length; i++) {
			if (isChecked[i] == false) {
				int count = 1;
				for (int j = i + 1; j < ch.length; j++) {
					if (ch[i] == ch[j]) {
						count++;
						isChecked[j] = true;
					}
				}
				if (count > 1) {
					System.out.println(ch[i] + " -> " + count);
				}
			}
		}
	}

	/*
	 * 4. Swap the first and last characters of a string using loops only.
	 **/
	public static void m4() {
		String st = "abcdef";
		String res = "";
		char last = st.charAt(st.length() - 1);
		char first = st.charAt(0);
		for (int i = 0; i < st.length(); i++) {
			if (i == 0) {
				res = res + last;
			} else if (i == st.length() - 1) {
				res = res + first;
			} else {
				res = res + st.charAt(i);
			}
		}
		System.out.println(res);
	}
	/* 5.	Compare two string arrays and print elements that are 
	 * common using nested loops.
	 */
	public static void m5() {
		String[] arr1= {"ramu", "ammu", "rangu"}; 
		String[] arr2= {"xyz", "sandeep", "ramu"}; 
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i]==arr2[j]) {
					System.out.println(arr1[i]);
					break;
				}
			}
		}
		
	}
}










