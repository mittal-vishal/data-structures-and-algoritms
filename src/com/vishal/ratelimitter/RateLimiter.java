package com.vishal.ratelimitter;

public interface RateLimiter {

    void createRateLimiter(int bucketSize, int refreshRate, int userId);
    boolean isApplicable(Integer userId);

}
