package com.vishal.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefixString {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("cfg", "drive", "cadence", "cafg", "cosmos"));
        String inputPrefix = "cat";
        int[] prefixIndices = getPrefixIndices(words, inputPrefix);
        System.out.println("first index -> " + prefixIndices[0] + ", second index -> "+ prefixIndices[1]);
    }

    private static int[] getPrefixIndices(List<String> words, String inputPrefix) {

        int[] result = new int[2];
        int matchCount = 0;
        boolean isFirstMatch = true;

        for(int i = 0; i < words.size(); i++){
            String currWord = words.get(i);
            for(int j = 0; j < inputPrefix.length();){
                if(currWord.charAt(j) == inputPrefix.charAt(j)){
                    j++;
                    if(j == inputPrefix.length()){
                        matchCount++;
                        if(isFirstMatch) {
                            result[0] = i;
                            isFirstMatch = false;
                        }
                        result[1] = i;
                    }
                }else{
                    break;
                }
            }
        }

        if(matchCount == 0){
            Arrays.fill(result, -1);
        }else if(matchCount == 1){
            result[1] = result[0];
        }
        return result;
    }

}
