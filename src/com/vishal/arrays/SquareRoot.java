package com.vishal.arrays;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(find(16));
	}

	private static int find(int num) {
		for(int i = 1; i*i <= num; i++) {
			if(i*i == num || (i*i<num && ((i+1)*(i+1)> num))) {
				return i;
			}
		}
		return -1;
	}

}
