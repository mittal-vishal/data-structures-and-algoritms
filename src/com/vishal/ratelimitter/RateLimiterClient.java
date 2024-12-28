package com.vishal.ratelimitter;

public class RateLimiterClient {

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter("tokenBucket");
        // refresh rate is in seconds
        rateLimiter.createRateLimiter(2, 10000, 101);
        System.out.println(rateLimiter.isApplicable(101));
        System.out.println(rateLimiter.isApplicable(101));
        Thread.sleep(15000);
        System.out.println(rateLimiter.isApplicable(101));
    }

}
