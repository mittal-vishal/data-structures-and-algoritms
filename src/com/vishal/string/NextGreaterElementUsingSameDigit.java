package com.vishal.string;

public class NextGreaterElementUsingSameDigit {

	public static void main(String[] args) {
		String num = "534976";
		System.out.println(nextGreater(num));
	}

	private static String nextGreater(String num) {
		int min = num.length() - 1;
		int index = -1;
		for (int i = num.length() - 2; i >= 0; i--) {
			if (Integer.valueOf(num.substring(i, i + 1)) < Integer.valueOf(num.substring(i + 1, i + 2))) {
				index = i;
				break;
			}
		}
		for (int i = num.length() - 2; i > index; i--) {
			if (Integer.valueOf(num.substring(i, i + 1)) < Integer.valueOf(num.substring(min, min + 1))) {
				min = i;
			}
		}

		num = swapChar(num, index, min);
		num = sort(num, index + 1, num.length() - 1);
		return num;
	}

	private static String sort(String num, int start, int end) {
		int min = -1;
		for (int i = start; i < end; i++) {
			min = i;
			for (int j = i + 1; j <= end; j++) {
				if (Integer.valueOf(num.substring(j, j + 1)) < Integer.valueOf(num.substring(min, min + 1))) {
					min = j;
				}
			}
			num = swapChar(num, i, min);
		}
		return num;
	}

	private static String swapChar(String num, int i, int min) {
		char[] strCharArray = num.toCharArray();
		char temp = strCharArray[i];
		strCharArray[i] = strCharArray[min];
		strCharArray[min] = temp;
		return String.valueOf(strCharArray);
	}

}
