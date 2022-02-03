package com.vishal.stack;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        int idx = 0;
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int currNum = 0;
        int sign = 1;
        while(idx < n){
            if(Character.isDigit(s.charAt(idx))){
                while(idx < n && Character.isDigit(s.charAt(idx))){
                    currNum = (10 * currNum) + (s.charAt(idx) - '0');
                    idx++;
                }
                idx--;
                currNum = currNum*sign;
                ans += currNum;
                currNum = 0;
                sign = 1;
            }else if(s.charAt(idx) == '+'){
                sign = 1;
            }else if(s.charAt(idx) == '-'){
                sign = -1;
            }else if(s.charAt(idx) == '('){
                stack.push(ans);
                ans = 0;
                stack.push(sign);
                sign = 1;
            }else if(s.charAt(idx) == ')'){
                int prevSign = stack.pop();
                ans *= prevSign;
                int prevAns = stack.pop();
                ans += prevAns;
            }
            idx++;
        }
        return ans;
    }

}
