package com.vishal.dynamicprogramming;

import java.util.HashMap;

public class FrogJumpLeetcode {

    private HashMap<Integer,Integer> stonePos;

    public boolean canCross(int[] stones) {
        int n = stones.length;
        stonePos = new HashMap<>();
        for(int i = 0; i < n; i++){
            stonePos.put(stones[i], i);
        }
        Boolean[][] dp = new Boolean[n][n+1];
        return canJump(stones, 0, stones[0], dp);
    }

    private boolean canJump(int[] stones, int index, int prevJump, Boolean[][] dp){
        if(index == stones.length-1){
            return true;
        }else if(dp[index][prevJump] != null){
            return dp[index][prevJump];
        }
        boolean result = false;
        for(int nextJump = prevJump-1; nextJump <= prevJump+1; nextJump++){
            if(nextJump > 0 && stonePos.containsKey(stones[index]+nextJump)){
                result = result || canJump(stones, stonePos.get(stones[index]+nextJump), nextJump, dp);
            }
        }
        return dp[index][prevJump] = result;
    }

}
