package com.vishal.cache;

public class CacheNode {
	
	public int data;
	public String key;
	public CacheNode prev;
	public CacheNode next;
	
	public CacheNode(int data, String key) {
		super();
		this.data = data;
		this.key = key;
	}
}
