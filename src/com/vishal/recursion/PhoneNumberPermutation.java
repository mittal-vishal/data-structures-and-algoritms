package com.vishal.recursion;

import java.util.*;

public class PhoneNumberPermutation {

	public List<String> letterCombinations(String digits) {
		Map<Character, String> letters = Map.of(
				'2', "abc", '3', "def", '4', "ghi", '5', "jkl",
				'6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
		List<String> result = new ArrayList<>();
		if(digits.length() == 0){
			return result;
		}
		dfs(digits, new StringBuilder(), 0, result, letters);
		return result;
	}

	private void dfs(String digits, StringBuilder curr, int index, List<String> result, Map<Character, String> letters){
		if(index == digits.length()){
			result.add(curr.toString());
			return;
		}
		String str = letters.get(digits.charAt(index));
		for(int i = 0; i < str.length(); i++){
			curr.append(str.charAt(i));
			dfs(digits, curr, index + 1, result, letters);
			curr.deleteCharAt(curr.length() - 1);
		}
	}

}
