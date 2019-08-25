package com.vishal.matrix;

import java.util.Scanner;

public class SearchInSortedMatrix {

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
		int item = sc.nextInt();
		sc.close();
		System.out.println(find(row, col, matrix, item));
	}

	private static int find(int n1, int m1, int arr1[][], int x) {
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < m1; j++) {
				if(x == arr1[i][j]) {
					return 1;
				}else if((i+1 < n1) && x > arr1[i+1][j]) {
					break;
				}
			}
		}
		return 0;
	}

}
