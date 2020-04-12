package com.vishal.hashing;

public class CacheNode {
	
	private int data;
	private String key;
	private CacheNode prev;
	private CacheNode next;
	
	public CacheNode(int data, String key) {
		super();
		this.data = data;
		this.key = key;
	}

	public CacheNode getPrev() {
		return prev;
	}

	public void setPrev(CacheNode prev) {
		this.prev = prev;
	}

	public CacheNode getNext() {
		return next;
	}

	public void setNext(CacheNode next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
