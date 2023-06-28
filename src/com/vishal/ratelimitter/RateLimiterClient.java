package com.vishal.ratelimitter;

public class RateLimiterClient {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter("slidingWindow");
        // time unit is in seconds
        rateLimiter.createRateLimiter(5, 1, 101);
        rateLimiter.isApplicable(101);
        rateLimiter.isApplicable(101);
        rateLimiter.isApplicable(101);
    }

}
