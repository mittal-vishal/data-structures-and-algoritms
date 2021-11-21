package com.vishal.search;

class MaxInBitonicArray {

    public static int findMax(int[] arr) {
        int beg = 0;
        int end = arr.length - 1;
        while(beg < end){
            int mid = beg + (end - beg)/2;
            if(arr[mid] < arr[mid + 1]){
                beg = mid + 1;
            }else{
                end = mid;
            }
        }
        return arr[beg];
    }

    public static void main(String[] args) {
        MaxInBitonicArray rotatedArray = new MaxInBitonicArray();
        System.out.println(rotatedArray.findMax(new int[] { 5, 1, 3 }));
        System.out.println(rotatedArray.findMax(new int[] { 3, 8, 3, 1 }));
        System.out.println(rotatedArray.findMax(new int[] { 1, 3, 8, 12 }));
        System.out.println(rotatedArray.findMax(new int[] { 10, 9, 8 }));
    }
}