package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutationII {

    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> occurances = new HashMap<>();
        //store the occurances
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            occurances.put(ch, occurances.getOrDefault(ch, 0) + 1);
        }
        //iterate the occurances, count and get odd character, and count length of half of the occurances
        int oddLengthChars = 0;
        Character oddChar = null;
        int permuteLength = 0;
        for(char ch: occurances.keySet()){
            int freq = occurances.get(ch);
            if(freq % 2 == 1){
                oddLengthChars++;
                oddChar = ch;
            }
            occurances.put(ch, freq / 2);
            permuteLength += freq/2;
        }
        if(oddLengthChars > 1){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        //generate permutations, and prepare permutation by appending reverse of permute string
        permute(0, permuteLength, "", result, occurances, oddChar);
        return result;
    }

    private void permute(int beg, int end, String ans, List<String> result, Map<Character, Integer> occurances, Character oddChar){
        if(beg == end){
            //prepare reverse
            String rev = "";
            for(int i = end - 1; i >= 0; i--){
                rev += ans.charAt(i);
            }
            if(oddChar != null){
                ans = ans + oddChar + rev;
            }else{
                ans = ans + rev;
            }
            result.add(ans);
            return;
        }
        for(char ch: occurances.keySet()){
            int freq = occurances.get(ch);
            if(freq > 0){
                occurances.put(ch, freq - 1);
                permute(beg + 1, end, ans + ch, result, occurances, oddChar);
                occurances.put(ch, freq);
            }
        }
    }

}
