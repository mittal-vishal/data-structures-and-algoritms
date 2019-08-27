package com.vishal.hackathon;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BitDifference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCount = sc.nextInt();
		for(int k = 0; k < testCount; k++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int a[][] = new int[m][n];
			int b[][] = new int[m][n];
			for (int i = 0; i < m; i++) {
				String colms = sc.next();
				for (int j = 0; j < n; j++) {
					a[i][j] = Character.getNumericValue(colms.charAt(j));
				}
			}
			for (int i = 0; i < m; i++) {
				String colms = sc.next();
				for (int j = 0; j < n; j++) {
					b[i][j] = Character.getNumericValue(colms.charAt(j));
				}
			}
			System.out.println(getBitDiff(a,b));
		}
		sc.close();
	}

	private static int getBitDiff(int[][] a, int[][] b) {
		int count = 0, num = -1;
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(a[i][j] != b[i][j]) {
					if(list.contains(a[i][j]) || list.isEmpty()) {
						list.add(a[i][j]);
					}else {
					    num = a[i][j] == 1 ? 0 : 1;
					    list.remove(list.indexOf(num));
						count++;
					}
				}
			}
		}
		count = list.isEmpty() ? count : -1;
		return count;
	}

}
