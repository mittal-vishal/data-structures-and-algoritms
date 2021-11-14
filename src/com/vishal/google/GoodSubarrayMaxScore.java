package com.vishal.google;

public class GoodSubarrayMaxScore {

    public int maximumScore(int[] nums, int k) {
        int left = k-1;
        int right = k+1;

        int arrLength = nums.length;
        int maxScore = nums[k];
        int subarrayMin = nums[k];
        int currScore = 0;
        while(right < arrLength && left >= 0){
            if(nums[right] > nums[left]){
                subarrayMin = Math.min(subarrayMin, nums[right]);
                currScore = subarrayMin * (right-(left+1)+1);
                right++;
            }else{
                subarrayMin = Math.min(subarrayMin, nums[left]);
                currScore = subarrayMin * ((right-1)-left+1);
                left--;
            }
            maxScore = Math.max(maxScore, currScore);
        }
        while(right < arrLength){
            subarrayMin = Math.min(subarrayMin, nums[right]);
            currScore = Math.min(subarrayMin, nums[right]) * (right-left);
            maxScore = Math.max(maxScore, currScore);
            right++;
        }
        while(left >= 0){
            subarrayMin = Math.min(subarrayMin, nums[left]);
            currScore = Math.min(subarrayMin, nums[left]) * (right-left);
            maxScore = Math.max(maxScore, currScore);
            left--;
        }
        return maxScore;
    }

}

/**

 [5,5,4,5,4,1,1,1], k = 0
 l = -1, r = 5
 maxScore = 16
 subarrayMin = 1



 Brute Force - O(N3)
 N2 to find all subarray
 Another N - to find min of subarray

 An array of size N ->
 [1,4,3,7,4,5] -> k=3
 {3,3}{3,4} {3,5} -> From K to N
 {1,3}{2,3} -> From 0 to K

 {0,5}{0,4}{0,3}
 {1,5}{1,4}{1,3}
 {2,5}{2,4}{2,3}

 Final Approach ->

 Step 1: Start calculating from Kth element

 Step 2: Use left and right pointer and, whoever value is more, calculate the score, and update if greater

 Step3: Continue to consider left and right pointer until they vanish
 */
