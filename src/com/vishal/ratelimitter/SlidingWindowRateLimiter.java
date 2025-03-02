package com.vishal.ratelimitter;

public class SlidingWindowRateLimiter implements RateLimiter{

    public SlidingWindowRateLimiter(){
    }

    @Override
    public void createRateLimiter(int bucketCapacity, int timeUnit, long userId) {
    }

    @Override
    public boolean isAllowed(Integer userId) {
        return false;
    }
}
