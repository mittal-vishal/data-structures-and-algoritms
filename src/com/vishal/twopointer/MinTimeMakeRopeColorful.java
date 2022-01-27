package com.vishal.twopointer;

public class MinTimeMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {
        int minCost = 0;
        int left = 0;
        int right = 1;
        while(right < colors.length()){
            if(colors.charAt(left) != colors.charAt(right)){
                left = right;
                right++;
            }else{
                if(neededTime[left] < neededTime[right]){
                    minCost += neededTime[left];
                    left = right;
                    right++;
                }else{
                    minCost += neededTime[right];
                    right++;
                }
            }
        }
        return minCost;
    }

}
