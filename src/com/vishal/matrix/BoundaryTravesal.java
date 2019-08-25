package com.vishal.matrix;

import java.util.Scanner;

public class BoundaryTravesal {

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
		boundaryTraversal(row, col, matrix);

	}
	
	static void boundaryTraversal(int n1, int m1, int a[][])
    {
		for(int i = 0; i < m1; i++){
            System.out.print(a[0][i] + " ");
        }
        
        for(int i = 1; i < n1; i++){
            System.out.print(a[i][m1 - 1] + " ");
        }
        
        for(int i = m1-2; i >= 0 ; i--){
            if(n1 != 1) {
            	System.out.print(a[n1 - 1][i] + " ");
            }
        }
		
        for(int i = n1-2; i > 0 ; i--){
            if(m1 != 1) {
            	System.out.print(a[i][0] + " ");
            }
        }
        
    }

}
