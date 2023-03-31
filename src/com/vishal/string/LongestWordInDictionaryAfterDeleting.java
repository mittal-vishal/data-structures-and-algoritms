package com.vishal.string;

import java.util.List;

public class LongestWordInDictionaryAfterDeleting {

	public String findLongestWord(String s, List<String> dictionary) {
		int maxLen = 0;
		String result = "";
		for(String dicWord: dictionary){
			if(isExist(s, dicWord)){
				if(dicWord.length() > maxLen){
					maxLen = dicWord.length();
					result = dicWord;
				}else if(dicWord.length() == maxLen){
					if(dicWord.compareTo(result) < 0){
						result = dicWord;
					}
				}
			}
		}
		return result;
	}

	private boolean isExist(String s, String dicWord){
		int i = 0;
		int j = 0;
		while(i < s.length() && j < dicWord.length()){
			if(s.charAt(i) == dicWord.charAt(j)){
				i++;
				j++;
			}else{
				i++;
			}
		}
		if(j == dicWord.length()){
			return true;
		}else{
			return false;
		}
	}

}
