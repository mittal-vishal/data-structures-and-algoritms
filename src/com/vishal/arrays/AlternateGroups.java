package com.vishal.arrays;

public class AlternateGroups {

    public int numberOfAlternatingGroups(int[] colors) {
        int groups = 0;
        int n = colors.length;
        for(int i = 0; i < n; i++){
            boolean isAlternate = true;
            int prev = colors[i];
            for(int j = i+1; j < i+3; j++){
                if(colors[j%n] == prev){
                    isAlternate = false;
                    break;
                }else{
                    prev = colors[j%n];
                }
            }
            if(isAlternate){
                groups++;
            }
        }
        return groups;
    }

}
