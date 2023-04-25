package com.vishal.dynamicprogramming;

public class Fibonacci {

	public int fib(int n) {
		if(n <= 1){
			return n;
		}
		int prev2 = 0;
		int prev1 = 1;
		for(int i = 2; i <= n; i++){
			int curr = prev1 + prev2;
			prev2 = prev1;
			prev1 = curr;
		}
		return prev1;
	}

	private int fibOptimised(int n) {
		if(n == 0){
			return 0;
		}
		int[][] A = {{1,1},{1,0}};
		int[][] B = {{1,1},{1,0}};
		for(int i = 1; i <= n-2; i++){
			multiply(A, B);
		}
		return A[0][0];
	}

	private void multiply(int[][] A, int[][] B){
		int x = A[0][0]*B[0][0] + A[0][1]*B[1][0];
		int y = A[0][0]*B[0][1] + A[0][1]*B[1][1];
		int z = A[1][0]*B[0][0] + A[1][1]*B[1][0];
		int w = A[1][0]*B[0][1] + A[1][1]*B[1][1];
		A[0][0] = x;
		A[0][1] = y;
		A[1][0] = z;
		A[1][1] = w;
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci.fibOptimised(7));
	}

}
