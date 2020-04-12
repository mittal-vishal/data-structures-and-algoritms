package com.vishal.hashing;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private Map<String, CacheNode> map;
	private CacheNode head;
	private static CacheNode tail;
	private CacheNode curr;
	private int capacity;
	private int size;

	public LRUCache(int capacity, Map<String, CacheNode> map) {
		this.capacity = capacity;
		this.map = new HashMap<>(capacity);
	}

	private void put(String key, int data) {
		CacheNode temp = new CacheNode(data, key);
		if (!map.containsKey(key)) {
			insertNewKey(temp);
		} else {
			overWriteKey(temp);
		}
		map.put(key, new CacheNode(data, key));
	}

	private void overWriteKey(CacheNode temp) {
		CacheNode currNode = head;
		while (currNode.getNext() != null) {
			if (currNode.getKey() == temp.getKey()) {
				break;
			}
			currNode = currNode.getNext();
		}
		if (currNode != head && currNode != tail) {
			currNode.getPrev().setNext(currNode.getNext());
			currNode.getNext().setPrev(currNode.getPrev());
		} else if (currNode != head && currNode == tail) {
			currNode.getPrev().setNext(currNode.getNext());
			curr = currNode.getPrev();
		} else if (currNode == head && currNode == tail) {
			head = temp;
		} else {
			head = head.getNext();
			head.setPrev(null);
		}
		curr.setNext(temp);
		temp.setPrev(curr);
		curr = curr.getNext();
		tail = curr;
	}

	private void insertNewKey(CacheNode temp) {
		if (size == 0) {
			head = temp;
			tail = temp;
			curr = temp;
			size = 1;
		} else if (size < capacity) {
			curr.setNext(temp);
			temp.setPrev(curr);
			curr = curr.getNext();
			tail = curr;
			size++;
		} else {
			if (map.containsKey(head.getKey())) {
				map.remove(head.getKey());
			}
			head = head.getNext();
			head.setPrev(null);
			curr.setNext(temp);
			temp.setPrev(curr);
			curr = curr.getNext();
			tail = curr;
		}
	}

	private CacheNode get(String key) {
		CacheNode returnVal = null;
		if (map.containsKey(key)) {
			returnVal = map.get(key);
			CacheNode currNode = head;
			while (currNode.getNext() != null) {
				if (currNode.getKey() == key) {
					break;
				}
				currNode = currNode.getNext();
			}
			if (currNode != head && currNode != tail) {
				currNode.getPrev().setNext(currNode.getNext());
				currNode.getNext().setPrev(currNode.getPrev());
				tail.setNext(currNode);
				currNode.setPrev(tail);
				currNode.setNext(null);
				tail = currNode;
				curr = currNode;
			} else if (currNode == head && currNode != tail) {
				head = head.getNext();
				head.setPrev(null);
				tail.setNext(currNode);
				currNode.setPrev(tail);
				currNode.setNext(null);
				tail = currNode;
				curr = currNode;
			}
		}
		return returnVal;
	}

	public static void main(String[] args) {
		Map<String, CacheNode> map = null;
		int capacity = 4;
		LRUCache cache = new LRUCache(capacity, map);
		System.out.println(cache.get("c1"));
		cache.put("c1", 1);
		cache.put("c2", 2);
		cache.put("c3", 3);
		cache.put("c4", 4);
		System.out.println("Get data :: " + cache.get("c2").getData());
		cache.printCache();
		System.out.println("Get data :: " + cache.get("c1").getData());
		cache.printCache();
		cache.put("c5", 5);
		cache.printCache();
		cache.put("c5", 7);
		cache.printCache();
	}

	private void printCache() {
		CacheNode currNode = head;
		while (currNode != null) {
			System.out.print(currNode.getKey() + "|" + currNode.getData() + " ");
			currNode = currNode.getNext();
		}
		System.out.println();
	}

}
