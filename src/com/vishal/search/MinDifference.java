package com.vishal.search;

class MinDifference {

    public static int searchMinDiffElement(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        if(key > arr[end]){
            return arr[end];
        }else if(key < arr[start]){
            return arr[0];
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            if(key == arr[mid]){
                return arr[mid];
            }else if(key  > arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        if(Math.abs(key - arr[start]) < Math.abs(key - arr[end])){
            return arr[start];
        }else{
            return arr[end];
        }
    }

    public static void main(String[] args) {
        System.out.println(MinDifference.searchMinDiffElement(new int[] { 3, 8, 15, 70, 120, 150 }, 97));
        System.out.println(MinDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 4));
        System.out.println(MinDifference.searchMinDiffElement(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(MinDifference.searchMinDiffElement(new int[] { 4, 6, 10 }, 17));
    }
}
