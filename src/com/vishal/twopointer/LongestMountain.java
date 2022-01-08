package com.vishal.twopointer;

public class LongestMountain {

    public int longestMountain(int[] arr) {
        int left = 0;
        int right = 1;
        int longestMountainSize = 0;
        boolean isIncl = true;
        boolean isDecl = false;
        int declStart = -1;
        int declSize = -1;
        while(right < arr.length){
            if(isIncl){
                if(arr[right] > arr[right-1]){
                    right++;
                }else{
                    int inclSize = right - left - 1;
                    if(inclSize > 0){
                        isDecl = true;
                        declStart = right - 1;
                        isIncl = false;
                    }else{
                        left = right++;
                    }
                }
            }
            if(isDecl){
                if(right < arr.length && arr[right] < arr[right - 1]){
                    right++;
                }else{
                    declSize = right - declStart - 1;
                    if(declSize > 0 && !isIncl){
                        isIncl = true;
                        longestMountainSize = Math.max(longestMountainSize, right - left);
                    }
                    left = right - 1;
                    isIncl = true;
                    isDecl = false;
                }
            }
        }
        declSize = right - declStart;
        if(declSize > 0 && !isIncl){
            isIncl = true;
            longestMountainSize = Math.max(longestMountainSize, right - left);
        }
        return longestMountainSize;
    }

}
