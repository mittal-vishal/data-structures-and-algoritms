package com.vishal.queue;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    private Queue<Integer> hits;

    public HitCounter() {
        hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hits.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while(!hits.isEmpty() && timestamp - 300 > 0 && hits.peek() <= timestamp - 300){
            hits.poll();
        }
        return hits.size();
    }

}
