package com.vishal.google;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        OddEvenJumps oddEvenJumps = new OddEvenJumps();
        oddEvenJumps.oddEvenJumps(arr);
    }

    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer,Integer> elementIndex = new TreeMap<>();
        int n = arr.length;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n-1] = true;
        even[n-1] = true;
        elementIndex.put(arr[n-1], n-1);
        for(int i = n-2; i >= 0; i--){
            int curr = arr[i];
            Map.Entry<Integer,Integer> ceiling = elementIndex.ceilingEntry(curr);
            Map.Entry<Integer,Integer> floor = elementIndex.floorEntry(curr);
            if(ceiling != null){
                odd[i] = even[ceiling.getValue()];
            }
            if(floor != null){
                even[i] = odd[floor.getValue()];
            }
            elementIndex.put(curr, i);
        }
        int goodIndices = 0;
        for(int i = 0; i < n; i++){
            if(odd[i]){
                goodIndices++;
            }
        }
        return goodIndices;
    }

}
