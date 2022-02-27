package com.vishal.microsoft;

import java.util.Arrays;

public class RoadPotholes {

    private static int maximumNumberOfSegmentWithPotholes(String L1, String L2) {
        int[][][] dp = new int[L1.length()][2][2];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return Math.max(getMaxNumberOfPotholesRepaired(L1, L2, 0, 0, 0, dp),
                getMaxNumberOfPotholesRepaired(L1, L2, 0, 1, 0, dp));
    }

    private static int getMaxNumberOfPotholesRepaired(String L1, String L2, int idx,
                                                      int lane, int isTakenTurn, int[][][] dp) {
        if (idx >= L1.length())
            return 0;
        if(dp[idx][lane][isTakenTurn] != -1){
            return dp[idx][lane][isTakenTurn];
        }
        int res = 0;
        if (lane == 0)
        {
            res += Math.max(((L2.charAt(idx) == 'x' ? 1: 0) +
                            getMaxNumberOfPotholesRepaired(L1, L2, idx + 1, 0,isTakenTurn, dp)),
                    (isTakenTurn == 0) ? getMaxNumberOfPotholesRepaired(L1, L2, idx+1, 1, 1, dp) : 0);
        }
        else
        {
            res += Math.max((L1.charAt(idx) == 'x' ? 1: 0) +
                            getMaxNumberOfPotholesRepaired(L1, L2, idx + 1, 1,isTakenTurn, dp),
                    (isTakenTurn == 0) ? getMaxNumberOfPotholesRepaired(L1, L2, idx+1, 0, 1, dp) : 0);
        }
        dp[idx][lane][isTakenTurn] = res;
        return res;
    }

    public static void main(String[] args) {
        String l1 = "..xx.x.";
        String l2 = "x.x.x..";
        int x = maximumNumberOfSegmentWithPotholes(l1, l2);
        System.out.println(x);
    }

}
