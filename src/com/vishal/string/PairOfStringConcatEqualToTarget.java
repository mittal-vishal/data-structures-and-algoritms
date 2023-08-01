package com.vishal.string;

import java.util.HashMap;

public class PairOfStringConcatEqualToTarget {

    public int numOfPairs(String[] nums, String target) {
        HashMap<String,Integer> occurances = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            String num = nums[i]+"";
            occurances.put(num, occurances.getOrDefault(num,0) + 1);
        }
        int count = 0;
        for(int i = 1; i < target.length(); i++){
            String left = target.substring(0,i);
            String right = target.substring(i, target.length());
            if(occurances.containsKey(left) && occurances.containsKey(right)){
                if(!left.equals(right)){
                    count += occurances.get(left)*occurances.get(right);
                }else{
                    count += occurances.get(left)*(occurances.get(left)-1);
                }
            }
        }
        return count;
    }

}
