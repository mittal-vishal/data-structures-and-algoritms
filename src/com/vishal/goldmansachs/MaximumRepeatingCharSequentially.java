package com.vishal.goldmansachs;

public class MaximumRepeatingCharSequentially {

	public static void main(String[] args) {
		String input = "aaaabbaaccde";
		System.out.println(getMaxRepeatingChar(input));
	}
	
	private static char getMaxRepeatingChar(String str) {
		char maxChar = '\0';
		char prevChar = '\0';
		int maxCount = 0;
		int count = 0;
		for(int i =0;i<str.length();i++) {
			if(prevChar == '\0' || str.charAt(i) == prevChar) {
				count++;
				prevChar = str.charAt(i);
			}else {
				if(count > maxCount) {
					maxChar = prevChar;
					maxCount = count;
				}
				count = 1;
				prevChar = str.charAt(i);
			}
		}
		if(count > maxCount) {
			maxChar = prevChar;
		}
		return maxChar;
	}

}
