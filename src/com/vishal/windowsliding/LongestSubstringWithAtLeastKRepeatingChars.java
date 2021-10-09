package com.vishal.windowsliding;

public class LongestSubstringWithAtLeastKRepeatingChars {

    public int longestSubstring(String s, int k) {
        int totalUniqueChars = getUniqueCharsCount(s);
        int longestLen = 0;
        for(int i = 1; i <= totalUniqueChars; i++){
            int possibleAns = getLongestSubstring(s, i, k);
            if(possibleAns > longestLen){
                longestLen = possibleAns;
            }
        }
        return longestLen;
    }

    private int getLongestSubstring(String s, int uniqueCountPossible, int k){
        int left = 0;
        int right = 0;
        int[] charArr = new int[26];
        int uniqueCount = 0;
        int kCount = 0;
        int maxLength = 0;
        while(right < s.length()){
            //Expand the window until cond satisfies
            if(uniqueCount <= uniqueCountPossible){
                char currentChar = s.charAt(right++);
                charArr[currentChar-'a']++;
                if(charArr[currentChar-'a'] == 1){
                    uniqueCount++;
                }
                if(charArr[currentChar-'a'] == k){
                    kCount++;
                }
            }
            //Shrink the window untill cond violates
            if(uniqueCount > uniqueCountPossible){
                char removeChar = s.charAt(left++);
                if(charArr[removeChar-'a'] == k){
                    kCount--;
                }
                if(charArr[removeChar-'a'] == 1){
                    uniqueCount--;
                }
                charArr[removeChar-'a']--;
            }
            //Evaluate answer
            if(uniqueCount == uniqueCountPossible && kCount == uniqueCount){
                maxLength = Math.max(maxLength, (right-left));
            }
        }
        return maxLength;
    }

    private int getUniqueCharsCount(String s){
        int[] chars = new int[26];
        for(int i = 0; i < s.length(); i++){
            chars[s.charAt(i) - 'a']++;
        }
        int uniqueCount = 0;
        for(int i = 0; i < 26; i++){
            if(chars[i] != 0){
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingChars repeatingChars = new LongestSubstringWithAtLeastKRepeatingChars();
        String s = "ababbbc";
        int max = repeatingChars.longestSubstring(s, 2);
        System.out.print(max);
    }

}
