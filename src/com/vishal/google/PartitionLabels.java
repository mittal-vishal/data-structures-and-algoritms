package com.vishal.google;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        int[] charsIndices = new int[26];
        for(int i = 0; i < s.length(); i++){
            charsIndices[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(charsIndices[currChar-'a'] > i && charsIndices[currChar-'a'] > right){
                right = charsIndices[currChar-'a'];
            }else if(charsIndices[currChar-'a'] < i && i < right){
                continue;
            }else if(charsIndices[currChar-'a'] <= i && i == right){
                partitions.add(right - left + 1);
                left = right + 1;
                right = left;
            }
        }
        return partitions;
    }

}
