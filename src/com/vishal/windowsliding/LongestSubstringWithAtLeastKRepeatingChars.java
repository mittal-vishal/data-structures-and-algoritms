package com.vishal.windowsliding;

public class LongestSubstringWithAtLeastKRepeatingChars {

    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0 || k == 0){
            return 0;
        }

        int uniqueCount = getUniqueCharsCount(s);
        int max = Integer.MIN_VALUE;
        int[] charArr;

        for(int i = 1; i <= uniqueCount; i++){
            int left = 0;
            int right = 0;
            charArr = new int[26];
            int unique = 0;
            int kCharCount = 0;
            while(right < s.length()){
                //Expand the window
                if(unique <= i){
                    char currChar = s.charAt(right++);
                    charArr[currChar-'a']++;
                    if(charArr[currChar-'a'] == 1){
                        unique++;
                    }
                    if(charArr[currChar-'a'] == k){
                        kCharCount++;
                    }
                }
                //Shrink the window
                if(unique > i){
                    char leftChar = s.charAt(left++);
                    if(charArr[leftChar-'a'] == 1){
                        unique--;
                    }
                    if(charArr[leftChar-'a'] == k){
                        kCharCount--;
                    }
                    charArr[leftChar-'a']--;
                }
                if(i == unique && unique == kCharCount){
                    max = Math.max(max, right-left);
                }
            }
        }

        return max != Integer.MIN_VALUE ? max: 0;
    }

    private int getUniqueCharsCount(String s){
        int[] charArr = new int[26];
        for(char ch: s.toCharArray()){
            charArr[ch-'a']++;
        }
        int count = 0;
        for(int i: charArr){
            if(i != 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingChars repeatingChars = new LongestSubstringWithAtLeastKRepeatingChars();
        String s = "ababbbc";
        int max = repeatingChars.longestSubstring(s, 2);
        System.out.print(max);
    }

}
