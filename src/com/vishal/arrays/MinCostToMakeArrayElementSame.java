package com.vishal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinCostToMakeArrayElementSame {

    static class Element{
        int num;
        int cost;
        public Element(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }

    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        List<Element> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Element(nums[i], cost[i]));
        }
        Collections.sort(list, (a, b) -> a.num-b.num);
        long totalNum = 0;
        for(Element element: list){
            totalNum += element.cost;
        }
        long currNum = 0;
        long median = 0;
        for(int i = 0; i < list.size() && currNum < (totalNum+1)/2; i++){
            Element element = list.get(i);
            currNum += element.cost;
            median = element.num;
        }
        return calculateMinCost(nums, cost, median);
    }

    private long calculateMinCost(int[] nums, int[] cost, long median){
        long result = 0L;
        for(int i = 0; i < nums.length; i++){
            result += Math.abs((nums[i]-median) * cost[i]);
        }
        return result;
    }

}
