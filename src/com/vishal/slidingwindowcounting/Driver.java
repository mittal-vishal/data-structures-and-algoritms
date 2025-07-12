package com.vishal.slidingwindowcounting;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowCounting limiter = new SlidingWindowCounting(3, 2000); // 3 requests per 2 seconds

        System.out.println("---- Starting test ----");

        // Send 3 requests immediately (should all pass)
        for (int i = 1; i <= 3; i++) {
            boolean allowed = limiter.tryConsume();
            System.out.printf("Request %d (0ms delay): Allowed? %s%n", i, allowed);
        }

        // 4th request immediately (should be blocked)
        boolean fourthAllowed = limiter.tryConsume();
        System.out.printf("Request 4 (0ms delay): Allowed? %s%n", fourthAllowed);

        // Wait 2.1 seconds (beyond window)
        Thread.sleep(2100);

        // New request after window slide (should be allowed again)
        boolean fifthAllowed = limiter.tryConsume();
        System.out.printf("Request 5 (after 2100ms): Allowed? %s%n", fifthAllowed);

        // Send 2 more quickly (should be allowed — total is 3 in new window)
        for (int i = 6; i <= 7; i++) {
            boolean allowed = limiter.tryConsume();
            System.out.printf("Request %d: Allowed? %s%n", i, allowed);
        }

        // Next request (should be blocked again)
        boolean eighthAllowed = limiter.tryConsume();
        System.out.printf("Request 8: Allowed? %s%n", eighthAllowed);

        System.out.println("---- Test complete ----");
    }

}
