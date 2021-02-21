package com.vishal.stack;

import java.util.Stack;

public class SortStack {

    public static Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> tempStack = new Stack<>();
        int temp;
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(tempStack.isEmpty() || temp >= tempStack.peek()){
                tempStack.push(temp);
            }else{
                while((!tempStack.isEmpty()) && temp < tempStack.peek()){
                    stack.push(tempStack.pop());
                }
                tempStack.push(temp);
            }
        }
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return stack;
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
