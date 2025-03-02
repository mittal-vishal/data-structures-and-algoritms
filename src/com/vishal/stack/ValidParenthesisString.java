package com.vishal.stack;

import java.util.Stack;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> astrikStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else if(ch == '*'){
                astrikStack.push(i);
            }else if(ch == ')' && !stack.isEmpty()){
                stack.pop();
            }else if(ch == ')' && stack.isEmpty()){
                if(!astrikStack.isEmpty() && astrikStack.peek() < i){
                    astrikStack.pop();
                }else{
                    return false;
                }
            }
        }
        while(!stack.isEmpty()){
            if(!astrikStack.isEmpty() && stack.peek() < astrikStack.peek()){
                stack.pop();
                astrikStack.pop();
            }else{
                return false;
            }
        }
        return true;
    }

}
