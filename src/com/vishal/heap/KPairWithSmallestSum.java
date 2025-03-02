package com.vishal.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairWithSmallestSum {

    static class Element{
        int i;
        int j;
        int val;
        public Element(int i, int j, int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        int m = nums1.length;
        int n = nums2.length;
        for(int i = 0; i < m; i++){
            pq.offer(new Element(i, 0, nums1[i]+nums2[0]));
        }
        List<List<Integer>> result = new ArrayList<>();
        while(!pq.isEmpty() && k-- > 0){
            Element curr = pq.poll();
            result.add(List.of(nums1[curr.i], nums2[curr.j]));
            if(curr.j < n-1){
                pq.offer(new Element(curr.i, curr.j+1, nums1[curr.i] + nums2[curr.j+1]));
            }
        }
        return result;
    }

}
