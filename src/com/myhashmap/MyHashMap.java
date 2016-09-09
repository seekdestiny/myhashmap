package com.myhashmap;

/**
 *
 * @author jifeiqian
 * A hashtable implementation of map and generic type is provided.
 * 
 * supported operations:
 * size()
 * isEmpty()
 * clear()
 * put(K key, V value)
 * get(K key)
 * containsKey(K key)
 * containsValue(V value)// check if the desired values is in the map. O(n)
 * remove(K key)
 */

public class MyHashMap<K, V> {
	// Node is a static class of MyHashMap, since it is:
	// very closely bonded to MyHashMap class.
	// we probably need to access this class outside from MyHashMap class.
	public static class Entry<K, V> {
		final K key;
		V value;
		Entry<K, V> next;
		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}	
	}
	
	//static final variable are global constants.
	public static final int DEFAULT_CAPACITY = 16;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	private Entry<K, V>[] array;
	private int size; //how many key-value pairs are actually stored in the HashMap.
	private float loadFactor; //determine when to rehash.
	
	public MyHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	public MyHashMap(int cap, float loadFactor) {
		
		
	}
	
	private int hash(K key) {
		
		
	}
	
	private int getIndex(int hashNumber) {
		
		
	}
	
	private boolean equalsValue(V v1, V v2) {
		
		
	}
	
	private boolean equalsKey(K k1, K k2) {
		
		
	}
	
	public V get(K key) {
		
	}
	
	public boolean put(K key, V value) {
		
		
	}
	
	public boolean remove(K key) {
		
		
	}
	
	public boolean containsKey(K key) {
		
		
	}
	
	public boolean containsValue(V value) {
		
		
		
	}
	
	public void clear() {
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
