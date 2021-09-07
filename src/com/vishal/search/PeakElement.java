package com.vishal.search;

public class PeakElement {

	public int peakIndexInMountainArray(int[] arr) {
		if(arr.length == 0){
			return -1;
		}
		if(arr.length == 1){
			return 0;
		}
		int start = 0;
		int end = arr.length - 1;

		while(start <= end){
			int mid = start + (end - start)/2;
			if(start == end){
				return start;
			}else if(arr[mid] < arr[mid + 1]){
				start = mid + 1;
			}else{
				end = mid;
			}
		}
		return start;
	}

}
