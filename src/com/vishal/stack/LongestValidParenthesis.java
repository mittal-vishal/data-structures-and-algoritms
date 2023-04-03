package com.vishal.stack;

import java.util.Stack;

public class LongestValidParenthesis {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(())"));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int longestLen = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    int currLength = i - stack.peek();
                    longestLen = Math.max(longestLen, currLength);
                }
            }
        }
        return longestLen;
    }

}
