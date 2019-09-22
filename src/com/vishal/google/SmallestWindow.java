/*Given a string S and text T. Output the smallest window in the string S having all characters of the text T. Both the string S and text T contains lowercase english alphabets.

Input Format:
First line of the input contains an integer T, denoting the number of test cases. Then T test case follows. Each test contains 2 lines having a string S and next line contains text T.

Output Format:
Output the smallest window of the string containing all the characters of the text. If such window doesn`t exist or this task can not be done then print -1.

Your Task:
This is a function problem. You only need to complete the function smallestWindow that returns smallest window of the string containing all the characters of the text. Else return "-1".

Input:
2
timetopractice
toc
zoomlazapzo
oza

Output:
toprac
apzo

*/

package com.vishal.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SmallestWindow {
	
	private static Set<Character> set = new HashSet<>();
	private static Map<Integer, Character> map = new HashMap<>();
	private static int min = Integer.MAX_VALUE;
	private static int outputFirst = 0;
	private static int outputLast = 0;
	
	public static void main(String[] args) {
		String str = "zoomlazapzo";
		String pattern = "oza";
		find(str, pattern, 0, 0, 0, 0);
		if(min != Integer.MAX_VALUE) {
			System.out.println(str.substring(outputFirst, outputLast));
		}else {
			System.out.println("-1");
		}
	}

	private static void find(String str, String pattern, int first, int last, int i, int j) {
		if(i < str.length() && j < pattern.length()) {
			if(set.contains(str.charAt(i))) {
				map.put(i, str.charAt(i));
			}
			if(str.charAt(i) == pattern.charAt(j)) {
				set.add(str.charAt(i));
				if(j == 0) {
					first = i;
				}
				if(j == pattern.length() - 1) {
					last = i;
					if(last - first + 1 < min) {
						min = last - first + 1;
						outputFirst = first;
						outputLast = last + 1;
					}
				}
				find(str, pattern, first, last, i + 1, j + 1);
			}else {
				find(str, pattern, first, last, i + 1, j);
			}
		}
		for(Entry<Integer, Character> entry : map.entrySet()) {
			set = new HashSet<>();
			map = new HashMap<>();
			find(str, pattern, 0, 0, entry.getKey(), 0);
		}
	}

}
