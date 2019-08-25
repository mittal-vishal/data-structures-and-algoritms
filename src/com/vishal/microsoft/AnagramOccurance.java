package com.vishal.microsoft;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AnagramOccurance {

	private static Set<String> hashSet = new HashSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			String text = sc.next();
			String word = sc.next();
			System.out.print(findOccurance(text, word));
		}
		sc.close();
	}

	private static int findOccurance(String text, String word) {
		hashSet = permute(word);
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (i + word.length() <= text.length() && hashSet.contains(text.substring(i, i + word.length()))) {
				count++;
			}
		}
		return count;
	}

	private static Set<String> permute(String str) {
		return permute(str, 0, str.length() - 1);
	}

	private static Set<String> permute(String str, int beg, int end) {
		if (beg == end) {
			hashSet.add(str);
		} else {
			for (int i = beg; i <= end; i++) {
				str = swapCharacter(str, beg, i);
				permute(str, beg + 1, end);
			}
		}
		return hashSet;
	}

	private static String swapCharacter(String str, int i, int j) {
		char charArray[] = str.toCharArray();
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}