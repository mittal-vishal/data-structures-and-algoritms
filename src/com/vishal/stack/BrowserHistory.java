package com.vishal.stack;

import java.util.Stack;

public class BrowserHistory {

    private Stack<String> browserStack;
    private Stack<String> tempStack;

    public BrowserHistory(String homepage) {
        browserStack = new Stack<>();
        tempStack = new Stack<>();
        browserStack.push(homepage);
    }

    public void visit(String url) {
        while(!tempStack.isEmpty()){
            tempStack.pop();
        }
        browserStack.push(url);
    }

    public String back(int steps) {
        while(browserStack.size() != 1 && steps > 0){
            tempStack.push(browserStack.pop());
            steps--;
        }
        return !browserStack.isEmpty()? browserStack.peek(): null;
    }

    public String forward(int steps) {
        while(!tempStack.isEmpty() && steps > 0){
            browserStack.push(tempStack.pop());
            steps--;
        }
        return !browserStack.isEmpty()? browserStack.peek(): null;
    }

}
