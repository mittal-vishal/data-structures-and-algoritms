package com.vishal.microsoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CinemaSeatAllocation {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> reservedSeatMap = new HashMap<>();
        for(int[] rSeat: reservedSeats){
            reservedSeatMap.putIfAbsent(rSeat[0], new HashSet<>());
            reservedSeatMap.get(rSeat[0]).add(rSeat[1]);
        }
        int maxFamilies = n*2;
        for(Map.Entry<Integer, HashSet<Integer>> entry: reservedSeatMap.entrySet()){
            HashSet<Integer> resSetPerRow = entry.getValue();
            int decrementSeat = 0;
            if(resSetPerRow.contains(2) || resSetPerRow.contains(3) ||
                    resSetPerRow.contains(4) || resSetPerRow.contains(5)){
                decrementSeat++;
                maxFamilies--;
            }
            if(resSetPerRow.contains(6) || resSetPerRow.contains(7) ||
                    resSetPerRow.contains(8) || resSetPerRow.contains(9)){
                decrementSeat++;
                maxFamilies--;
            }
            if(!resSetPerRow.contains(4) && !resSetPerRow.contains(5) &&
                    !resSetPerRow.contains(6) && !resSetPerRow.contains(7) && decrementSeat == 2){
                maxFamilies++;
            }
        }
        return maxFamilies;
    }

}
