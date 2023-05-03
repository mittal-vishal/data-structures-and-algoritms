package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParenthesis {

    public List<String> removeInvalidParentheses(String s) {
        int allowedMinRemovals = getMinRemoval(s);
        List<String> result = new ArrayList<>();
        HashSet<String> uniqueValidAnswer = new HashSet<>();
        backtrack(s, allowedMinRemovals, result, uniqueValidAnswer);
        return result;
    }

    private void backtrack(String s, int allowedMinRemovals, List<String> result, HashSet<String> uniqueValidAnswer){
        if(uniqueValidAnswer.contains(s)){
            return;
        }
        uniqueValidAnswer.add(s);
        if(allowedMinRemovals == 0){
            if(getMinRemoval(s) == 0){
                result.add(s);
            }
            return;
        }
        for(int i = 0; i < s.length(); i++){
            String left  = s.substring(0, i);
            String right = s.substring(i+1);
            String removeCharStr = left+right;
            backtrack(left+right, allowedMinRemovals-1, result, uniqueValidAnswer);
        }
    }

    private int getMinRemoval(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }else if(ch == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else if(ch == ')' && ((!stack.isEmpty() && stack.peek() == ')') || stack.isEmpty())){
                stack.push(')');
            }
        }
        return stack.size();
    }

}
