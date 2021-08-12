package com.vishal.stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementLeetcodeFirst {

    public int[] nextGreaterElementOptimal(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty()){
                nextGreaterMap.put(nums2[i], stack.peek());
            }else{
                nextGreaterMap.put(nums2[i], -1);
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int k = -1;
        boolean isNextFound = false;
        for(int i = 0; i < nums1.length; i++){
            k = -1;
            isNextFound = false;
            for(int j = 0; j < nums2.length; j++){
                if(nums2[j] == nums1[i]){
                    k = j + 1;
                    break;
                }
            }
            if(k == -1){
                res[i] = -1;
                continue;
            }
            for(int j = k; j < nums2.length; j++){
                if(nums2[j] > nums1[i]){
                    res[i] = nums2[j];
                    isNextFound = true;
                    break;
                }
            }
            if(!isNextFound){
                res[i] = -1;
            }
        }
        return res;
    }

}
