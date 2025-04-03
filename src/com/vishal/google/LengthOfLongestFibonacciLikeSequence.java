package com.vishal.google;

import java.util.HashSet;

public class LengthOfLongestFibonacciLikeSequence {

    public int lenLongestFibSubseq(int[] arr) {
        int res = 0;
        HashSet<Integer> elements = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            elements.add(arr[i]);
        }
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                int prev = arr[i];
                int curr = arr[j];
                int next = prev+curr;
                int length = 2;
                while(elements.contains(next)){
                    prev = curr;
                    curr = next;
                    next = prev+curr;
                    length++;
                    res = Math.max(res, length);
                }
            }
        }
        return res;
    }

}
