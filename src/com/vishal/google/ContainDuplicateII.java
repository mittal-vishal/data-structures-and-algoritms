package com.vishal.google;

import java.util.HashMap;

public class ContainDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> elementIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            if(elementIndex.containsKey(currNum)){
                int prevIdx = elementIndex.get(currNum);
                if((i - prevIdx) <= k){
                    return true;
                }
            }
            elementIndex.put(currNum, i);
        }
        return false;
    }

}
