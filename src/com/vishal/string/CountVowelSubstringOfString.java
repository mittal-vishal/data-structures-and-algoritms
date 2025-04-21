package com.vishal.string;

import java.util.HashSet;

public class CountVowelSubstringOfString {

    public int countVowelSubstrings(String word) {
        int n = word.length();
        HashSet<Character> vowels = new HashSet<>();
        int result = 0;
        for(int i = 0; i < n-4; i++){
            vowels.clear();
            for(int j = i; j < n; j++){
                char ch = word.charAt(j);
                if(isVowel(ch)){
                    vowels.add(ch);
                }else{
                    break;
                }
                if(vowels.size() == 5){
                    result++;
                }
            }
        }
        return result;
    }
    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }else{
            return false;
        }
    }

}
