package com.vishal.bitwise;

public class BitSetOrNot {

	public static void main(String[] args) {
		System.out.println(find(4, 2));
	}

	private static String find(int i, int j) {
		if((i & (1 << j)) > 0) {
			return "true";
		}else {
			return "false";
		}
	}

}
