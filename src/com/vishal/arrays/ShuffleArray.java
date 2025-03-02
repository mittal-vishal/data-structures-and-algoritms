package com.vishal.arrays;

import java.util.Random;

public class ShuffleArray {

    private int[] nums;
    private Random random;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int n = nums.length;
        int[] clonedArr = nums.clone();
        int[] shuffleArr = new int[n];
        int j = n;
        for(int i = 0; i < n; i++){
            int index = random.nextInt(j);
            shuffleArr[i] = clonedArr[index];
            swap(clonedArr, index, j-1);
            j--;
        }
        return shuffleArr;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
