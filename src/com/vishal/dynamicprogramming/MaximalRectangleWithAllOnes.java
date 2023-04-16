package com.vishal.dynamicprogramming;

import java.util.Stack;

public class MaximalRectangleWithAllOnes {

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        int result = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }
            result = Math.max(result, largestRectangleArea(height));
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] smallestRight = new int[n];
        int[] smallestLeft = new int[n];
        getSmallestFromRight(heights, smallestRight);
        getSmallestFromLeft(heights, smallestLeft);
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            maxArea = Math.max(maxArea, (smallestRight[i] - smallestLeft[i] - 1) * heights[i]);
        }
        return maxArea;
    }

    private void getSmallestFromRight(int[] heights, int[] smallestRight){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        for(int i = n-1; i >= 0; i--){
            int currHeight = heights[i];
            while(!stack.isEmpty() && currHeight <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                smallestRight[i] = n;
            }else{
                smallestRight[i] = stack.peek();
            }
            stack.push(i);
        }
    }

    private void getSmallestFromLeft(int[] heights, int[] smallestLeft){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        for(int i = 0; i < n; i++){
            int currHeight = heights[i];
            while(!stack.isEmpty() && currHeight <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                smallestLeft[i] = -1;
            }else{
                smallestLeft[i] = stack.peek();
            }
            stack.push(i);
        }
    }

}
