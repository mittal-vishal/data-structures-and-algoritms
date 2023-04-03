package com.vishal.stack;

import java.util.Stack;

public class LargestRectangleAreaInHistogram {

    public static void main(String[] args) {
        LargestRectangleAreaInHistogram histogram = new LargestRectangleAreaInHistogram();
        int[] heights = {2,1,5,6,2,3};
        int area = histogram.largestRectangleArea(heights);
        System.out.println(area);
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        //stores next smaller element index from right
        int[] right = new int[n];
        //store next smaller element index from left
        int[] left = new int[n];
        getNextSmallerElementFromRight(heights, right);
        getNextSmallerElementFromLeft(heights, left);
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int currArea = (right[i] - left[i] - 1) * heights[i];
            maxArea =  Math.max(maxArea, currArea);
        }
        return maxArea;
    }

    private void getNextSmallerElementFromRight(int[] heights, int[] right){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            int currHeight = heights[i];
            while(!stack.isEmpty() && currHeight <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = n;
            }else{
                right[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    private void getNextSmallerElementFromLeft(int[] heights, int[] left){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int currHeight = heights[i];
            while(!stack.isEmpty() && currHeight <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = stack.peek();
            }
            stack.push(i);
        }
    }

}
