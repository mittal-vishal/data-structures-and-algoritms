package com.vishal.matrix;

import java.util.Scanner;

public class SpiralTraversal {

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
		spiral(row, col, matrix);

	}

	static void spiral(int m, int n, int a[][]) {
		if (m != 0) {
			for (int i = 0; i < n; i++) {
				System.out.print(a[0][i] + " ");
				a[0][i] = Integer.MAX_VALUE;
			}

			for (int i = 1; i < m; i++) {
				System.out.print(a[i][n - 1] + " ");
				a[i][n - 1] = Integer.MAX_VALUE;
			}

			for (int i = n - 2; i >= 0; i--) {
				if (m != 1) {
					System.out.print(a[m - 1][i] + " ");
					a[m - 1][i] = Integer.MAX_VALUE;
				}
			}

			for (int i = m - 2; i > 0; i--) {
				if (n != 1) {
					System.out.print(a[i][0] + " ");
					a[i][0] = Integer.MAX_VALUE;
				}
			}

			int rowCount = 0, colCount = 0;

			for (int i = 0; i < m; i++) {
				boolean isValid = false;
				for (int j = 0; j < n; j++) {
					if (a[i][j] != Integer.MAX_VALUE) {
						if(!isValid) {
							colCount = 0;
						}
						colCount++;
						isValid = true;
					}
				}
				if(isValid) {
					rowCount++;
				}
			}
			
			int newArray[][] = new int[rowCount][colCount];

			int k = 0;
			for (int i = 0; i < m; i++) {
				boolean isValid = false;
				int l = 0;
				for (int j = 0; j < n; j++) {
					if (a[i][j] != Integer.MAX_VALUE) {
						newArray[k][l] = a[i][j];
						l++;
						isValid = true;
					}
				}
				if (isValid) {
					k++;
				}
			}

			spiral(rowCount, colCount, newArray);
		}
	}

}
