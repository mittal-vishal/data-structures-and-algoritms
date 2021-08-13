package com.vishal.stack;

public class NextGreaterElementUsingSameDigit {

	public int nextGreaterElement(int n) {
		String num = n + "";
		char[] numArr = num.toCharArray();
		int i = numArr.length - 2;

		while(i >= 0 && numArr[i] >= numArr[i+1]){
			i--;
		}
		if(i < 0){
			return -1;
		}

		int j = numArr.length - 1;
		while(j > i && numArr[j] <= numArr[i]){
			j--;
		}
		swapChar(numArr, i, j);
		reverse(numArr, i + 1, numArr.length - 1);
		String ans = String.valueOf(numArr);
		try{
			return Integer.valueOf(ans);
		}catch(Exception e){
			return -1;
		}
	}

	private void swapChar(char[] numArr, int i, int j){
		char temp = numArr[i];
		numArr[i] = numArr[j];
		numArr[j] = temp;
	}

	private void reverse(char[] numArr, int start, int end){
		int i = start;
		int j = end;
		while(i < j){
			swapChar(numArr, i, j);
			i++;
			j--;
		}
	}

}
