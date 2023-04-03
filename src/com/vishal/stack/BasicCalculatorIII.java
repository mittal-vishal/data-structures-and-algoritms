package com.vishal.stack;

import java.util.Stack;

public class BasicCalculatorIII {

    class Pair{
        private Stack<Integer> stack;
        private Character sign;
        public Pair(Stack<Integer> stack, Character sign){
            this.stack = stack;
            this.sign = sign;
        }
    }

    public int calculate(String s) {
        int index = 0;
        int n = s.length();
        int currNum = 0;
        Stack<Integer> stack = new Stack<>();
        Character sign = '+';
        Stack<Pair> parenthesisStack = new Stack<>();
        while(index < n){
            if(Character.isDigit(s.charAt(index))){
                while(index < n && Character.isDigit(s.charAt(index))){
                    currNum = (10 * currNum) + (s.charAt(index)-'0');
                    index++;
                }
                index--;
                pushIntoStack(stack, currNum, sign);
            }else if(s.charAt(index) != ' ' && s.charAt(index) != '(' && s.charAt(index) != ')'){
                sign = s.charAt(index);
                currNum = 0;
            }else if(s.charAt(index) == '('){
                parenthesisStack.push(new Pair(stack, sign));
                stack = new Stack<>();
                sign = '+';
            }else if(s.charAt(index) == ')'){
                int currVal = 0;
                while(!stack.isEmpty()){
                    currVal += stack.pop();
                }
                Pair popped = parenthesisStack.pop();
                stack = popped.stack;
                sign = popped.sign;
                pushIntoStack(stack, currVal, sign);
            }
            index++;
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }

    private void pushIntoStack(Stack<Integer> stack, int currNum, Character prevSign){
        if(prevSign == '+'){
            stack.push(currNum);
        }else if(prevSign == '-'){
            stack.push(-currNum);
        }else if(prevSign == '*'){
            int prevNum = stack.pop();
            stack.push(prevNum*currNum);
        }else if(prevSign == '/'){
            int prevNum = stack.pop();
            stack.push(prevNum/currNum);
        }
    }

    private boolean isOperator(char ch){
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            return true;
        }
        return false;
    }

}
