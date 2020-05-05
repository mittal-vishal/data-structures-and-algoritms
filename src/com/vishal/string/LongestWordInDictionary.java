package com.vishal.string;

import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {

	public static void main(String[] args) {
		String[] words = {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"};
		System.out.println(longestWord(words));
	}
	
	private static String longestWord(String[] words) {
        Set<Character> set = new HashSet<>();
        String str = "";
        int prevChars = words[0].length();
        String resStr = "";
        for(int i = 0; i < words.length; i++){
            str = words[i];
            for(int j = 0; j < str.length(); j++){
                set.add(str.charAt(j));
            }
            if(i>0 && str.length() == words[i-1].length() && str.length() == resStr.length()){
                resStr = resStr.compareTo(str) < 0 ? resStr : str;
            }
            if(set.size() == prevChars + 1 || set.size() == 1){
                prevChars = set.size(); 
                if(str.length() > resStr.length()){
                    resStr = str;
                }else if(str.length() == resStr.length()){
                    resStr = resStr.compareTo(str) < 0 ? resStr : str;
                }
            }else if(set.size() == prevChars && str.length() > resStr.length()){
                resStr = str;
            }
            set.clear();
        }
        return resStr;
    }

}
