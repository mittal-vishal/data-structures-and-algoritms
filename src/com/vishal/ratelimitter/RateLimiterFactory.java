package com.vishal.ratelimitter;

public class RateLimiterFactory {

    private static RateLimiter rateLimiter;

    public static RateLimiter getRateLimiter(String rateLimiterType){
        switch (rateLimiterType){
            case "slidingWindow":
                rateLimiter = new SlidingWindowRateLimiter();
                break;
            case "tokenBucket":
                rateLimiter = new TokenBucketRateLimiter();
                break;
            default:
                rateLimiter = null;
                break;
        }
        return rateLimiter;
    }

}
