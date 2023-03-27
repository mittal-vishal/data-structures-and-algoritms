package com.vishal.stack;

import java.util.Stack;

public class RemoveBackspaces {

    public boolean backspaceCompare(String s, String t) {
        s = removeBackspaces(s);
        t = removeBackspaces(t);
        return s.equals(t);
    }

    private String removeBackspaces(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i++);
            if (ch != '#') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
