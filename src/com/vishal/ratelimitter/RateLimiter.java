package com.vishal.ratelimitter;

public abstract class RateLimiter {

    public abstract void createRateLimiter(int bucketSize, int timeUnit, int userId);
    public abstract boolean isApplicable(Integer userId);

}
