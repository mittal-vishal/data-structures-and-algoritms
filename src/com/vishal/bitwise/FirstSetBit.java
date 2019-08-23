package com.vishal.bitwise;

public class FirstSetBit {

	public static void main(String[] args) {
		System.out.println(getFirstSetBitPos(12));

	}
	
	public static int getFirstSetBitPos(int n){    
	    int k = 0;
	    while((n << k)> 0){
	        if((n & (1 << k)) != 0){
	            return k+1;
	        }
	        k++;
	    }
	    return 0;     
	}

}
