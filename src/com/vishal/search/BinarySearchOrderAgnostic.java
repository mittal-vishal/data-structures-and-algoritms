package com.vishal.search;

class BinarySearchOrderAgnostic {

    public int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        boolean isIncrOrder = arr[start] < arr[end] ? true: false;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(key == arr[mid]){
                return mid;
            }else if((isIncrOrder && key > arr[mid]) || (!isIncrOrder && key < arr[mid])){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchOrderAgnostic binarySearch = new BinarySearchOrderAgnostic();
        System.out.println(binarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(binarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(binarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(binarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}
