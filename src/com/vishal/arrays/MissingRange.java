package com.vishal.arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> results = new ArrayList<>();
        int prev = lower - 1;
        for(int i = 0; i <= nums.length; i++){
            int curr = i < nums.length? nums[i]: upper+1;
            if((prev+1) <= (curr-1)){
                addMissingRange(prev+1, curr-1, results);
            }
            prev = curr;
        }
        return results;
    }

    private void addMissingRange(int lower, int upper, List<String> results){
        String range = lower != upper? lower+"->"+upper: lower+"";
        results.add(range);
    }

}
