package com.vishal.recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberPermutation {

	public List<String> letterCombinations(String digits) {
		List<String> resList = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return resList;
		}
		String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		permute(resList, digits, "", 0, mapping);
		return resList;
	}

	private void permute(List<String> resList, String digits, String curr, int index, String[] mapping) {
		if (index == digits.length()) {
			resList.add(curr);
			return;
		}
		String str = mapping[digits.charAt(index) - '0'];
		for (int i = 0; i < str.length(); i++) {
			permute(resList, digits, curr + str.charAt(i), index + 1, mapping);
		}
	}

}
