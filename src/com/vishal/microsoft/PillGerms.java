package com.vishal.microsoft;

import java.util.Scanner;

public class PillGerms {

	public static int getTotalGerms(int a[][]) {
		int germsCount = 0;
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++) {
				if (a[row][col] == 'b') {
					if (col > 0) {
						a[row][col - 1] = 'k';
					}
					if (col < a[row].length - 1) {
						a[row][col + 1] = 'k';
					}
					if (row > 0) {
						a[row - 1][col] = 'k';
					}
					if (row < a.length - 1) {
						a[row + 1][col] = 'k';
					}
				}
				if (a[row][col] == 'r') {
					if (col > 0) {
						a[row][col - 1] = 'k';
					}
					if (col < a[row].length - 1) {
						a[row][col + 1] = 'k';
					}
					if (row > 0) {
						a[row - 1][col] = 'k';
					}
					if (row < a.length - 1) {
						a[row + 1][col] = 'k';
					}
					if (row > 0 && col > 0) {
						a[row - 1][col - 1] = 'k';
					}
					if (row < a.length - 1 && col < a[row].length - 1) {
						a[row + 1][col + 1] = 'k';
					}
					if(row < a.length - 1 && col > 0) {
						a[row+1][col-1] = 'k';
					}
					if(row > 0 && col < a[row].length - 1) {
						a[row-1][col+1] = 'k';
					}
				}
			}
		}
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a[row].length; col++) {
				if (a[row][col] == 'x') {
					germsCount++;
				}
			}
		}
		return germsCount;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int a[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.next().charAt(0);
			}
		}
		sc.close();
		System.out.println(getTotalGerms(a));
	}

}
