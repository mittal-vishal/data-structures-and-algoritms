package com.vishal.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementLeetcodeFirst {

    public int[] nextGreaterElementOptimal(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> nextGreaterElements = new HashMap<>();
        for(int i = nums2.length-1; i >= 0; i--){
            int currNum = nums2[i];
            while(!stack.isEmpty() && currNum >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextGreaterElements.put(currNum, -1);
            }else{
                nextGreaterElements.put(currNum, stack.peek());
            }
            stack.push(currNum);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for(int i = 0; i < nums1.length; i++){
            res[index++] = nextGreaterElements.get(nums1[i]);
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
