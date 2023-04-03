package com.vishal.stack;

import java.util.Stack;

public class RemoveKDigit {

    public String removeKDigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        for(; i < num.length(); i++){
            char curr = num.charAt(i);
            while(!stack.isEmpty() && curr < stack.peek() && k > 0){
                stack.pop();
                k--;
            }
            if(!stack.isEmpty() || (stack.isEmpty() && curr != '0')){
                stack.push(curr);
            }
        }
        while(!stack.isEmpty() && k-- > 0){
            stack.pop();
        }
        String result = "";
        if(i < num.length()){
            result = num.substring(i);
        }
        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result != "" ? result: "0";
    }

}
