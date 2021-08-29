package com.vishal.search;

public class SearchInSortedArrUnknownSize {

    static class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }

    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;
        while(target > reader.get(end)){
            start = end;
            end <<= 1;
        }
        int index = binarySearch(reader, start, end, target);
        return index;
    }

    private int binarySearch(ArrayReader reader, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(reader.get(mid) == target){
                return mid;
            }else if(target > reader.get(mid)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        SearchInSortedArrUnknownSize searchInSortedArrUnknownSize = new SearchInSortedArrUnknownSize();
        System.out.println(searchInSortedArrUnknownSize.search(reader, 16));
        System.out.println(searchInSortedArrUnknownSize.search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(searchInSortedArrUnknownSize.search(reader, 15));
        System.out.println(searchInSortedArrUnknownSize.search(reader, 200));
    }

}
