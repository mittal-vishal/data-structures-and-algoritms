package com.vishal.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairWithSmallestSum {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> b.get(0) + b.get(1) - a.get(0) - a.get(1));
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(pq.size() < k){
                    pq.offer(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
                }else{
                    if((nums1[i] + nums2[j]) > (pq.peek().get(0) + pq.peek().get(1))){
                        break;
                    }else{
                        pq.poll();
                        pq.offer(new ArrayList(Arrays.asList(nums1[i], nums2[j])));
                    }
                }
            }
        }
        return new ArrayList<>(pq);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 5;
        KPairWithSmallestSum pair = new KPairWithSmallestSum();
        System.out.print(pair.kSmallestPairs(nums1, nums2, k));
    }

}
