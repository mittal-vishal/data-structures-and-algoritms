package com.vishal.stack;

public class NextGreaterElementUsingSameDigit {

	public int nextGreaterElement(int n) {
		String num = String.valueOf(n);
		char[] numArr = num.toCharArray();
		int i = num.length() - 2;
		while(i >= 0 && numArr[i] >= numArr[i+1]){
			i--;
		}
		if(i == -1){
			return -1;
		}
		int j = num.length() - 1;
		while(j > i && numArr[j] <= numArr[i]){
			j--;
		}
		swap(numArr, i, j);
		reverse(numArr, i+1, num.length() - 1);
		String ans = String.valueOf(numArr);
		try{
			return Integer.valueOf(ans);
		}catch(NumberFormatException e){
			return -1;
		}
	}

	private void swap(char[] numArr, int i, int j){
		char temp = numArr[i];
		numArr[i] = numArr[j];
		numArr[j] = temp;
	}

	private void reverse(char[] numArr, int i, int j){
		while(i < j){
			swap(numArr, i, j);
			i++;
			j--;
		}
	}

}
