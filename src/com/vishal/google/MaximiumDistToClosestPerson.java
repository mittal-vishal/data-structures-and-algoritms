package com.vishal.google;

public class MaximiumDistToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] leftDist = new int[n];
        int[] rightDist = new int[n];

        //Update max dist from left
        leftDist[0] = seats[0] == 0? Integer.MAX_VALUE: 0;
        for(int i = 1; i < n; i++){
            if(seats[i] == 0){
                leftDist[i] = leftDist[i-1] != Integer.MAX_VALUE ?leftDist[i-1] + 1: Integer.MAX_VALUE;
            }else{
                leftDist[i] = 0;
            }
        }
        //Update max dist from right
        rightDist[n-1] = seats[n-1] == 0 ? Integer.MAX_VALUE: 0;
        for(int i = n-2; i >= 0; i--){
            if(seats[i] == 0){
                rightDist[i] = rightDist[i+1] != Integer.MAX_VALUE? rightDist[i+1] + 1: Integer.MAX_VALUE;
            }else{
                rightDist[i] = 0;
            }
        }
        int maxDist = 0;
        for(int i = 0; i < n; i++){
            maxDist = Math.max(maxDist, Math.min(leftDist[i], rightDist[i]));
        }
        return maxDist;
    }

}
