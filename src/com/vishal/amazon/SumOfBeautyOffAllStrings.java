package com.vishal.amazon;

public class SumOfBeautyOffAllStrings {

    public int beautySum(String s) {
        int totalBeauty = 0;
        for(int i = 0; i < s.length(); i++){
            int[] bucket = new int[26];
            for(int j = i; j < s.length(); j++){
                bucket[s.charAt(j) - 'a']++;
                int beauty = getBeauty(bucket);
                totalBeauty += beauty;
            }
        }
        return totalBeauty;
    }

    private int getBeauty(int[] bucket){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 26; i++){
            if(bucket[i] == 0){
                continue;
            }
            min = Math.min(min, bucket[i]);
            max = Math.max(max, bucket[i]);
        }
        return max-min;
    }

}
