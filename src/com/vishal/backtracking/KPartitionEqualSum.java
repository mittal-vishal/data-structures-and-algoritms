package com.vishal.backtracking;

public class KPartitionEqualSum {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % k != 0){
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, 0, k, 0, sum/k, visited);
    }

    private boolean canPartition(int[] nums, int start, int k, int currSum, int subsetSum, boolean[] visited){
        if(k == 0)  return true;
        else if(currSum > subsetSum)  return false;
        else if(currSum == subsetSum){
            return canPartition(nums, 0, k - 1, 0, subsetSum, visited);
        }
        for(int i = start; i < nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            if(canPartition(nums, i + 1, k, currSum + nums[i], subsetSum, visited)){
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

}
