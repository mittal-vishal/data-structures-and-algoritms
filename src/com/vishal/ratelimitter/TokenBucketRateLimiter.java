package com.vishal.ratelimitter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucketRateLimiter implements AutoCloseable {

    private int capacity;
    private int refillRate;
    private long refillUnitInMillis;
    private ScheduledExecutorService scheduledExecutorService;
    private AtomicInteger tokens;

    public void TokenBucketRateLimiter(int bucketSize, int refreshRate, long timeUnit) {
        this.capacity = bucketSize;
        this.refillRate = refreshRate;
        this.refillUnitInMillis = timeUnit;
        this.tokens = new AtomicInteger(capacity);
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread thread = new Thread(r, "token-bucket");
            thread.setDaemon(true);
            return thread;
        });
        this.scheduledExecutorService.scheduleAtFixedRate(this::refill, refillUnitInMillis, refillUnitInMillis, TimeUnit.MILLISECONDS);
    }

    private void refill(){
        this.tokens.getAndUpdate(current -> Math.min(capacity, current + refillRate));
    }

    public boolean tryConsume(int tokenRequested) {
        if(tokenRequested <= 0 || tokenRequested > capacity){
            throw new IllegalArgumentException("tokensRequested must be > 0 and ≤ capacity");
        }
        while(true){
            int currTokens = tokens.get();
            if(tokenRequested > currTokens){
                return false;
            }
            if(this.tokens.compareAndSet(currTokens, currTokens - tokenRequested)){
                return true;
            }
        }
    }

    public int availableTokens() {
        return tokens.get();
    }

    @Override
    public void close() throws Exception {
        this.scheduledExecutorService.shutdownNow();
    }
}
