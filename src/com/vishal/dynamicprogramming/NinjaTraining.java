package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class NinjaTraining {

    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return ninjaTraining(points, n-1, 3, dp);
    }

    private static int ninjaTraining(int[][] points, int days, int last, int[][] dp){
        if(days == 0){
            int max = 0;
            for(int task = 0; task < points[days].length; task++){
                if(task != last){
                    max = Math.max(max, points[days][task]);
                }
            }
            return max;
        }else if(dp[days][last] != -1){
            return dp[days][last];
        }
        int max = 0;
        for(int task = 0; task < points[days].length; task++){
            if(task != last){
                int currDayMax = points[days][task] + ninjaTraining(points, days-1, task, dp);
                max = Math.max(max, currDayMax);
            }
        }
        dp[days][last] = max;
        return max;
    }

    public static int ninjaTrainingTabulation(int n, int points[][]) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int days = 1; days < n; days++){
            for(int last = 0; last < 4; last++){
                dp[days][last] = 0;
                int max = 0;
                for(int task = 0; task < points[days].length; task++){
                    if(task != last){
                        int currDayMax = points[days][task] + dp[days-1][task];
                        max = Math.max(max, currDayMax);
                    }
                }
                dp[days][last] = max;
            }
        }
        return dp[n-1][3];
    }

    public static int ninjaTrainingSpaceOptimised(int n, int points[][]) {
        int[] prev = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int days = 1; days < n; days++){
            int[] temp = new int[4];
            for(int last = 0; last < 4; last++){
                temp[last] = 0;
                for(int task = 0; task < points[days].length; task++){
                    if(task != last){
                        int currDayMax = points[days][task] + prev[task];
                        temp[last] = Math.max(temp[last], currDayMax);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }

}
