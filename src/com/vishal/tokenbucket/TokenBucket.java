package com.vishal.tokenbucket;

public class TokenBucket {

    private int capacity;
    private int refillRate;
    private long lastRefillTs;
    private int currToken;

    public TokenBucket(int capacity, int refillRate){
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.currToken = capacity;
        this.lastRefillTs = System.nanoTime();
    }

    public synchronized boolean tryConsume(){
        refill();
        if(currToken > 0){
            currToken--;
            return true;
        }else{
            return false;
        }
    }

    private void refill() {
        long currTs = System.nanoTime();
        double secondElapsed = (currTs - lastRefillTs) / 1_000_000_000;
        double additionalToken = refillRate * secondElapsed;
        if(additionalToken >= 1.0){
            int tokenToAdd = (int) additionalToken;
            currToken = Math.min(capacity, currToken + tokenToAdd);
            long nanosToAdd = (long) ((tokenToAdd / (double) refillRate) * 1_000_000_000L);
            lastRefillTs += nanosToAdd;
        }
    }

}
