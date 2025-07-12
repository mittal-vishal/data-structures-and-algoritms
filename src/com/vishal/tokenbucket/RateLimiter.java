package com.vishal.tokenbucket;

import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {

    private ConcurrentHashMap<String, TokenBucket> userBuckets;
    private int capacity;
    private int refillRate;

    public RateLimiter(int capacity, int refillRate){
        this.capacity = capacity;
        this.refillRate = refillRate;
        userBuckets = new ConcurrentHashMap<>();
    }

    public boolean tryConsume(String userId){
        TokenBucket  tokenBucket = userBuckets.computeIfAbsent(userId, k -> new TokenBucket(capacity, refillRate));
        return tokenBucket.tryConsume();
    }
}
