package com.vishal.stack;

import java.util.Stack;

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {
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
