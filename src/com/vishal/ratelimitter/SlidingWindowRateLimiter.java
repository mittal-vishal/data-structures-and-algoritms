package com.vishal.ratelimitter;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowRateLimiter {

    private ConcurrentLinkedDeque<Long> requestsTs;
    private final int maxRequests;
    private final long windowSizeInMs;
    private AtomicInteger count;

    public SlidingWindowRateLimiter(int maxRequests, long windowSizeInMs){
        this.maxRequests = maxRequests;
        this.windowSizeInMs = windowSizeInMs;
        this.count = new AtomicInteger();
        requestsTs = new ConcurrentLinkedDeque<>();
    }

    public boolean tryConsume() {
        long currentTimeInMs = System.currentTimeMillis();
        cleanUpOlderRequests(currentTimeInMs);
        if(count.incrementAndGet() > maxRequests){
            count.decrementAndGet();
            return false;
        }
        //add current ts in queue
        requestsTs.offerLast(currentTimeInMs);
        return true;
    }

    private void cleanUpOlderRequests(long currentTimeInMs) {
        while(true){
            Long prevTime = requestsTs.peekFirst();
            if(prevTime == null || (currentTimeInMs - prevTime) <= windowSizeInMs){
                break;
            }
            if(requestsTs.pollFirst() != null){
                count.decrementAndGet();
            }
        }
    }
}
