package com.vishal.hashing;

import java.util.Map;
import java.util.TreeMap;

public class HandOfStraight {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize == 1){
            return false;
        }
        TreeMap<Integer,Integer> occurance = new TreeMap<>();
        for(int i = 0; i < n; i++){
            int handNumber = hand[i];
            occurance.put(handNumber, occurance.getOrDefault(handNumber,0) + 1);
        }
        while(occurance.size() > 0){
            Map.Entry<Integer,Integer> entry = occurance.entrySet().iterator().next();
            int currCard = entry.getKey();
            for(int i = 0; i < groupSize; i++){
                if(!occurance.containsKey(currCard+i)){
                    return false;
                }
                occurance.put(currCard+i, occurance.get(currCard+i) - 1);
                if(occurance.get(currCard+i) == 0){
                    occurance.remove(currCard+i);
                }
            }
        }
        return true;
    }

}
