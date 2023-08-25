package com.vishal.windowsliding;

import java.util.HashMap;

public class MaximizeConfusionInExam {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        HashMap<Character,Integer> charOccurance = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = answerKey.length();
        int result = 1;
        while(right < n){
            //expand
            char currChar = answerKey.charAt(right++);
            charOccurance.put(currChar, charOccurance.getOrDefault(currChar,0) + 1);
            int trueOccurance = charOccurance.getOrDefault('T' ,0);
            int falseOccurance = charOccurance.getOrDefault('F' ,0);
            int diff = Math.min(trueOccurance, falseOccurance);
            while(diff > k){
                char removeChar = answerKey.charAt(left++);
                charOccurance.put(removeChar, charOccurance.get(removeChar) - 1);
                diff = Math.min(charOccurance.getOrDefault('T' ,0), charOccurance.getOrDefault('F' ,0));
            }
            result = Math.max(result, right - left);
        }

        return result;
    }

}
