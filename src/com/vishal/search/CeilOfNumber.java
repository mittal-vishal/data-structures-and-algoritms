package com.vishal.search;

class CeilOfNumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        int beg = 0;
        int end = arr.length-1;
        if(key > arr[end]){
            return -1;
        }else if(key < arr[beg]){
            return beg;
        }
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            if(key == arr[mid]){
                return mid;
            }
            if(key > arr[mid-1] && key < arr[mid]){
                return mid;
            }
            if(key > arr[mid]){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(CeilOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilOfNumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
