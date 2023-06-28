package com.vishal.ratelimitter;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindowRateLimiter extends RateLimiter{

    private Queue<Integer> queue;
    private int timeUnit;
    private int userId;
    private int bucketCapacity;
    private HashMap<Integer, SlidingWindowRateLimiter> buckets;

    @Override
    public void createRateLimiter(int bucketCapacity, int timeUnit, int userId) {
        this.queue = new ConcurrentLinkedQueue<>();
        this.timeUnit = timeUnit;
        this.userId = userId;
        this.bucketCapacity = bucketCapacity;
        buckets.put(userId, new SlidingWindowRateLimiter());
    }

    @Override
    public boolean isApplicable(String userId) {
        SlidingWindowRateLimiter slidingWindowRateLimiter = buckets.get(userId);
        long currentTime = System.currentTimeMillis();
        updateQueue(slidingWindowRateLimiter.queue, currentTime);
        if(slidingWindowRateLimiter.queue.size() <= bucketCapacity){
            slidingWindowRateLimiter.queue.offer((int) currentTime);
            return true;
        }
        return false;
    }

    private void updateQueue(Queue<Integer> queue, long currentTime) {
        long timeDiff = (currentTime - queue.peek())/1000;
        while(!queue.isEmpty() && timeDiff > timeUnit){
            queue.poll();
            timeDiff = (currentTime - queue.peek())/1000;
        }
    }
}
