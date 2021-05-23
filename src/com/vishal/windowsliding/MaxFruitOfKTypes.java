package com.vishal.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitOfKTypes {

    public static int findLength(char[] arr, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int start = 0, end = 0;
        int numOfFruits = Integer.MIN_VALUE;
        while(end < arr.length){
            //Expand the basket
            char rightFruit = arr[end++];
            freqMap.put(rightFruit, freqMap.getOrDefault(rightFruit, 0) + 1);
            //Shrink the basket
            while(start < end && freqMap.size() > k){
                char leftFruit = arr[start++];
                freqMap.put(leftFruit, freqMap.get(leftFruit) - 1);
                if(freqMap.get(leftFruit) == 0){
                    freqMap.remove(leftFruit);
                }
            }
            numOfFruits = Math.max(numOfFruits, end - start);
        }
        return numOfFruits;
    }

}
