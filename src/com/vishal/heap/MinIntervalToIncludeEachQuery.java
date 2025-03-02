package com.vishal.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinIntervalToIncludeEachQuery {

    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[][] queriesIndices = new int[n][2];
        for(int i = 0; i < n; i++){
            queriesIndices[i][0] = queries[i];
            queriesIndices[i][1] = i;
        }
        Arrays.sort(queriesIndices, (a, b) -> a[0]-b[0]);
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        int j = 0;
        int[] res = new int[n];
        for(int[] query: queriesIndices){
            int queryValue = query[0];
            int queryIndex = query[1];
            while(j < intervals.length && intervals[j][0] <= queryValue){
                minHeap.offer(new int[]{(intervals[j][1]-intervals[j][0]+1), intervals[j][1]});
                j++;
            }
            while(!minHeap.isEmpty() && queryValue > minHeap.peek()[1]){
                minHeap.poll();
            }
            if(!minHeap.isEmpty()){
                res[queryIndex] = minHeap.peek()[0];
            }else{
                res[queryIndex] = -1;
            }
        }
        return res;
    }

}
