package com.vishal.bitwise;

public class SuperSet {

	public static void main(String[] args) {
		String str = "abc";
		find(str);
	}

	private static void find(String str) {
		int count = 1 << str.length();
		for(int i=0;i<count;i++) {
			for(int j = 0; j< str.length(); j++) {
				if((i & (1 << j)) > 0) {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println();
		}
	}

}
