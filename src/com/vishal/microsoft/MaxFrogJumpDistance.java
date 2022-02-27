package com.vishal.microsoft;

public class MaxFrogJumpDistance {

    public int getMaxDistance(int[] arr){
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for(int i = 1; i < n; i++){
            if(arr[i] <= arr[i-1]){
                leftMax[i] = leftMax[i-1] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] <= arr[i + 1]){
                rightMax[i] = rightMax[i+1] + 1;
            }
        }
        int maxDist = 0;
        for(int i = 0; i < n; i++){
            maxDist = Math.max(maxDist, (rightMax[i] + leftMax[i] + 1));
        }
        return maxDist;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 5, 2, 6};
        MaxFrogJumpDistance dist = new MaxFrogJumpDistance();
        int distance = dist.getMaxDistance(a);
        System.out.println(distance);
    }

}
