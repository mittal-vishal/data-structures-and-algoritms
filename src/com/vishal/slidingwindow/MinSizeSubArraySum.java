package com.vishal.slidingwindow;

class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int min = Integer.MAX_VALUE;
        int windowS = 0, windowE = 0;
        int sum = 0;
        while(windowE < arr.length){
            //Expand the window
            sum += arr[windowE++];
            //Shrink the wondow, until condition satisfies
            while(sum >= S){
                min = Math.min(min, windowE - windowS);
                sum -= arr[windowS++];
            }
        }
        return min;
    }
}
