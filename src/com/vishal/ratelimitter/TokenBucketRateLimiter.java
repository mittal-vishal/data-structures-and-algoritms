package com.vishal.ratelimitter;

public class TokenBucketRateLimiter implements RateLimiter {

    private int bucketSize;
    private int refillRatePerTimeUnit;
    private long timeUnit;

    @Override
    public void createRateLimiter(int bucketSize, int refreshRate, long timeUnit) {

    }

    @Override
    public boolean isAllowed(Integer userId) {
        return false;
    }
}
