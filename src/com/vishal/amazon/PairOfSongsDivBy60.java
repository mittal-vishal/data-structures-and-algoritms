package com.vishal.amazon;

import java.util.HashMap;
import java.util.Map;

public class PairOfSongsDivBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> pairMap = new HashMap<>();
        int count = 0;
        for(int timeUnit: time){
            int remainderUnit = (60 - (timeUnit % 60)) % 60;
            count += pairMap.getOrDefault(remainderUnit, 0);
            pairMap.put(timeUnit % 60, pairMap.getOrDefault(timeUnit % 60, 0) + 1);
        }
        return count;
    }

}
