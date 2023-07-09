package com.vishal.google;

import java.util.HashSet;

public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> uniqueSet = new HashSet<>();
        if(!getDistance(p1, p2, uniqueSet) ||
                !getDistance(p1, p3, uniqueSet) ||
                !getDistance(p1, p4, uniqueSet) ||
                !getDistance(p2, p3, uniqueSet) ||
                !getDistance(p2, p4, uniqueSet) ||
                !getDistance(p3, p4, uniqueSet)){
            return false;
        }
        return uniqueSet.size() == 2 ? true: false;
    }

    private boolean getDistance(int[] p1, int[] p2, HashSet<Integer> uniqueSet){
        if(p1[0] == p2[0] && p1[1] == p2[1]){
            return false;
        }
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        int dist = dx*dx + dy*dy;
        uniqueSet.add(dist);
        return true;
    }

}
