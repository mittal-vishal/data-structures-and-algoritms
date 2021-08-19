package com.vishal.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        ArrayList<Integer> startTimeList = new ArrayList<>();
        HashMap<Integer, Integer> startTimeWithIndexMap = new HashMap<>();

        for(int i = 0; i < intervals.length; i++){
            startTimeList.add(intervals[i][0]);
            startTimeWithIndexMap.put(intervals[i][0], i);
        }

        Collections.sort(startTimeList);

        int[] res = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            int end = intervals[i][1];
            int start = binarySearch(startTimeList, end);

            if(start < end){
                res[i] = -1;
            }else{
                res[i] = startTimeWithIndexMap.get(start);
            }
        }

        return res;
    }

    private int binarySearch(ArrayList<Integer> list, int item){
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            int mid = left + ((right - left) / 2);
            if(item == list.get(mid)){
                return list.get(mid);
            }else if(item > list.get(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return list.get(left);
    }

    public int[] findRightIntervalUsingTreeMap(int[][] intervals) {
        TreeMap<Integer, Integer> startTreeMap = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++){
            startTreeMap.put(intervals[i][0], i);
        }

        int[] res = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            Entry<Integer, Integer> ceilEntry = startTreeMap.ceilingEntry(intervals[i][1]);
            if(ceilEntry == null){
                res[i] = -1;
            }else{
                res[i] = ceilEntry.getValue();
            }
        }
        return res;
    }

}
