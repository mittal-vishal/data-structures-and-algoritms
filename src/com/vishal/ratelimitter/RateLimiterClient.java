package com.vishal.ratelimitter;

public class RateLimiterClient {

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter("slidingWindow");
        // refresh rate is in mills
        rateLimiter.createRateLimiter(2, 10000, 101);
        System.out.println(rateLimiter.isAllowed(101));
        System.out.println(rateLimiter.isAllowed(101));
        Thread.sleep(15000);
        System.out.println(rateLimiter.isAllowed(101));
    }

}
