package com.vishal.search;

public class HouseRobberIV {

    public int minCapability(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int beg = nums[0];
        int end = nums[0];
        for(int num: nums){
            beg = Math.min(beg, num);
            end = Math.max(end, num);
        }
        int result = 0;
        while(beg <= end){
            int guess = beg + (end-beg)/2;
            if(isPossible(guess, nums, k)){
                result = guess;
                end = guess - 1;
            }else{
                beg = guess + 1;
            }
        }
        return result;
    }

    private boolean isPossible(int guess, int[] nums, int k){
        int robbedHouses = 0;
        for(int i = 0; i < nums.length; i++){
            int amount = nums[i];
            if(guess >= amount){
                robbedHouses++;
                i++;
            }
        }
        return robbedHouses >= k;
    }

}
