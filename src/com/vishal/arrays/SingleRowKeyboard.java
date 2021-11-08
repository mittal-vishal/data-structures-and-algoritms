package com.vishal.arrays;

public class SingleRowKeyboard {

    public int calculateTime(String keyboard, String word) {
        int[] charIdxArr = new int[26];

        for(int i = 0; i < keyboard.length(); i++){
            char currChar = keyboard.charAt(i);
            charIdxArr[currChar - 'a'] = i;
        }

        int totalTime = 0;
        int prevCharPos = 0;
        for(int i = 0; i < word.length(); i++){
            int currCharPos = charIdxArr[word.charAt(i) - 'a'];
            totalTime += Math.abs(prevCharPos - currCharPos);
            prevCharPos = currCharPos;
        }

        return totalTime;
    }

}
