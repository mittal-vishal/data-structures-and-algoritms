package com.vishal.heap;

import java.util.*;

public class ReArrangeString {

    public String rearrangeString(String s, int k) {
        if(k <= 1){
            return s;
        }
        HashMap<Character, Integer> charOccurMap = new HashMap<>();
        for(char ch: s.toCharArray()){
            charOccurMap.put(ch, charOccurMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue()-a.getValue());
        pq.addAll(charOccurMap.entrySet());

        StringBuilder sb = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> currEntry = pq.poll();
            currEntry.setValue(currEntry.getValue() - 1);
            sb.append(currEntry.getKey());
            queue.offer(currEntry);
            if(queue.size() == k){
                Map.Entry<Character, Integer> queueEntry = queue.poll();
                if(queueEntry.getValue() > 0){
                    pq.offer(queueEntry);
                }
            }
        }

        return sb.length() == s.length() ? sb.toString(): "";
    }

}
