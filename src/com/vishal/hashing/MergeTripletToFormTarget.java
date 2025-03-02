package com.vishal.hashing;

import java.util.HashSet;

public class MergeTripletToFormTarget {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        HashSet<Integer> goodTriplets = new HashSet<>();
        for(int[] triplet: triplets){
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]){
                continue;
            }
            if(triplet[0] == target[0]){
                goodTriplets.add(0);
            }
            if(triplet[1] == target[1]){
                goodTriplets.add(1);
            }
            if(triplet[2] == target[2]){
                goodTriplets.add(2);
            }
        }
        return goodTriplets.size() == 3;
    }

}
