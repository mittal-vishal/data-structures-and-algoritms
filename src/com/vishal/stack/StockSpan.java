package com.vishal.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		int stock[] = { 100, 80, 60, 70, 60, 75, 85 };
		// 1, 1, 1, 2, 1, 4, 6
		for (int i : find(stock)) {
			System.out.print(i + " ");
		}
	}

	private static List<Integer> find(int[] stock) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> linkedList = new LinkedList<>();
		int span = 0;
		for (int i = 0; i < stock.length; i++) {
			while (!stack.isEmpty() && stock[i] >= stock[stack.peek()]) {
				stack.pop();
			}
			span = stack.isEmpty() ? 1 : i - stack.peek();
			stack.push(i);
			linkedList.add(span);
		}
		return linkedList;
	}

}
