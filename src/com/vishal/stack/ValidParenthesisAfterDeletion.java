package com.vishal.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParenthesisAfterDeletion {

    public String minRemoveToMakeValid(String s) {
        Set<Integer> unwantedChars = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    unwantedChars.add(i);
                }
            }
        }
        while(!stack.isEmpty()){
            unwantedChars.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!unwantedChars.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
