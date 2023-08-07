package com.vishal.ratelimitter;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindowRateLimiter implements RateLimiter{

    private Queue<Long> queue;
    private int timeUnit;
    private int userId;
    private int bucketCapacity;
    private HashMap<Integer, SlidingWindowRateLimiter> buckets;

    public SlidingWindowRateLimiter(Queue queue, int bucketCapacity){
        this.queue = queue;
        this.bucketCapacity = bucketCapacity;
    }

    public SlidingWindowRateLimiter(){
    }

    @Override
    public void createRateLimiter(int bucketCapacity, int timeUnit, int userId) {
        this.queue = new ConcurrentLinkedQueue<>();
        this.timeUnit = timeUnit;
        this.userId = userId;
        this.bucketCapacity = bucketCapacity;
        buckets = new HashMap<>();
        buckets.put(userId, new SlidingWindowRateLimiter(this.queue, bucketCapacity));
    }

    @Override
    public boolean isApplicable(Integer userId) {
        SlidingWindowRateLimiter slidingWindowRateLimiter = buckets.get(userId);
        long currentTime = System.currentTimeMillis();
        updateQueue(slidingWindowRateLimiter.queue, currentTime);
        if(slidingWindowRateLimiter.queue.size() < bucketCapacity) {
            slidingWindowRateLimiter.queue.offer(currentTime);
            return true;
        }else{
            return false;
        }
    }

    private void updateQueue(Queue<Long> queue, long currentTime) {
        if(queue.isEmpty()){
            return;
        }
        long timeDiff = (currentTime - queue.peek())/1000;
        while(!queue.isEmpty() && timeDiff > timeUnit){
            queue.poll();
            timeDiff = !queue.isEmpty()? (currentTime - queue.peek())/1000: 0;
        }
    }
}
