package com.vishal.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache<T> implements Cache<T>{
	//Key and value map
	private Map<T,T> cache;
	//key and its count
	private Map<T,Integer> keyCounts;
	//frequence count and list of keys
	private Map<Integer, LinkedHashSet<T>> freqMap;
	private int capacity;
	private int minFreq;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<>();
		this.keyCounts = new HashMap<>();
		this.freqMap = new HashMap<>();
		freqMap.put(1, new LinkedHashSet<>());
		minFreq = 0;
	}

	@Override
	public T get(T key) {
		if(cache.containsKey(key)){
			int currCount = keyCounts.get(key);
			keyCounts.put(key, currCount+1);
			freqMap.get(currCount).remove(key);
			if(minFreq == currCount && freqMap.get(currCount).size() == 0){
				minFreq++;
			}
			freqMap.putIfAbsent(currCount+1, new LinkedHashSet<>());
			freqMap.get(currCount+1).add(key);
			return cache.get(key);
		}else{
			return null;
		}
	}

	@Override
	public void put(T key, T value) {
		if(capacity <= 0){
			return;
		}
		if(cache.containsKey(key)){
			cache.put(key,value);
			get(key);
			return;
		}else{
			if(cache.size() >= capacity){
				T evict = freqMap.get(minFreq).iterator().next();
				freqMap.get(minFreq).remove(evict);
				keyCounts.remove(evict);
				cache.remove(evict);
			}
			cache.put(key,value);
			keyCounts.put(key, 1);
			minFreq = 1;
			freqMap.get(minFreq).add(key);
		}
	}
}