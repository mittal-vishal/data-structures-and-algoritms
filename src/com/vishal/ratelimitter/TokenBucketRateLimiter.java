package com.vishal.ratelimitter;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucketRateLimiter implements RateLimiter {

    private HashMap<Integer, TokenBucketRateLimiter> buckets;
    private int capacity;
    private int refreshRate;
    private AtomicInteger currCapacity;
    private AtomicLong lastUpdatedTime;
    private int userId;

    @Override
    public void createRateLimiter(int bucketSize, int timeUnit, int userId) {
        this.capacity = bucketSize;
        this.refreshRate = timeUnit;
        this.userId = userId;
    }

    @Override
    public boolean isApplicable(Integer userId) {
        TokenBucketRateLimiter tokenBucketRateLimiter = buckets.get(userId);
        refillBucket(tokenBucketRateLimiter);
        if(tokenBucketRateLimiter.currCapacity.get() > 0){
            tokenBucketRateLimiter.currCapacity.getAndSet(tokenBucketRateLimiter.currCapacity.get()-1);
            return true;
        }
        return false;
    }

    private void refillBucket(TokenBucketRateLimiter tokenBucketRateLimiter) {
        long currTime = System.currentTimeMillis();
        long lastUpdatedTime = tokenBucketRateLimiter.lastUpdatedTime.get();
        int additionalToken = (int) (((currTime-lastUpdatedTime)/1000) * refreshRate);
        int currCapacity = Math.min(additionalToken + tokenBucketRateLimiter.currCapacity.get(), capacity);
        tokenBucketRateLimiter.currCapacity.getAndSet(currCapacity);
        tokenBucketRateLimiter.lastUpdatedTime.getAndSet(currTime);
    }
}
