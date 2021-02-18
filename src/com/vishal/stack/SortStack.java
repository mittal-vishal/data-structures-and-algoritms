package com.vishal.stack;

import java.util.Stack;

public class SortStack {

    public static Stack<Integer> sort(Stack<Integer> s){
        Stack<Integer> tempStack = new Stack<>();
        int temp;
        while(!s.isEmpty()){
            temp = s.pop();
            if(tempStack.isEmpty() || temp >= tempStack.peek()){
                tempStack.push(temp);
            }else{
                while((!tempStack.isEmpty()) && temp < tempStack.peek()){
                    s.push(tempStack.pop());
                }
                tempStack.push(temp);
            }
        }
        while(!tempStack.isEmpty()){
            s.push(tempStack.pop());
        }
        return s;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(14);
        stack.add(2);
        stack.add(20);
        stack = sort(stack);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}
