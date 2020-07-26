package com.vishal.goldmansachs;

public class RunningLength {

	public static void main(String[] args) {
		String input = "aaaabbaaccde";
		System.out.println(getMaxRepeatingSubStr(input));
		System.out.println(getEncoding(input));
	}
	
	private static String getMaxRepeatingSubStr(String str) {
		String outStr = "";
		int start = 0;
		int end = 0;
		int prev = '\0';
		int max = 0;
		int runningLength = 0;
		for(int i = 0; i < str.length(); i++) {
			if(prev == '\0' || str.charAt(i) == prev) {
				runningLength++;
				prev = str.charAt(i);
				end++;
				if(runningLength > max) {
					max = runningLength;
					outStr = str.substring(start, end);
				}
			}else {
				runningLength = 1;
				prev = str.charAt(i);
				start = i;
				end = start + 1;
			}
		}
		return outStr;
	}
	
	private static String getEncoding(String str) {
		int length = 0;
		char prev = '\0';
		StringBuilder outStr = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			if(prev == '\0' || str.charAt(i) == prev) {
				length++;
				prev = str.charAt(i);
			}else {
				outStr.append(prev).append(length);
				prev = str.charAt(i);
				length = 1;
			}
		}
		outStr.append(prev).append(length);
		return outStr.toString();
	}

}
