package com.vishal.slidingwindow;

public class AlternateGroupsII {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int left = 0;
        int right = left+1;
        int n = colors.length;
        int groups = 0;
        while(right < (n+k-1)){
            //expand
            if(colors[right%n] == colors[(right-1)%n]){
                left = right;
            }
            //shrink if required
            if(right-left >= k){
                left++;
            }
            //collect
            if(right-left+1 == k){
                groups++;
            }
            right++;
        }
        return groups;
    }

}
