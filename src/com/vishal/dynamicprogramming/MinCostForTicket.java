package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;

public class MinCostForTicket {

    private HashSet<Integer> daysToTravel;

    public int mincostTickets(int[] days, int[] costs) {
        daysToTravel = new HashSet<>();
        for(int day: days){
            daysToTravel.add(day);
        }
        int[] dp = new int[366];
        Arrays.fill(dp, -1);
        return mincostTickets(days, costs, 1, dp);
    }

    private int mincostTickets(int[] days, int[] costs, int currDay, int[] dp){
        if(currDay > days[days.length-1]){
            return 0;
        }else if(dp[currDay] != -1){
            return dp[currDay];
        }else if(!daysToTravel.contains(currDay)){
            return dp[currDay] = mincostTickets(days, costs, currDay+1, dp);
        }
        int oneDay = costs[0] + mincostTickets(days, costs, currDay+1, dp);
        int sevenDay = costs[1] + mincostTickets(days, costs, currDay+7, dp);
        int thirtyDay = costs[2] + mincostTickets(days, costs, currDay+30, dp);
        return dp[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }

}
