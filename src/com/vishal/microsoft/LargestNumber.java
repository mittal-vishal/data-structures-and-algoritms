package com.vishal.microsoft;

import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        String[] numsStrArr = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            numsStrArr[i] = nums[i] + "";
        }
        Arrays.sort(numsStrArr, (a, b) -> {
            String num1 = a+b;
            String num2 = b+a;
            return num2.compareTo(num1);
        });
        if(numsStrArr[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numsStrArr.length; i++){
            sb.append(numsStrArr[i]);
        }
        return sb.toString();
    }

}
