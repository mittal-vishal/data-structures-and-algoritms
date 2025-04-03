package com.vishal.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitOfKTypes {

    public static int findLength(char[] arr, int k) {
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> occuranceMap = new HashMap<>();
        while(right < arr.length){
            //Expand the window, until cond satisfied
            if(occuranceMap.size() < 3){
                char currentFruit = arr[right++];
                occuranceMap.put(currentFruit, occuranceMap.getOrDefault(currentFruit, 0) + 1);
            }
            if(occuranceMap.size() < 3){
                max = Math.max(max, right - left);
            }
            //Shrink the window to optimize the answer, and until cond satisfies
            if(occuranceMap.size() > 2){
                char fruitToRemove = arr[left++];
                if(occuranceMap.get(fruitToRemove) > 1){
                    occuranceMap.put(fruitToRemove, occuranceMap.get(fruitToRemove) - 1);
                }else{
                    occuranceMap.remove(fruitToRemove);
                }
            }
        }
        return max;
    }

}
