package com.vishal.stack;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirPathArr = path.split("/");
        for(String dirPath: dirPathArr){
            if(dirPath.length() != 0){
                switch(dirPath){
                    case "..":
                        if(!stack.isEmpty()){
                            stack.pop();
                        }
                        break;
                    case ".":
                        break;
                    default:
                        stack.push(dirPath);
                }
            }
        }
        StringBuilder cononicalPath = new StringBuilder();
        for(String dirPath: stack){
            cononicalPath.append("/").append(dirPath);
        }
        if(cononicalPath.length() == 0){
            cononicalPath.append("/");
        }
        return cononicalPath.toString();
    }

}
