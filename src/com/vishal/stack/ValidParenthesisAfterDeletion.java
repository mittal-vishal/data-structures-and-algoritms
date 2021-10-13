package com.vishal.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParenthesisAfterDeletion {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> deletedCharsSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    deletedCharsSet.add(i);
                }
            }
        }
        while(!stack.isEmpty()){
            deletedCharsSet.add(stack.pop());
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!deletedCharsSet.contains(i)){
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

}
