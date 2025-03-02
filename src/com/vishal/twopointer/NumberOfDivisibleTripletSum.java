package com.vishal.twopointer;

import java.util.HashMap;

public class NumberOfDivisibleTripletSum {

    public int divisibleTripletCount(int[] nums, int d) {
        HashMap<Integer,Integer> remainderOccurance = new HashMap<>();
        int answer = 0;
        for(int i = 2; i < nums.length; i++){
            int second = nums[i-1];
            for(int j = i-2; j >= 0; j--){
                int remainder = (nums[j] + second) % d;
                remainderOccurance.put(remainder, remainderOccurance.getOrDefault(remainder, 0) + 1);
            }
            int firstNumRemainder = nums[i] % d;
            answer += firstNumRemainder == 0 ? remainderOccurance.getOrDefault(0,0)
                    : remainderOccurance.getOrDefault(d-firstNumRemainder, 0);
        }
        return answer;
    }

    public static void main(String[] args) {
        NumberOfDivisibleTripletSum numberOfDivisibleTripletSum = new NumberOfDivisibleTripletSum();
        int[] nums = {3,3,4,7,8};
        int d = 5;
        System.out.println(numberOfDivisibleTripletSum.divisibleTripletCount(nums, d));
    }

}
