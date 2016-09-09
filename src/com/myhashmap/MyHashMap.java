package com.myhashmap;

import java.util.Arrays;

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
		if (cap <= 0) {
			throw new IllegalArgumentException("cap can not be <= 0");
		}
		this.array =(Entry<K, V>[]) (new Entry[cap]);
		this.size = cap;
		this.loadFactor = loadFactor;
	}
	
	//non-negative
	private int hash(K key) {
		//1.null key
		if (key == null) {
			return 0;
		}
		//2 hashCode()
		//int code = key.hashCode();
		//return code >= 0? code : -code;
		//int range = [-2^31, 2^31 - 1]
		//-Integer.MIN_VALUE = Integer.MIN_VALUE; ->overflow
		return key.hashCode() & 0x7FFFFFFF;
		//01111111 11111111 11111111 11111111
		//Reason: java's % return remainder rather than modulus. The remainder can be negative
	}
	
	private int getIndex(K key) {
		return hash(key) % array.length;	
	}
	
	private boolean equalsValue(V v1, V v2) {
		return v1 == v2 || v1 != null && v1.equals(v2);
	}
	
	private boolean equalsKey(K k1, K k2) {
		return k1 == k2 || k1 != null && k1.equals(k2);
	}
	
	private boolean needRehashing() {
		float ratio = (size + 0.0f) / array.length;
		return ratio >= loadFactor;
	}
	
	private boolean rehashing() {
		return true;
	}
	
	public V get(K key) {
		int index = getIndex(key);
		Entry<K, V> node = array[index];
		while (node != null) {
			if (equalsKey(node.getKey(), key)) {
				return node.getValue();
			}
			node = node.next;
		}
		return null;
	}
	
	public V put(K key, V value) {
		int index = getIndex(key);
		Entry<K, V> head = array[index];
		Entry<K, V> node = head;
		while (node != null) {
			if (equalsKey(node.getKey(), key)) {
				V result = node.getValue();
				node.setValue(value);
				return result;
			}
			node = node.next;
		}
		
		Entry<K, V> newEntry = new Entry(key, value);
		newEntry.next = head;
		array[index] = newEntry;
		size++;
		if (needRehashing()) {
			//rehashing();
		}
		return null;
	}
	
	public V remove(K key) {
		int index = getIndex(key);
		Entry<K, V> head = array[index];
		if (equalsKey(head.getKey(), key)) {
			V result = head.getValue();
			array[index] = head.next;
			size--;
			return result;			
		}

		Entry<K, V> node = head;
		while (node.next != null) {
			if (equalsKey(node.next.getKey(), key)) {
				V result = node.next.getValue();
				node.next = node.next.next;
				size--;
				return result;
			}
			node = node.next;
		}
		return null;
	}
	
	public boolean containsKey(K key) {
		int index = getIndex(key);
		Entry<K, V> node = array[index];
		while (node != null) {
			if (equalsKey(node.getKey(), key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	public boolean containsValue(V value) {
		if (isEmpty()) {
			return false;
		}
		
		for (Entry<K, V> node : array) {
			while (node != null) {
				if (equalsValue(node.getValue(), value)) {
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}
	
	public void clear() {
		Arrays.fill(this.array, null);
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
