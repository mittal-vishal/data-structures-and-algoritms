package com.vishal.twopointer;

public class RemoveDups {

    public static int remove(int[] arr) {
        int nonDupIdx = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[nonDupIdx]){
                nonDupIdx++;
                arr[nonDupIdx] = arr[i];
            }
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
