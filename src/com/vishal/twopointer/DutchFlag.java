package com.vishal.twopointer;

class DutchFlag {

    public static void sort(int[] arr) {
        int left = 0, right = arr.length - 1;
        // low->0 and high ->2
        for(int i = 0; i <= right;){
            if(arr[i] == 0){
                swapNumber(left, i, arr);
                i++; left++;

            }else if(arr[i] == 2){
                swapNumber(right, i, arr);
                right--;
            }else{
                i++;
            }
        }

    }

    private static void swapNumber(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
