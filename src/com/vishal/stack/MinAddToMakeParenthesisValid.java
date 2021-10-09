package com.vishal.stack;

import java.util.Stack;

public class MinAddToMakeParenthesisValid {

    public int minAddToMakeValid(String s) {
        int unwanted = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else if(s.charAt(i) == ')' && !stack.isEmpty()){
                stack.pop();
            }else{
                unwanted++;
            }
        }
        unwanted += stack.size();
        return unwanted;
    }

}
