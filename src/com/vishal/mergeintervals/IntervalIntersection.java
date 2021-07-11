package com.vishal.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0){
            return new int[0][0];
        }

        List<List<Integer>> intersectionList = new ArrayList<>();
        int i = 0, j = 0;

        while(i < firstList.length && j < secondList.length){
            //Check for intersection
            int max = Math.max(firstList[i][0], secondList[j][0]);
            int min = Math.min(firstList[i][1], secondList[j][1]);
            if(max <= min){
                intersectionList.add(Arrays.asList(max, min));
            }
            if(firstList[i][1] < secondList[j][1]){
                i++;
            }else if(firstList[i][1] > secondList[j][1]){
                j++;
            }else{
                i++;
                j++;
            }
        }
        int[][] resultant = new int[intersectionList.size()][2];
        for(i = 0; i < intersectionList.size(); i++){
            resultant[i][0] = intersectionList.get(i).get(0);
            resultant[i][1] = intersectionList.get(i).get(1);
        }
        return resultant;
    }

    public static void main(String[] args) {
        int[][] first = {{0,2},{5,10},{13,23},{24,25}};
        int[][] second = {{1,5},{8,12},{15,24},{25,26}};
        intervalIntersection(first, second);
    }

}
