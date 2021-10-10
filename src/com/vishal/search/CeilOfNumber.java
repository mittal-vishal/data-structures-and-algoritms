package com.vishal.search;

class CeilOfNumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        int start = 0;
        int end = arr.length-1;
        int ceil = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == key){
                ceil = mid;
                break;
            }else if(key > arr[mid]){
                start = mid+1;
            }else{
                ceil = mid;
                end = mid - 1;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        System.out.println(CeilOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilOfNumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
