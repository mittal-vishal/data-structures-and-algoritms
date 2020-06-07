package com.vishal.goldmansachs;

public class MaximumRepeatingCharSequentially {

	public static void main(String[] args) {
		String input = "aaaabbaaccde";
		System.out.println(getMaxRepeatingChar(input));
	}
	
	private static char getMaxRepeatingChar(String str) {
		char returnChar = '\0';
		int runningCount = 0;
		char prev = '\0';
		int max = Integer.MIN_VALUE;
		for(int i = 0; i< str.length(); i++) {
			if(prev == '\0' || prev == str.charAt(i)) {
				prev = str.charAt(i);
				runningCount++;
			}else if(prev != str.charAt(i)) {
				if(runningCount > max) {
					max = runningCount;
					returnChar = prev;
					runningCount = 0;
					prev = '\0';
				}
			}
		}
		return returnChar;
	}

}
