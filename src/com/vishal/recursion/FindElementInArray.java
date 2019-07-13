package com.vishal.recursion;

public class FindElementInArray {
	
	public static boolean find(int[] array, int beg, int x){
		int index = beg;
		if(index == array.length) {
			return false;
		}else if(x == array[index]) {
			return true;
		}else {
			return find(array, ++index, x);
		}
	}

}
