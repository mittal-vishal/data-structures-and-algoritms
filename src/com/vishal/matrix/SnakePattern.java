package com.vishal.matrix;

import java.util.Scanner;

public class SnakePattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int matrix[][] = new int[row][col];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		sc.close();
		find(matrix);
	}

	private static void find(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (i % 2 == 0) {
					System.out.print(a[i][j] + " ");
				} else {
					System.out.print(a[i][a[i].length - 1 - j] + " ");
				}
			}
		}
	}

}
