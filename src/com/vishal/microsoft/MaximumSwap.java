package com.vishal.microsoft;

public class MaximumSwap {

    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] numArr = numStr.toCharArray();
        int[] maxRightPos = new int[numArr.length];
        int maxPos = numArr.length - 1;

        for(int i = maxPos; i >= 0; i--){
            if(numArr[i] > numArr[maxPos]){
                maxPos = i;
            }
            maxRightPos[i] = maxPos;
        }

        for(int i = 0; i < maxRightPos.length; i++){
            if(numArr[i] < numArr[maxRightPos[i]]){
                char temp = numArr[i];
                numArr[i] = numArr[maxRightPos[i]];
                numArr[maxRightPos[i]] = temp;
                break;
            }
        }
        numStr = String.valueOf(numArr);
        return Integer.valueOf(numStr);
    }

}
