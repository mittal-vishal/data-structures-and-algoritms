package com.vishal.search;

class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (key > arr[arr.length - 1]){
            return -1;
        }else if(key < arr[0]){
            return 0;
        }

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(key == arr[mid]){
                return mid;
            }else if(key > arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
