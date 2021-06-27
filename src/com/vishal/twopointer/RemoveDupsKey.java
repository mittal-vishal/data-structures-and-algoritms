package com.vishal.twopointer;

public class RemoveDupsKey {

    public static int remove(int[] arr, int key) {
        int nonDuplicateIndex = 0; // index of the next element which is not 'key'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nonDuplicateIndex++] = arr[i];
            }
        }

        return nonDuplicateIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(RemoveDupsKey.remove(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(RemoveDupsKey.remove(arr, 2));
    }

}
