package stringPrograms;

public class Program1 {

	public static void main(String[] args) {
		m2();

	}

	/*
	 * 1.Write a program to reverse each word in a sentence individually using loops
	 * only.
	 **/
	public static void m1() {
		String sentence = "java is good";
		String[] str = sentence.split(" ");
		String result = "";

		for (int i = 0; i < str.length; i++) {
			String rev = "";
			String word = str[i];
			for (int j = 0; j < word.length(); j++) {
				rev = word.charAt(j) + rev;
			}
			str[i] = rev;
		}
		String res = String.join(" ", str);
		System.out.println(res);

	}

	/*
	 * 2. Count and print the number of vowels and consonants in a string without
	 * using toCharArray().
	 */
	public static void m2() {
		String st = "  i am sandeep  ";
		st = st.toLowerCase();
		int vcount = 0;
		int ccount = 0;
		for (int i = 0; i < st.length(); i++) {
			if (st.charAt(i) >= 'a' && st.charAt(i) <= 'z') {
				if (st.charAt(i) == 'a' || st.charAt(i) == 'e' || st.charAt(i) == 'i' || st.charAt(i) == 'o'
						|| st.charAt(i) == 'u') {
					vcount++;
				} else {
					ccount++;
				}
			}
		}
		System.out.println("Vowels count " + vcount);
		System.out.println("Consonant count " + ccount);

		
		////////////////////////
//		 String st = "  i am sandeep  ";
//
//		    int vcount = 0, ccount = 0;
//
//		    for (int i = 0; i < st.length(); i++) {
//
//		        char ch = Character.toLowerCase(st.charAt(i));
//
//		        if (Character.isLetter(ch)) {
//		            if ("aeiou".indexOf(ch) != -1) {
//		                vcount++;
//		            } else {
//		                ccount++;
//		            }
//		        }
//		    }
//
//		    System.out.println("Vowels count " + vcount);
//		    System.out.println("Consonant count " + ccount);
	}
	//find Frequency of characters
	public static void m3() {
		String st = "i am sandeep";
		
	}
}













