package com.vishal.google;

import java.util.Arrays;

public class NumberOfWeakCharacterInGame {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            if(a[0] != b[0]){
                return a[0]-b[0];
            }else{
                return b[1]-a[1];
            }
        });
        int result = 0;
        int maxDefense = 0;
        for(int i = properties.length-1; i >= 0; i--){
            int[] currChar = properties[i];
            if(maxDefense > currChar[1]){
                result++;
            }
            maxDefense = Math.max(maxDefense, currChar[1]);
        }
        return result;
    }

}
