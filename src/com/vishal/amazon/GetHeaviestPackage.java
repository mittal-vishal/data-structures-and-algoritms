package com.vishal.amazon;

public class GetHeaviestPackage {

    public static long getHeaviestPackage(int[] packageWeights) {
        // Write your code here
        long[] weights = new long[packageWeights.length];
        for(int i = 0; i < packageWeights.length; i++){
            weights[i] = packageWeights[i];
        }
        getMax(weights, 0);
        long mergeVal = 0l;
        for(int i = 0; i < weights.length; i++){
            if(weights[i] != Integer.MAX_VALUE){
                mergeVal = Math.max(mergeVal, weights[i]);
            }
        }
        return mergeVal;
    }

    private static void getMax(long[] packageWeights, int idx){
        if(idx >= packageWeights.length - 1){
            return;
        }
        int firstValidWeightIdx = getNext(packageWeights, idx);
        int secondValidWeightIdx = getNext(packageWeights, firstValidWeightIdx + 1);
        if(firstValidWeightIdx < 0 || secondValidWeightIdx < 0 || firstValidWeightIdx >= packageWeights.length || secondValidWeightIdx >= packageWeights.length){
            return;
        }
        if(packageWeights[firstValidWeightIdx] < packageWeights[secondValidWeightIdx]){
            long merge = packageWeights[firstValidWeightIdx] + packageWeights[secondValidWeightIdx];
            packageWeights[firstValidWeightIdx] = Integer.MAX_VALUE;
            packageWeights[secondValidWeightIdx] = merge;
            getMax(packageWeights, idx - 1);
        }else{
            getMax(packageWeights, idx + 1);
        }
    }

    private static int getNext(long[] weights, int i){
        if( i >= 0 && i < weights.length - 1 && weights[i] == Integer.MAX_VALUE){
            return getNext(weights, ++i);
        }else{
            return i;
        }
    }

    public static void main(String[] args) {
        int[] weights = {20,13,8,9};
        System.out.println(GetHeaviestPackage.getHeaviestPackage(weights));
    }

}
