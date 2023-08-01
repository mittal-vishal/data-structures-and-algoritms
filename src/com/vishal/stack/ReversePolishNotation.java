package com.vishal.stack;

import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = getArithmaticResult(num1, num2, token);
                stack.push(result);
            }else{
                int num = Integer.valueOf(token);
                stack.push(num);
            }
        }
        return stack.pop();
    }

    private int getArithmaticResult(int num1, int num2, String token){
        int result = 0;
        switch(token){
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            case "/":
                result = num1/num2;
                break;
            default:
                result = num1*num2;
                break;
        }
        return result;
    }

}
