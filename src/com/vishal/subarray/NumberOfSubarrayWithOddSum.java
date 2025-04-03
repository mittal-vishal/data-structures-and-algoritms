package com.vishal.subarray;

public class NumberOfSubarrayWithOddSum {

    private final int MOD = (int)1e9+7;

    public int numOfSubarrays(int[] arr) {
        int evenCount = 0;
        int oddCount = 0;
        int currSum = 0;
        int subarrays = 0;
        for(int i = 0; i < arr.length; i++){
            currSum += arr[i];
            if(currSum % 2 == 1){
                subarrays = (subarrays + 1 + evenCount) % MOD;
                oddCount++;
            }else{
                subarrays = (subarrays + oddCount) % MOD;
                evenCount++;
            }
        }
        return subarrays;
    }

}
