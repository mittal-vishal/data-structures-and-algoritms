package com.vishal.ratelimitter;

public class TokenBucketRateLimiter implements RateLimiter {
    private int refreshRate;
    private int capacity;
    private long lastRefilledTime;
    private long nextRefilledTime;
    private int userId;
    private int availableToken;

    @Override
    public void createRateLimiter(int bucketSize, int refreshRate, int userId) {
        this.capacity = bucketSize;
        this.refreshRate = refreshRate;
        this.userId = userId;
    }

    @Override
    public boolean isApplicable(Integer userId) {
        refillBucket();
        if(availableToken > 0){
            availableToken--;
            return true;
        }
        return false;
    }

    private void refillBucket() {
        long currentTime = System.currentTimeMillis();
        if(currentTime < nextRefilledTime){
            return;
        }
        lastRefilledTime = currentTime;
        nextRefilledTime = lastRefilledTime + refreshRate;
        availableToken = capacity;
    }
}
