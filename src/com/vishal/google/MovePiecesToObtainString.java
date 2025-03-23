package com.vishal.google;

public class MovePiecesToObtainString {

    public boolean canChange(String start, String target) {
        int i = 0;
        int j = 0;
        int n = start.length();
        while(i < n || j < n){
            //keep going on right until get either L or R
            while(i < n && start.charAt(i) == '_'){
                i++;
            }
            while(j < n && target.charAt(j) == '_'){
                j++;
            }
            if(i == n || j == n){
                return i == j && i == n;
            }
            if(start.charAt(i) != target.charAt(j) || start.charAt(i) == 'L' && i < j ||
                    start.charAt(i) == 'R' && i > j){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

}
