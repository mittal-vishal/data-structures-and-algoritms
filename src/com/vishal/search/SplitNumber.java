package com.vishal.search;

public class SplitNumber {

    public int splitArray(int[] nums, int m) {
        if(nums.length == 0){
            return -1;
        }

        int min = nums[0];
        int max = 0;
        for(int num: nums){
            max += num;
            min = Math.min(min, num);
        }

        int ans = Integer.MAX_VALUE;

        while(min <= max){
            int mid = min + (max - min) / 2;
            if(isPossible(nums, m, mid)){
                ans = Math.min(ans, mid);
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] nums, int m, int guess){
        int split = 1;
        int sum = guess;
        for(int i = 0; i < nums.length; i++){
            if(sum - nums[i] >= 0){
                sum -= nums[i];
            }else if(sum - nums[i] < 0 && i < nums.length){
                split++;
                i--;
                sum = guess;
                if(split > m){
                    return false;
                }
            }
        }
        return true;
    }

}
