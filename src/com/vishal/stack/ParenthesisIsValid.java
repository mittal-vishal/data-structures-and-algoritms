package com.vishal.stack;

import java.util.Stack;

public class ParenthesisIsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else if(s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }else if(s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else{
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}
