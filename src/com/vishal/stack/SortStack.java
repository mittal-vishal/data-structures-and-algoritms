package com.vishal.stack;

import java.util.Stack;

public class SortStack {

    private void sortStack(Stack<Integer> s){
        if(s.size() == 1){
            return;
        }
        int top = s.pop();
        sortStack(s);
        insert(s, top);
    }

    private void insert(Stack<Integer> s, int element){
        if(s.isEmpty() || element >= s.peek()){
            s.push(element);
            return;
        }
        int popped = s.pop();
        insert(s, element);
        s.push(popped);
    }

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
