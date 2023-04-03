package com.vishal.stack;

import java.util.Stack;

public class BasicCalculatorII {

    public int calculate(String s) {
        int index = 0;
        int n = s.length();
        int currNum = 0;
        Stack<Integer> stack = new Stack<>();
        Character sign = '+';
        while(index < n){
            if(Character.isDigit(s.charAt(index))){
                while(index < n && Character.isDigit(s.charAt(index))){
                    currNum = (10 * currNum) + (s.charAt(index)-'0');
                    index++;
                }
                index--;
                if(sign == '+'){
                    stack.push(currNum);
                }else if(sign == '-'){
                    stack.push(-currNum);
                }else if(sign == '*'){
                    int prevNum = stack.pop();
                    stack.push(prevNum*currNum);
                }else if(sign == '/'){
                    int prevNum = stack.pop();
                    stack.push(prevNum/currNum);
                }
            }else if(s.charAt(index) != ' '){
                sign = s.charAt(index);
                currNum = 0;
            }
            index++;
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }

}
