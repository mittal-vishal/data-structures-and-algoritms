package com.vishal.search;

interface MountainArray {
    public int get(int index);
    public int length();
}

public class FindMountainArray implements  MountainArray{

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int pos = binarySearch(mountainArr, 0, peak - 1, target, true);
        if(pos == -1){
            pos = binarySearch(mountainArr, peak, mountainArr.length() -1, target, false);
        }
        return pos;
    }

    private int binarySearch(MountainArray mountainArr, int start, int end, int target, boolean isAsc){
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == mountainArr.get(mid)){
                ans = mid;
                end = mid - 1;
            }else if((isAsc && target > mountainArr.get(mid)) || (!isAsc && target < mountainArr.get(mid))){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }

    private int findPeak(MountainArray mountainArr){
        if(mountainArr.length() == 0){
            return -1;
        }
        if(mountainArr.length() == 1){
            return 0;
        }
        int start = 0;
        int end = mountainArr.length() - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(start == end){
                return start;
            }else if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }
}
