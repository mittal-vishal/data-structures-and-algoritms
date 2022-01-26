package com.vishal.microsoft;

import java.util.Stack;

public class BuildingWithOceanView {

    public int[] findBuildings(int[] heights) {
        int maxHeight = -1;
        int n = heights.length;
        Stack<Integer> indices = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            if(heights[i] > maxHeight){
                maxHeight = heights[i];
                indices.push(i);
            }
        }
        int[] result = new int[indices.size()];
        int i = 0;
        while(!indices.isEmpty()){
            result[i++] = indices.pop();
        }
        return result;
    }

}
