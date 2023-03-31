package com.vishal.windowsliding;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i)-'a']++;
        }
        int left = 0;
        int right = 0;
        while(right < s2.length()){
            //expand
            char ch = s2.charAt(right++);
            s2Count[ch-'a']++;
            //shrink
            while((right - left) > s1.length()){
                char leftChar = s2.charAt(left++);
                s2Count[leftChar-'a']--;
            }
            if(isSubset(s1Count, s2Count)){
                return true;
            }
        }
        return false;
    }

    private boolean isSubset(int[] s1Count, int[] s2Count){
        for(int i = 0; i < 26; i++){
            if(s2Count[i] < s1Count[i]){
                return false;
            }
        }
        return true;
    }

}
