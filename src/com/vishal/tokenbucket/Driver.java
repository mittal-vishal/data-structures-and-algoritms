package com.vishal.tokenbucket;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
        TokenBucket bucket = new TokenBucket(5, 2); // 5 tokens, refill 2 per second

        System.out.println("=== Initial burst (should allow 5 requests) ===");
        for (int i = 0; i < 7; i++) {
            System.out.println("Request " + i + " => " + (bucket.tryConsume() ? "ALLOWED" : "BLOCKED"));
        }

        System.out.println("\n=== Wait 1 second (should refill ~2 tokens) ===");
        Thread.sleep(1000);

        for (int i = 7; i < 11; i++) {
            System.out.println("Request " + i + " => " + (bucket.tryConsume() ? "ALLOWED" : "BLOCKED"));
        }

        System.out.println("\n=== Wait 3 seconds (should refill full capacity) ===");
        Thread.sleep(3000);

        for (int i = 11; i < 17; i++) {
            System.out.println("Request " + i + " => " + (bucket.tryConsume() ? "ALLOWED" : "BLOCKED"));
        }
    }

}
