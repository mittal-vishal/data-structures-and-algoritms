package com.vishal.ratelimitter;

public class TokenBucketRateLimiter implements RateLimiter {

    @Override
    public void createRateLimiter(int bucketSize, int timeUnit, int userId) {

    }

    @Override
    public boolean isApplicable(Integer userId) {
        return false;
    }
}
