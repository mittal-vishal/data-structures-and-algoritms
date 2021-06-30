package com.vishal.twopointer;

class ShortestWindowSort {

    public static int sort(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start < end && arr[start] < arr[start+1])
            start++;
        while(end > 0 && arr[end] > arr[end - 1])
            end--;
        int minSubarray = Integer.MAX_VALUE;
        int maxSubarray = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++){
            if(arr[i] < minSubarray)
                minSubarray = arr[i];
            if(arr[i] > maxSubarray)
                maxSubarray = arr[i];
        }
        for(int i = 0 ; i < start; i++){
            if(arr[i] > minSubarray)
                start = i;
        }
        for(int i = end+1; i < arr.length; i++){
            if(arr[i] < maxSubarray)
                end = i;
        }
        return end > start ? (end - start) + 1 : 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.print(sort(arr));
    }
}
