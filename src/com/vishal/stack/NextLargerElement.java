package com.vishal.stack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NextLargerElement {

	public static void main(String[] args) {
		int elements[] = { 6, 8, 0, 1, 3 };
		// 8,-1,1,3,-1
		for (int i : find(elements)) {
			System.out.print(i + " ");
		}
	}

	private static List<Integer> find(int[] elements) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> linkedList = new LinkedList<>();
		linkedList.add(-1);
		stack.push(elements[elements.length - 1]);
		int item = 0;
		for (int i = elements.length - 2; i >= 0; i--) {
			while (!stack.isEmpty() && elements[i] > stack.peek()) {
				stack.pop();
			}
			item = stack.isEmpty() ? -1 : stack.peek();
			linkedList.add(item);
			stack.push(elements[i]);
		}
		Collections.reverse(linkedList);
		return linkedList;
	}

}
