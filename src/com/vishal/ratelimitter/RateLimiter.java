package com.vishal.ratelimitter;

public interface RateLimiter {

    void createRateLimiter(int bucketSize, int refreshRate, long timeUnit);
    boolean isAllowed(Integer userId);

}
