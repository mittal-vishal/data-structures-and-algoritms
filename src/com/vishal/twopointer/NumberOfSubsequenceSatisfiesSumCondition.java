package com.vishal.twopointer;

import java.util.Arrays;

public class NumberOfSubsequenceSatisfiesSumCondition {

    private int MODULO = (int)1e9 + 7;
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        // Precompute the value of 2 to the power of each value.
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % MODULO;
        }

        int answer = 0;
        int left = 0, right = n - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                int range = right - left;
                answer += power[range];
                answer %= MODULO;
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }

}
