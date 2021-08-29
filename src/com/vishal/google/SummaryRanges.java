package com.vishal.google;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> summaryRanges = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return summaryRanges;
        }
        int i = 0;
        for(int j = 0; j < nums.length - 1; j++){
            if(nums[j] == nums[j+1] - 1){
                continue;
            }else if(i == j){
                summaryRanges.add(nums[i] + "");
                i = j + 1;
            }else{
                summaryRanges.add(nums[i] + "->" + nums[j]);
                i = j + 1;
            }
        }
        if(i == nums.length - 1){
            summaryRanges.add(nums[i] + "");
        }else{
            summaryRanges.add(nums[i] + "->" + nums[nums.length - 1]);
        }
        return summaryRanges;
    }

}
