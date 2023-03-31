package com.vishal.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {

	public static void main(String[] args) {
		String[] words = {"a","banana","app","appl","ap","apply","apple"};
		System.out.println(longestWord(words));
	}

    public static String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        String result = "";
        int maxLength = 0;
        Arrays.sort(words);
        for(String word: words){
            if(word.length() == 1 || set.contains(word.substring(0, word.length()-1))){
                set.add(word);
                if(word.length() > maxLength){
                    maxLength = word.length();
                    result = word;
                }
            }
        }
        return result;
    }

}
