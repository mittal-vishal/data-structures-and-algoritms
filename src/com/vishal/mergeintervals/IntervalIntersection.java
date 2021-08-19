package com.vishal.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList == null || secondList == null ||
                firstList.length == 0 || secondList.length == 0){
            return new int[0][0];
        }
        List<List<Integer>> intervalList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < firstList.length && j < secondList.length){
            int intersectStart = Math.max(firstList[i][0], secondList[j][0]);
            int intersectEnd = Math.min(firstList[i][1], secondList[j][1]);
            if(intersectStart <= intersectEnd){
                intervalList.add(new ArrayList(Arrays.asList(intersectStart, intersectEnd)));
            }
            if(firstList[i][1] > secondList[j][1]){
                j++;
            }else if(secondList[j][1] > firstList[i][1]){
                i++;
            }else{
                i++;
                j++;
            }
        }
        int[][] res = new int[intervalList.size()][2];
        for(int k = 0; k < intervalList.size(); k++){
            res[k][0] = intervalList.get(k).get(0);
            res[k][1] = intervalList.get(k).get(1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] first = {{0,2},{5,10},{13,23},{24,25}};
        int[][] second = {{1,5},{8,12},{15,24},{25,26}};
        intervalIntersection(first, second);
    }

}
