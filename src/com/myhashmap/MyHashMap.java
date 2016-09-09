package com.myhashmap;

public class MyHashMap {
	static class Entry<K, V> {
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
	
	private Entry<K, V>[] array;
	private int size;
	private int loaffactor;
	
	private int hash(K key) {
		
		
	}
	
	private int getIndex(int hashNumber) {
		
		
	}
	
}
