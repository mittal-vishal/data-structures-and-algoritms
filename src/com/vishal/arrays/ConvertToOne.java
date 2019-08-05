package com.vishal.arrays;

/*You are given a number N. You need to convert it to 1 in minimum number of operations.

The operations allowed are as follows:

If N is even then divide the number by 2.
If N is odd then you can either add 1 to it or subtract 1 from it.
Using the above operations, find the minimum number of operations require to convert N to 1.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains 1 line of input containing N.

Output:
For each testcase, in a new line, print the minimum number of steps required.

Constraints:
1 <= T <= 100
1 <= N <= 107

Examples:
Input:
4
1
2
3
4
Output:
0
1
2
2*/
public class ConvertToOne {

	public static void main(String[] args) {
		System.out.println(convert(111));
	}

	private static int convert(int number) {
		int count = 0;
		if (number == 0 || number == 2) {
			count = 1;
		} else if(number == 1){
			count = 0;
		} else if (number % 2 == 0) {
			count = 1 + convert(number / 2);
		} else if (number % 2 == 1) {
			count = 1 + Math.min(convert(number - 1), convert(number + 1));
		}
		return count;
	}

}
