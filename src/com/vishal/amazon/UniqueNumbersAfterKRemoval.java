package com.vishal.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UniqueNumbersAfterKRemoval {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> numOccurMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            numOccurMap.put(arr[i], numOccurMap.getOrDefault(arr[i], 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList(numOccurMap.entrySet());
        Collections.sort(entryList, (a, b) -> a.getValue()-b.getValue());
        int minUniqueElement = entryList.size();
        for(Map.Entry<Integer, Integer> entry: entryList){
            k -= entry.getValue();
            if(k >= 0){
                minUniqueElement--;
            }
        }
        return minUniqueElement;
    }

}
