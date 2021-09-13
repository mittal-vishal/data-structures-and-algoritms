package com.vishal.stack;

import java.util.Stack;

public class LargestRectangleAreaInHistogram {

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int[] rb = getNextSmallestFromRight(heights);
        int[] lb = getNextSmallestFromLeft(heights);

        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int currentArea = (rb[i] - lb[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;
    }

    private int[] getNextSmallestFromRight(int[] heights){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] rb = new int[n];

        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                rb[i] = n;
            }else{
                rb[i] = stack.peek();
            }
            stack.push(i);
        }
        return rb;
    }

    private int[] getNextSmallestFromLeft(int[] heights){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] lb = new int[n];

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                lb[i] = -1;
            }else{
                lb[i] = stack.peek();
            }
            stack.push(i);
        }
        return lb;
    }

}
