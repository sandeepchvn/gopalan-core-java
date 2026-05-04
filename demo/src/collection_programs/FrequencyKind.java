package collection_programs;

import java.util.HashMap;
import java.util.Map;

public class FrequencyKind {

	public static void main(String[] args) {
//		CharFreInString();
		
		String st="aajjffggggg";
		char[] ch=st.toCharArray();
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		
		for(Character c:ch) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
		
		
		
		
		
	}
	
	public static void CharFreInString() {
		String st="aabaddcccc";
		char[] ch=st.toCharArray();
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		for(char c:ch) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		for(Map.Entry<Character, Integer> entry:map.entrySet()) {
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
	}
	
	
	
	
	
	
	
	
	
}
