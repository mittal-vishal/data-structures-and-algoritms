package com.vishal.collections;

import java.util.Iterator;
import java.util.Stack;

public class StackCollection {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("vishal");
		stack.push("mittal");
		Iterator<String> itr = stack.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("peek::" + stack.peek());
		stack.pop();
		System.out.println(stack);
	}

}
