package com.vishal.backtracking;

public class CountSubsequenceSumEqualToK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int sum = 2;
        int result = getSubSequenceSumCount(arr, 0, 0, sum);
        System.out.println(result);
    }

    private static int getSubSequenceSumCount(int[] arr, int index, int sum, int targetSum) {
        if(index == arr.length){
            if(sum == targetSum){
                return 1;
            }
            return 0;
        }
        //pick
        sum += arr[index];
        int pick = getSubSequenceSumCount(arr, index+1, sum, targetSum);
        //not pick
        sum -= arr[index];
        int nonPick = getSubSequenceSumCount(arr, index+1, sum, targetSum);
        return pick + nonPick;
    }

}
