package com.vishal.stack;

import java.util.Stack;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxLen = 0;
        for(String line: lines){
            int level = line.lastIndexOf("\t") + 1;
            while(stack.size() - 1 > level){
                stack.pop();
            }
            int length = stack.peek() + (line.length() - level) + 1;
            stack.push(length);
            if(line.contains(".")){
                maxLen = Math.max(maxLen, length-1);
            }
        }
        return maxLen;
    }

}
