package com.vishal.string;

public class PermutationPalindrome {

	public static void main(String[] args) {
		String str = "abb";
		System.out.println(isAnagramPalin(str));
	}

	private static boolean isAnagramPalin(String str) {
		int occur[] = new int[128];
		for(int i =0;i<str.length();i++) {
			occur[str.charAt(i)]++;
		}
		int count = 0;
		for(int i=0;i<128;i++) {
			count += (occur[i] % 2);
		}
		if(count <= 1)
			return true;
		else
			return false;
	}

}
