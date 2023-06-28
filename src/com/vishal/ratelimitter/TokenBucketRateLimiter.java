package com.vishal.ratelimitter;

public class TokenBucketRateLimiter extends RateLimiter {

    @Override
    public void createRateLimiter(int bucketSize, int timeUnit, int userId) {

    }

    @Override
    public boolean isApplicable(String userId) {
        return false;
    }
}
