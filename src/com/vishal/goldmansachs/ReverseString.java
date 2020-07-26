package com.vishal.goldmansachs;

import java.util.Scanner;

public class ReverseString {
	
	public static void main (String[] args)
	 {
	     Scanner sc = new Scanner(System.in);
	     int t = sc.nextInt();
	     for(int i = 0 ;i < t; i++){
	         String input = sc.next();
	         System.out.println(reverse(input));
	     }
	     sc.close();
	 }
	 private static String reverse(String input){
	     char[] inputArray = input.toCharArray();
	     int n = inputArray.length;
	     char temp = '\0';
	     for(int i = 0; i < (n/2); i++){
	         temp = inputArray[i];
	         inputArray[i] = inputArray[n-1-i];
	         inputArray[n-1-i] = temp;
	     }
	     return String.valueOf(inputArray);
	 }
	
}
