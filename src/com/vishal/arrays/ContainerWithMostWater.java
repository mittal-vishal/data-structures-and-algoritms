package com.vishal.arrays;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < height.length-1; i++){
            for(int j = i+1; j < height.length; j++){
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    public int maxAreaOptimal(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right-left));
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

}
