package com.vishal.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	private Map<String, CacheNode> cacheMap;
	private int capacity;
	private CacheNode head;
	private CacheNode tail;
	private int size;
	
	public LRUCache(int capacity, Map<String, CacheNode> cacheMap) {
		this.capacity = capacity;
		this.cacheMap = cacheMap;
		this.size = 0;
	}
	
	private void put(String key, int value) {
		CacheNode cacheNode = new CacheNode(value, key);
		cacheMap.put(key, cacheNode);
		if(size < capacity && size == 0) {
			head = cacheNode;
			tail = head;
			size++;
		}else if(size < capacity && size > 0){
			tail.next = cacheNode;
			cacheNode.prev = tail;
			tail = tail.next;
			size++;
		}else {
			delete();
			tail.next = cacheNode;
			cacheNode.prev = tail;
			tail = tail.next;
		}
	}
	
	private int get(String key) {
		if(!cacheMap.containsKey(key)) {
			return -1;
		}else if(tail != head){
			CacheNode cacheNode = cacheMap.get(key);
			if(cacheNode == head) {
				head = head.next;
			}else{
				cacheNode.prev.next = cacheNode.next;
				cacheNode.next.prev = cacheNode.prev;
			}
			cacheNode.prev = tail;
			tail.next = cacheNode;
			cacheNode.next = null;
			tail = tail.next;
			return cacheMap.get(key).data;
		}else {
			return cacheMap.get(key).data;
		}
		
	}
	
	private void delete() {
		CacheNode temp = head;
		head = head.next;
		cacheMap.remove(temp.key);
		size--;
	}
	
	private void printCache() {
		CacheNode currNode = head;
		while (currNode != null) {
			System.out.print(currNode.key + "|" + currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int capacity = 5;
		Map<String, CacheNode> cacheMap = new HashMap<>();
		LRUCache cache = new LRUCache(capacity, cacheMap);
		System.out.println(cache.get("c1"));
		cache.put("c1", 10);
		cache.printCache();
		System.out.println(cache.get("c1"));
		cache.put("c2", 11);
		cache.put("c3", 12);
		cache.put("c4", 14);
		cache.put("c5", 15);
		cache.printCache();
		cache.get("c1");
		cache.put("c6", 23);
		cache.printCache();
	}

}
