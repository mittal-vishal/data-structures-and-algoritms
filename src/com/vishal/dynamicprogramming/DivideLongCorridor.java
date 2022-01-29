package com.vishal.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideLongCorridor {

    private static final int MODULO = 1000000007;

    public int numberOfWays(String corridor) {
        int modulo = 1000000007;
        List<Integer> seats = new ArrayList<>();
        for(int i = 0; i < corridor.length(); i++){
            if(corridor.charAt(i) == 'S'){
                seats.add(i);
            }
        }
        if(seats.size() == 0 || seats.size() % 2 == 1){
            return 0;
        }
        int prevSeat = seats.get(1);
        long ans = 1;
        for(int i = 2; i < seats.size(); i += 2){
            ans *= seats.get(i) - prevSeat;
            ans %= modulo;
            prevSeat = seats.get(i+1);
        }
        return (int)ans;
    }

    public int numberOfWays1(String corridor) {
        int[][] dp = new int[corridor.length()][3];
        for(int i = 0; i < corridor.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return divideWays(corridor, 0, 0, dp);
    }

    private int divideWays(String corridor, int idx, int seats, int[][] dp){
        if(idx == corridor.length()){
            if(seats == 2) return 1;
            return 0;
        }
        if(dp[idx][seats] != -1){
            return dp[idx][seats];
        }
        int ans = 0;
        if(seats == 2){
            if(corridor.charAt(idx) == 'P'){
                //Place
                ans += divideWays(corridor, idx + 1, 0, dp);
                ans %= MODULO;
                //Don't Place
                ans += divideWays(corridor, idx + 1, seats, dp);
                ans %= MODULO;
            }else{
                ans += divideWays(corridor, idx + 1, 1, dp);
                ans %= MODULO;
            }
        }else{
            seats += corridor.charAt(idx) == 'S' ? 1 : 0;
            ans += divideWays(corridor, idx + 1, seats, dp);
            ans %= MODULO;
        }
        dp[idx][seats] = ans;
        return dp[idx][seats];
    }

}
