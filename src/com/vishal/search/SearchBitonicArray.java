package com.vishal.search;

public class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        if(arr == null || arr.length == 0){
            return -1;
        }
        int maxIdx = getMaxIndex(arr);
        int searchIdx = -1;
        searchIdx = binarySearch(arr, key, 0, maxIdx, true);
        if(searchIdx == -1){
            searchIdx = binarySearch(arr, key, maxIdx + 1, arr.length - 1, false);
        }
        return searchIdx;
    }

    private static int getMaxIndex(int[] arr){
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
        return beg;
    }

    private static int binarySearch(int[] arr, int key, int beg, int end, boolean isInc){
        while(beg <= end){
            int mid = beg + (end - beg)/2;
            if(arr[mid] == key){
                return mid;
            }else if((isInc && key > arr[mid]) || (!isInc && key < arr[mid])){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}
