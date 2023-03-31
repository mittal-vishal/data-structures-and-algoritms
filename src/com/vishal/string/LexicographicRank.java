package com.vishal.string;

import java.util.Arrays;

public class LexicographicRank {

	public static void main(String[] args) {
		String str = "string";
		System.out.println(findRank(str));
	}

	public static long findRank(String s)
	{
		int[] occurances = new int[26];
		int n = s.length();
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			occurances[ch-'a']++;
		}
		for(int i = 1; i < 26; i++){
			occurances[i] += occurances[i-1];
		}
		long result = 1;
		long factorial = getFactorial(s.length());
		for(int i = 0; i < s.length(); i++){
			char currChar = s.charAt(i);
			factorial = factorial/(n-i);
			long currRank = (occurances[currChar-'a'] - 1) * factorial;
			result += currRank;
			for (int j = currChar-'a'; j < 26; j++) {
				occurances[j]--;
			}
		}
		return result;
	}

	private static long getFactorial(int n){
		if(n == 0 || n == 1){
			return 1;
		}else{
			return n * getFactorial(n-1);
		}
	}

}
