package com.vishal.goldmansachs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class UniqueCharIndex {

	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));
	}
	
	public static int firstUniqChar(String s) {
		Map<Character, Entry<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), new SimpleEntry<Integer, Integer>(i, 1));
            }else{
                map.put(s.charAt(i), new SimpleEntry<Integer, Integer>(i, map.get(s.charAt(i)).getValue() + 1 ));
            }
        }
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for(Entry<Character, Entry<Integer, Integer>> entry : map.entrySet()){
            if(entry.getValue().getValue() == 1 && entry.getValue().getKey() < min){
                min = entry.getValue().getKey();
                minIndex = entry.getValue().getKey();
            }
        }
        return minIndex;
    }

}
