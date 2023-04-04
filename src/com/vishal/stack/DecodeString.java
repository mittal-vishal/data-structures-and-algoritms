package com.vishal.stack;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for(int i = 0; i < n; i++){
            char currChar = s.charAt(i);
            if(currChar != ']'){
                stack.push(currChar);
            }else{
                String subStr = "";
                while(!stack.isEmpty() && stack.peek() != '['){
                    subStr = stack.pop() + subStr;
                }
                stack.pop();
                String k = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k =  stack.pop() + k;
                }
                int count = Integer.valueOf(k);
                String decodeSubstr = "";
                for(int j = 0; j < count; j++){
                    decodeSubstr = decodeSubstr + subStr;
                }
                for(int j = 0; j < decodeSubstr.length(); j++){
                    stack.push(decodeSubstr.charAt(j));
                }
            }
        }
        String res = "";
        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
    }

}
