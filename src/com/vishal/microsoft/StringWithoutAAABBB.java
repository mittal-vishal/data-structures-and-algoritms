package com.vishal.microsoft;

import java.util.PriorityQueue;

public class StringWithoutAAABBB {

    static class Pair{
        char ch;
        int occurance;
        public Pair(char ch, int occurance){
            this.ch = ch;
            this.occurance = occurance;
        }
    }
    public String strWithout3a3b(int a, int b) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((i, j) -> j.occurance - i.occurance);
        if(a > 0)
            pq.offer(new Pair('a', a));
        if(b > 0)
            pq.offer(new Pair('b', b));
        StringBuilder sb = new StringBuilder();
        Pair prev = null;
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            sb.append(current.ch);
            current.occurance -= 1;
            if(pq.size() > 0 && current.occurance > pq.peek().occurance ||
                pq.isEmpty() && current.occurance > prev.occurance){
                sb.append(current.ch);
                current.occurance -= 1;
            }
            if(prev != null && prev.occurance > 0){
                pq.offer(prev);
            }
            prev = current;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        StringWithoutAAABBB stringWithoutAAABBB = new StringWithoutAAABBB();
        String str = stringWithoutAAABBB.strWithout3a3b(a, b);
        System.out.println(str);
    }

}
