package com.vishal.stack;

import java.util.Stack;

public class ParenthesisChecker {

	public static void main(String[] args) {
		String expr = "[({[([{}])]})]";
		System.out.println(isBalanced(expr));
	}

	private static boolean isBalanced(String expr) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expr.length(); i++) {
			if (expr.charAt(i) == '{' || expr.charAt(i) == '(' || expr.charAt(i) == '[') {
				stack.push(expr.charAt(i));
			} else if (expr.charAt(i) == '}' || expr.charAt(i) == ')' || expr.charAt(i) == ']') {
				if (stack.isEmpty() || (!compare(stack.peek(), expr.charAt(i)))) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

	private static boolean compare(Character peek, char currentChar) {
		if (peek == '(' && currentChar == ')') {
			return true;
		} else if (peek == '{' && currentChar == '}') {
			return true;
		} else if (peek == '[' && currentChar == ']') {
			return true;
		}
		return false;
	}

}
