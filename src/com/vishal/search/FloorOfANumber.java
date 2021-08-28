package com.vishal.search;

class FloorOfANumber {

    public static int searchFloorOfANumber(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        if(key < arr[start]) {
            return -1;
        }else if(key > arr[end]){
            return end;
        }

        while(start <= end){
            int mid = start + (end - start)/2;
            if(key == arr[mid]) {
                return mid;
            }
            if(key > arr[mid-1] && key < arr[mid]){
                return mid - 1;
            }
            if(key < arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 1, 2, 4, 6, 10, 12, 14 }, 20));
        System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
