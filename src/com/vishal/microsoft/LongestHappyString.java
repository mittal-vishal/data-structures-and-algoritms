package com.vishal.microsoft;

import java.util.PriorityQueue;

public class LongestHappyString {

    static class Pair{
        char element;
        int occurance;
        public Pair(char element, int occurance){
            this.element = element;
            this.occurance = occurance;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        int[] charOccurances = {a, b, c};
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((i, j) -> j.occurance-i.occurance);
        if(a > 0){
            maxHeap.offer(new Pair('a', a));
        }
        if(b > 0){
            maxHeap.offer(new Pair('b', b));
        }
        if(c > 0){
            maxHeap.offer(new Pair('c', c));
        }
        int totalOccurance = a + (b + c);
        StringBuilder sb = new StringBuilder();
        Pair prev = null;
        while(!maxHeap.isEmpty()){
            Pair maxElement = maxHeap.poll();
            //use double occurance of max element
            sb.append(maxElement.element);
            charOccurances[maxElement.element-'a']--;
            totalOccurance--;
            maxElement.occurance--;
            int remainOccur = totalOccurance - maxElement.occurance;
            if(maxElement.occurance > remainOccur){
                if(charOccurances[maxElement.element-'a'] > 0){
                    sb.append(maxElement.element);
                    charOccurances[maxElement.element-'a']--;
                    totalOccurance--;
                    maxElement.occurance--;
                }
            }
            if(prev != null && prev.occurance > 0){
                maxHeap.offer(prev);
            }
            prev = maxElement;
        }
        return sb.toString();
    }

}
