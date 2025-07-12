package com.vishal.slidingwindowcounting;

import com.vishal.tokenbucket.TokenBucket;

import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {

    private ConcurrentHashMap<String, SlidingWindowCounting> userBuckets;
    private int maxRequest;
    private int windowSizeInMs;

    public RateLimiter(int maxRequest, int windowSizeInMs){
        this.maxRequest = maxRequest;
        this.windowSizeInMs = windowSizeInMs;
        userBuckets = new ConcurrentHashMap<>();
    }

    public boolean tryConsume(String userId){
        SlidingWindowCounting  slidingWindowCounting = userBuckets.computeIfAbsent(userId, k -> new SlidingWindowCounting(maxRequest, windowSizeInMs));
        return slidingWindowCounting.tryConsume();
    }
}
