package com.vishal.heap;

import java.util.*;
import java.util.Map.Entry;

public class RearrangeChars {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(reArrange(str));
    }

    public String reorganizeString(String s) {
        if(s == null || s.length() < 3){
            return s;
        }
        Map<Character, Integer> charOccurances = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            charOccurances.put(currChar, charOccurances.getOrDefault(currChar, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry<Character, Integer> entry: charOccurances.entrySet()){
            pq.offer(entry);
        }
        StringBuilder result = new StringBuilder();
        if(pq.size() == 1){
            return "";
        }
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> polledA = pq.poll();
            //base case
            if(pq.isEmpty() && polledA.getValue() > 1){
                return "";
            }else if(pq.isEmpty() && polledA.getValue() == 1){
                result.append(polledA.getKey());
                return result.toString();
            }

            Map.Entry<Character, Integer> polledB = pq.poll();
            result.append(polledA.getKey());
            result.append(polledB.getKey());
            if(polledA.getValue() > 1){
                pq.offer(new AbstractMap.SimpleEntry<>(polledA.getKey(), polledA.getValue() - 1));
            }
            if(polledB.getValue() > 1){
                pq.offer(new AbstractMap.SimpleEntry<Character,Integer>(polledB.getKey(), polledB.getValue() - 1));
            }
        }
        return result.toString();
    }

    public static boolean reArrange(String str) {
        boolean isRearrange = true;
        PriorityQueue<HeapStruc> pq = new PriorityQueue<>((o1, o2) -> o2.occurance - o1.occurance);
        Map<Character, Integer> map = getOccurances(str);
        Set<Entry<Character, Integer>> entrySet = map.entrySet();
        for (Entry<Character, Integer> entry : entrySet) {
            pq.add(new HeapStruc(entry.getKey(), entry.getValue()));
        }
        String res = "";
        HeapStruc obj1;
        HeapStruc obj2 = null;
        while (!pq.isEmpty()) {
            obj1 = pq.poll();
            res = res.concat(String.valueOf(obj1.getCharacter()));
            if (!pq.isEmpty()) {
                obj2 = pq.poll();
                res = res + obj2.getCharacter();
            }
            if (obj1.getOccurance() > 1) {
                pq.add(new HeapStruc(obj1.getCharacter(), obj1.getOccurance() - 1));
            }
            if (obj2 != null && obj2.getOccurance() > 1) {
                pq.add(new HeapStruc(obj2.getCharacter(), obj2.getOccurance() - 1));
            }
        }
        for (int i = 0; i < res.length() - 1; i++) {
            if (res.charAt(i) == res.charAt(i + 1)) {
                isRearrange = false;
                break;
            }
        }
        return isRearrange;
    }

    private static Map<Character, Integer> getOccurances(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        return map;
    }

}
