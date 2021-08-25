package com.vishal.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

class FreqStack {

    class Element{
        int val;
        int freq;
        int pos;
        public Element(int val, int freq, int pos){
            this.val = val;
            this.freq = freq;
            this.pos = pos;
        }
    }

    HashMap<Integer, Integer> freqMap;
    PriorityQueue<Element> pq;
    int pos;

    public FreqStack() {
        pq = new PriorityQueue<>((a, b) -> {
            if(a.freq != b.freq){
                return b.freq-a.freq;
            }else{
                return b.pos - a.pos;
            }
        });
        freqMap = new HashMap<>();
        pos = 0;
    }

    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        pq.offer(new Element(val, freqMap.get(val), pos++));
    }

    public int pop() {
        Element polledElement = pq.poll();
        int val = polledElement.val;
        if(freqMap.containsKey(val) && freqMap.get(val) > 1){
            freqMap.put(val, freqMap.get(val) - 1);
        }else if(freqMap.containsKey(val)){
            freqMap.remove(val);
        }
        return val;
    }

    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        int pop1 = stack.pop();
        System.out.print(pop1);
        int pop2 = stack.pop();
        System.out.print(pop2);
        int pop3 = stack.pop();
        System.out.print(pop3);
        int pop4 = stack.pop();
        System.out.print(pop4);
    }
}

// 5-1-0
//7-1-1
//5-2-2
//7-2-3
//4-1-4
//5-3-5
