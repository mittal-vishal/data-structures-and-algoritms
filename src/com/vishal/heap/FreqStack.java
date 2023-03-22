package com.vishal.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FreqStack {

    class Element{
        int val;
        int freq;
        int order;
        public Element(int val, int freq, int order){
            this.val = val;
            this.freq = freq;
            this.order = order;
        }
    }

    private PriorityQueue<Element> pq;
    private int order;
    private Map<Integer, Integer> occurances;

    public FreqStack() {
        pq = new PriorityQueue<>((a,b) -> {
            if(a.freq != b.freq){
                return b.freq - a.freq;
            }else{
                return b.order - a.order;
            }
        });
        order = 0;
        occurances = new HashMap<>();
    }

    public void push(int val) {
        occurances.put(val, occurances.getOrDefault(val, 0) + 1);
        pq.offer(new Element(val, occurances.get(val), order++));
    }

    public int pop() {
        if(!pq.isEmpty()){
            Element polled = pq.poll();
            if(occurances.get(polled.val) > 1){
                occurances.put(polled.val, occurances.get(polled.val) - 1);
            }else{
                occurances.remove(polled.val);
            }
            return polled.val;
        }else{
            return -1;
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */