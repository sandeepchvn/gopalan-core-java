package techM_practice;

import java.util.LinkedHashMap;

public class LRUCache<K,V> extends LinkedHashMap<K, V> {

	private int capacity;
	public LRUCache(int capacity) {
		super(capacity,0.75f,true);
		this.capacity=capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size()>capacity;
	}
	
	public static void main(String[] args) {
		LRUCache<Integer, String> cache=new LRUCache<Integer, String>(3);
		cache.put(1, "raju");
		cache.put(2, "xyz");
		cache.put(3, "abc");
		
		System.out.println(cache);
		cache.get(1);
		cache.put(4, "kjj");
		
		System.out.println(cache);
	}
	
	
	
	
	
	
	
}
