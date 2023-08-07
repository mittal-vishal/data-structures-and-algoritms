package com.vishal.ratelimitter;

public class RateLimiterClient {

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter("slidingWindow");
        // time unit is in seconds
        rateLimiter.createRateLimiter(2, 10, 101);
        System.out.println(rateLimiter.isApplicable(101));
        System.out.println(rateLimiter.isApplicable(101));
        Thread.sleep(15000);
        System.out.println(rateLimiter.isApplicable(101));
    }

}
