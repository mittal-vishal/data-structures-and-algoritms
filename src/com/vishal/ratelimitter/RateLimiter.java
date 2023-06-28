package com.vishal.ratelimitter;

public interface RateLimiter {

    void createRateLimiter(int bucketSize, int timeUnit, int userId);
    boolean isApplicable(Integer userId);

}
