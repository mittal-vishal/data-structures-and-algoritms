package com.vishal.stack;

import java.util.Stack;

public class NumberOfVisiblePeopleInQueue {

    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> monoStack = new Stack<>();
        int[] res = new int[heights.length];
        for(int i = heights.length-1; i >= 0; i--){
            int currHeight = heights[i];
            int visibility = 0;
            while(!monoStack.isEmpty() && currHeight > monoStack.peek()){
                monoStack.pop();
                visibility++;
            }
            if(!monoStack.isEmpty()){
                visibility++;
            }
            res[i] = visibility;
            monoStack.push(currHeight);
        }
        return res;
    }

}
