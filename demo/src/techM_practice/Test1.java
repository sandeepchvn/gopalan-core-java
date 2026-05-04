package techM_practice;

public class Test1 {

	public static void main(String[] args) {
//		int[] arr = { 3, 8, 6, 2 };
//		System.out.println(countOddEvenDifference(arr));
//		System.out.println(palindrome("abbbb"));
//		int[] arr = { 3, 8, 6, 2,3,6,6,6 };
//		m4(arr);
//		practice(arr);
//		demo2(arr);
		System.out.println(demo3("xyz","zyx"));
	}

	public static int countOddEvenDifference(int arr[]) {
		int ec = 0, oc = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0)
				ec++;
			else
				oc++;
		}
		return ec - oc;
	}

	/*
	 * Write a program to calculate and return the sum of absolute difference
	 * between the adjacent number in an array of positive integers from the
	 * position entered by the user.
	 */
	public static int sumOfAdjacent(int position, int[] arr) {
		int in = position - 1;
		int sum = 0;
		for (int i = in; i < arr.length - 1; i++) {
			sum += Math.abs(arr[i] - arr[i + 1]);
		}
		return sum;
	}

	/*
	 * Write a program to find the difference between the elements at odd index and
	 * even index.
	 */
	public static int diffOfOddIndex(int[] arr) {
		int oddSum = 0;
		int evenSum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				evenSum += arr[i];
			} else {
				oddSum += arr[i];
			}
		}
		return evenSum - oddSum;
	}

	public static void question3(int n, int[] arr) {
		int[] ar = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			int count = 0;
			if (num != 0) {
				count++;
			}
			ar[i] = count;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "->" + ar[i]);
		}
	}

	public static boolean palindrome(String st) {
		int last = st.length() - 1;
		int i = 0;
		while (i < last) {
			if (st.charAt(i) != st.charAt(last)) {
				return false;
			}
			i++;
			last--;
		}
		return true;
	}

	// First Non-Repeating Character
	public static char firstNonOccuChar(String st) {
		char[] ch = new char[256];
		for (char c : st.toCharArray()) {
			ch[c]++;
		}
		for (char c : st.toCharArray()) {
			if (ch[c] == 1) {
				return c;
			}
		}
		return '_';
	}

	public static void demo(int[] arr1, int[] arr2) {
		int[] arr3 = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr3[k] = arr1[i];
				i++;
			} else {
				arr3[k] = arr2[j];
				j++;
			}
			k++;
		}
		while (i < arr1.length) {
			arr3[k] = arr1[i];
			i++;
			k++;
		}
		while (j < arr2.length) {
			arr3[k] = arr1[j];
			j++;
			k++;
		}
		for (int n : arr3) {
			System.out.println(n);
		}
	}
	
	public static void m4(int[] arr) {
		boolean flag[]=new boolean[arr.length];
		for(int i=0;i<arr.length;i++) {
			if(flag[i]==false) {
				int count=1;
				for(int j=i+1;j<arr.length;j++) {
					if(arr[i]==arr[j]) {
						count++;
						flag[j]=true;
					}
				}
				System.out.println(arr[i]+"->"+count);
			}
		}
	}
	public static void practice(int[] arr) {
		boolean flag[]=new boolean[arr.length];
		int c=0;
		for(int i=0;i<arr.length;i++) {
			if(flag[i]==false) {
				for(int j=i+1;j<arr.length;j++) {
					if(arr[i]==arr[j]) {
						c++;
						flag[j]=true;
					}
				}
				//System.out.println(arr[i]+"->"+c);
			}
		}
		int[] res=new int[c];
		for(int i=0;i<arr.length;i++) {
			if(flag[i]==false) {
				System.out.println(arr[i]);
			}
		}
	}

	public static void demo2(int[] arr) {
		int[] res=new int[256];
		for(int i=0;i<arr.length;i++) {
			res[arr[i]]++;
		}
		for(int i=0;i<res.length;i++) {
			if(res[i]!=0) {
				System.out.println(i+"->"+res[i]);
			}
		}
	}
	public static boolean demo3(String s1,String s2) {
		int[] c=new int[26];
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();
		for(int i=0;i<s1.length();i++) {
			c[s1.charAt(i)-'a']++;
			c[s2.charAt(i)-'a']--;
		}
		for(int n:c) {
			if(n != 0) 
			{
				return false;
			}
		}
		return true;
	}
}






