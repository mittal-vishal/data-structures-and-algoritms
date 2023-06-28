package com.vishal.cache;

public class CacheFactory<T> {

    private static Cache cache;

    public static Cache getCacheInstance(CacheEvictionPolicy evictionPolicy, int capacity){
        if(evictionPolicy.getEvictionType().equals("lru")){
            cache = new LRUCache(capacity);
        }else if(evictionPolicy.getEvictionType().equals("lru")){
            cache = new LFUCache(capacity);
        }
        return null;
    }
}
