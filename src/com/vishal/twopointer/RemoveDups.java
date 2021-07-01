package com.vishal.twopointer;

public class RemoveDups {

    public static int remove(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int i = 1, nonDupIdx = 0;
        while(i < arr.length){
            if(arr[i] != arr[i-1]){
                arr[nonDupIdx++] = arr[i];
            }
            i++;
        }
        return nonDupIdx + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDups.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDups.remove(arr));
    }
}
