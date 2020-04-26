package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MaxPointInCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,2,2};
		int k = 2;
		System.out.println(maxScore(a, k));
	}

	public static int maxScore(int[] cardPoints, int k) {
		Map<String, Integer> map = new HashMap<>();
		return maxScore(cardPoints, 0, cardPoints.length - 1, k, map);
	}

	private static int maxScore(int[] cardPoints, int beg, int end, int k, Map<String, Integer> map) {
		if (k == 0) {
			return 0;
		} else if(beg == end){
			return cardPoints[beg];
		}else {
			return Math.max(maxScore(cardPoints, beg + 1, end, k - 1, map) + cardPoints[beg],
					maxScore(cardPoints, beg, end - 1, k - 1, map) + cardPoints[end]);
		}
	}

}
