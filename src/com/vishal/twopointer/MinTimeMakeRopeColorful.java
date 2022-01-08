package com.vishal.twopointer;

public class MinTimeMakeRopeColorful {

    public int minCost(String colors, int[] neededTime) {
        int left = 0;
        int right = 1;
        int totalTime = 0;

        while(right < colors.length()){
            if(colors.charAt(left) == colors.charAt(right)){
                if(neededTime[left] < neededTime[right]){
                    totalTime += neededTime[left];
                    left = right;
                }else{
                    totalTime += neededTime[right];
                }
            }else{
                left = right;
            }
            right = right + 1;
        }
        return totalTime;
    }

}
