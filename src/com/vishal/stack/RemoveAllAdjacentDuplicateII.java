package com.vishal.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicateII {

    static class Element{
        char ch;
        int occurance;
        public Element(char ch, int occurance){
            this.ch = ch;
            this.occurance = occurance;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Element> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(stack.isEmpty() || stack.peek().ch != ch){
                stack.push(new Element(ch, 1));
            }else if(!stack.isEmpty()){
                if(++stack.peek().occurance == k){
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Element curr = stack.pop();
            for(int i = 0; i < curr.occurance; i++){
                sb.append(curr.ch);
            }
        }
        return sb.reverse().toString();
    }

}
