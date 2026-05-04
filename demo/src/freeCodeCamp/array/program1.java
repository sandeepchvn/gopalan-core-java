package freeCodeCamp.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class program1 {

	public static void main(String[] args) {
//		int[] arr= {3,2,4,7,5,7};
//		System.out.println(containsDuplicate(arr));
		System.out.println(isAnagram("xyz", "yzx"));
	}
	
	//return true if elements are repeated
	public static boolean containsDuplicate(int[] num) {
		Set<Integer> set=new HashSet<Integer>();
		for(int i=1;i<num.length;i++) {
			if( ! set.add(num[i])) {
				return  true;
			}
			set.add(num[i]);
		}
		return false;
	}
	//219
	/*Given an integer array nums and an integer k,
	 *  return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
	 */
	public static boolean containsNearByDuplicates(int[] num,int k) {
		Set<Integer> set=new HashSet<Integer>();
		for(int i=1;i<num.length;i++) {
			if(set.contains(num[i])) {
				return  true;
			}
			set.add(num[i]);
			if(set.size()>k) {
				set.remove(num[i-k]);
			}
		}
		return false;
	}
	//242
	//Anagram
	public static boolean isAnagram(String s,String t) {
		if(s.length() != t.length()) {
			return false;
		}
		s=s.toLowerCase();
		t=t.toLowerCase();
		int[] charCount=new int[26];
		for(int i=0;i<s.length();i++) {
			charCount[s.charAt(i)-'a']++;
			charCount[t.charAt(i)-'a']--;
		}
		
		for(int c:charCount) {
			if(c!=0)return false;
		}
		return true;
	}
	//49
	/*Given an array of strings strs, group the anagrams together.
	 *  You can return the answer in any order.
	 *  Input: strs = ["eat","tea","tan","ate","nat","bat"]
		Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
	 * */
	public static List<List<String>> groupAnagram(String[] str) {
		return null;
	}
	//238
	public int[] productExceptSelf(int[] num) {
		int[] result=new int[num.length];
		Arrays.fill(result, 1);
		
		int pre=1,post=1;
		
		for(int i=0;i<num.length;i++) {
			result[i]=pre;
			pre=num[i]*pre;
		}
		for(int i=num.length-1;i>=0;i--) {
			result[i]=result[i]*post;
			post=post*num[i];
		}
		return result;
	}
	//347
	public int[] topKFrequent(int[] nums, int k) {
		if(k==nums.length) {
			return nums;
		}
		Map<Integer, Integer> count=new HashMap<Integer, Integer>();
		for(int n:nums) {
			count.put(n, count.getOrDefault(n, 0)+1);
		}
		
		Queue<Integer> heap=new PriorityQueue(
				(a,b)->count.get(a)-count.get(b));
		
		for(int n:count.keySet()) {
			heap.add(n);
			if(heap.size()>k) {
				heap.poll();
			}
		}
		int[] ans=new int[k];
		for(int i=0;i<k;i++) {
			ans[i]=heap.poll();
		}
		return ans;
	}
	//13 Roman to Integer
	//128
}







