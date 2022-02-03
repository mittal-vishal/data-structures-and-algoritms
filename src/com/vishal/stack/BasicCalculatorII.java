package com.vishal.stack;

import java.util.Stack;

public class BasicCalculatorII {

    public int calculate(String s) {
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int currNum = 0;
        char prevSign = '+';
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                currNum = (10 * currNum) + (s.charAt(idx) - '0');
            }
            if(isOperator(s.charAt(idx)) || idx == s.length() - 1){
                if(prevSign == '+'){
                    stack.push(currNum);
                }else if(prevSign == '-'){
                    stack.push(-currNum);
                }else if(prevSign == '*'){
                    int top = stack.pop();
                    stack.push(top*currNum);
                }else if(prevSign == '/'){
                    int top = stack.pop();
                    stack.push(top/currNum);
                }
                currNum = 0;
                prevSign = s.charAt(idx);
            }
            idx++;
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }

    private boolean isOperator(char ch){
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            return true;
        }
        return false;
    }

}
