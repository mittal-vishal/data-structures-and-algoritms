package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class WaysToFormTargetFromDictionary {

    public static void main(String[] args) {
        String[] words = {"acca","bbbb","caca"};
        String target = "aba";
        WaysToFormTargetFromDictionary waysToFormTargetFromDictionary = new WaysToFormTargetFromDictionary();
        System.out.println(waysToFormTargetFromDictionary.numWays(words, target));
    }

    private int MOD = (int)1e9+7;
    private int[][] frequency;

    public int numWays(String[] words, String target) {
        long[][] dp = new long[words[0].length()][target.length()];
        for(int i = 0; i < words[0].length(); i++){
            Arrays.fill(dp[i], -1);
        }
        frequency = new int[26][words[0].length()];
        for(String word: words){
            for(int i = 0; i < word.length(); i++){
                frequency[word.charAt(i)-'a'][i]++;
            }
        }
        return (int)numWays(words, 0, target, 0, dp);
    }

    private long numWays(String[] words, int i, String target, int j, long[][] dp){
        if(j == target.length()){
            return 1;
        }else if(i == words[0].length()){
            return 0;
        }else if(dp[i][j] != -1){
            return dp[i][j];
        }
        long exclude = numWays(words, i+1, target, j, dp);
        long include = frequency[target.charAt(j)-'a'][i] * numWays(words, i+1, target, j+1, dp);
        return dp[i][j] = (include + exclude)%MOD;
    }

}
