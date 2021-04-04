package com.vishal.arrays;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int swappedPos = -1;
        int n = nums.length;

        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                swappedPos = i;
                break;
            }
        }

        if(swappedPos != -1){
            int swappedWith = n-1;

            while(swappedWith != swappedPos){
                if(nums[swappedWith] > nums[swappedPos])
                    break;
                else
                    swappedWith--;
            }

            int temp = nums[swappedPos];
            nums[swappedPos] = nums[swappedWith];
            nums[swappedWith] = temp;

            for(int i = swappedPos + 1; i < n; i++){
                int min = i;
                for(int j = i + 1; j < n; j++){
                    if(nums[j] < nums[min]){
                        min = j;
                    }
                }
                if(min != i){
                    temp = nums[i];
                    nums[i] = nums[min];
                    nums[min] = temp;
                }
            }

        }else{
            Arrays.sort(nums);
        }

    }

}
