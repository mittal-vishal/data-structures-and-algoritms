package com.vishal.recursion;

import java.util.List;

public class JosephProblem {
	
	public static int joseph(List<Integer> arrayList, int n, int k) {
		if(n == 1) {
			return 0;
		}else {
			return (joseph(arrayList, n-1, k)+k)%n;
		}
	}
}
