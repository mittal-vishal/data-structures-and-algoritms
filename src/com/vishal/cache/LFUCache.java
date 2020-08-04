package com.vishal.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class LFUCache {
	Map<Integer, Node> map;
	int capacity;
	int num;
	TreeMap<Integer, DoubleList> freqMap;

	class DoubleList {
		Node head;
		Node tail;

		public DoubleList() {
			head = new Node(-1, -1);
			tail = new Node(-1, -1);
			head.next = tail;
			tail.prev = head;
		}
	}

	class Node {
		int frequency;
		int val;
		int key;
		Node prev;
		Node next;

		public Node(int k, int v) {
			this.key = k;
			this.frequency = 0;
			this.val = v;
		}
	}

	public LFUCache(int capacity) {
		map = new HashMap<>();
		freqMap = new TreeMap<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (capacity <= 0)
			return -1;
		return getMap(key);
	}

	public void put(int key, int value) {
		if (capacity <= 0)
			return;
		putMap(key, value);
	}

	public void updateFrequency(Node node) {
		int frequency = node.frequency;
		if (!freqMap.containsKey(node.frequency)) {
			freqMap.put(node.frequency, new DoubleList());
		}
		DoubleList dl = freqMap.get(node.frequency);
		if (frequency != 1) {
			// remove from old list
			DoubleList olddl = freqMap.get(node.frequency - 1);
			Node prev = node.prev;
			Node next = node.next;
			prev.next = next;
			next.prev = prev;
			if (olddl.head.next == olddl.tail) {
				freqMap.remove(node.frequency - 1);
			}

		}
		Node tail = dl.head.next;
		dl.head.next = node;
		node.prev = dl.head;
		tail.prev = node;
		node.next = tail;
	}

	public int getMap(int key) {
		if (!map.containsKey(key)) {
			return -1;
		} else {
			map.get(key).frequency++;
			Node node = map.get(key);
			updateFrequency(node);
			return node.val;
		}

	}

	public void putMap(int key, int value) {

		if (num < capacity) {
			if (!map.containsKey(key)) {
				num++;
				map.put(key, new Node(key, value));
			}

			Node node = map.get(key);
			node.val = value;
			node.frequency++;
			updateFrequency(node);
		} else if (num == capacity) {
			if (!map.containsKey(key)) {
				// delete the oldest one from f
				DoubleList dl = freqMap.get(freqMap.firstKey());
				Node node = dl.tail.prev;
				Node prev = dl.tail.prev.prev;
				prev.next = dl.tail;
				dl.tail.prev = prev;
				// if nothing left in this dl
				if (dl.head.next == dl.tail) {
					freqMap.remove(freqMap.firstKey());
				}
				map.remove(node.key);
				map.put(key, new Node(key, value));
				map.get(key).frequency++;
				updateFrequency(map.get(key));
			} else {
				map.get(key).val = value;
				map.get(key).frequency++;
				updateFrequency(map.get(key));
			}
		}
	}
}