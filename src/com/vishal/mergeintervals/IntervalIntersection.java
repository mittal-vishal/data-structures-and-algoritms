package com.vishal.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IntervalIntersection {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        int n = firstList.length;
        int m = secondList.length;
        List<int[]> intersections = new ArrayList<>();
        while(i < n && j < m){
            int[] intervalA = firstList[i];
            int[] intervalB = secondList[j];
            int intersectionStart = Math.max(intervalA[0], intervalB[0]);
            int intersectionEnd = Math.min(intervalA[1], intervalB[1]);
            if(intersectionStart <= intersectionEnd){
                intersections.add(IntStream.of(intersectionStart, intersectionEnd).toArray());
            }
            if(intervalA[1] < intervalB[1]){
                i++;
            }else if(intervalB[1] < intervalA[1]){
                j++;
            }else{
                i++;
                j++;
            }
        }
        int[][] res = new int[intersections.size()][2];
        for(int k = 0; k < intersections.size(); k++){
            res[k] = intersections.get(k);
        }
        return res;
    }

}
