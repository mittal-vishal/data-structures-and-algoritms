package com.vishal.bitwise;

public class CountBits {

	public static void main(String[] args) {
		System.out.println(countSetBits(5));
	}
	
	// Function to count number of set bits
    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            n = (n & (n-1));
            count++;
        }
		return count;   
    }

}
