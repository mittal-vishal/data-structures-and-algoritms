package com.vishal.bitwise;

public class PowerOfTwoOrNot {

	public static void main(String[] args) {
		System.out.println(find(8));
	}

	private static boolean find(int i) {
		if((i&(i-1)) ==  0) {
			return true;
		}else {
			return false;
		}
	}

}
