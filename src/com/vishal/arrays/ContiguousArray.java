package com.vishal.arrays;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int maxRes = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int oneCount = 0, zeroCount = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 0){
                    zeroCount++;
                }else{
                    oneCount++;
                }
                if(zeroCount == oneCount){
                    maxRes = Math.max(maxRes, (j - i) + 1);
                }
            }
        }
        return maxRes;
    }

}
