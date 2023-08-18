package com.vishal.search;

public class MaxValueInBoundedArrayAtGivenIndex {

    public int maxValue(int n, int index, int maxSum) {
        int beg = 1;
        int end = maxSum;
        int result = 0;
        int rightElements = n-index-1;
        int leftElements = index;
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            long element = mid-1;
            long rightSum = 0;
            long leftSum = 0;
            if(element >= rightElements){
                rightSum = (element*(element+1))/2 - ((element-rightElements)*(element-rightElements+1))/2;
            }else{
                rightSum = (element*(element+1))/2 + (rightElements-element);
            }
            if(element >= leftElements){
                leftSum = (element*(element+1))/2 - ((element-leftElements)*(element-leftElements+1))/2;
            }else{
                leftSum = (element*(element+1))/2 + (leftElements-element);
            }
            long sum = leftSum + mid + rightSum;
            if(sum <= maxSum){
                result = mid;
                beg = mid+1;
            }else{
                end = mid-1;
            }
        }
        return result;
    }

}
