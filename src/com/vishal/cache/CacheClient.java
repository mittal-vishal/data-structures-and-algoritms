package com.vishal.cache;

public class CacheClient {

    private static Cache<Integer> cache;

    public static void main(String[] args) {
        cache = CacheFactory.getCacheInstance(new CacheEvictionPolicy("lru"), 10);
    }

}
