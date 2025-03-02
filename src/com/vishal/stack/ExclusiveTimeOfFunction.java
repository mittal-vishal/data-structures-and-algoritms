package com.vishal.stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunction {

    static class Function{
        int id;
        int executionTime;
        int childExecutionTime;
        public Function(int id, int executionTime){
            this.id = id;
            this.executionTime = executionTime;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exclusiveTimes = new int[n];
        Stack<Function> stack = new Stack<>();
        for(String log: logs){
            String[] logInfo = log.split(":");
            int id = Integer.valueOf(logInfo[0]);
            boolean isStart = logInfo[1].equals("start") ? true : false;
            int currExecutionTime = Integer.valueOf(logInfo[2]);
            if(isStart){
                stack.push(new Function(id, currExecutionTime));
            }else{
                Function prev = stack.pop();
                int totalTime = (currExecutionTime - prev.executionTime + 1) - prev.childExecutionTime;
                exclusiveTimes[id] += totalTime;
                if(!stack.isEmpty()){
                    stack.peek().childExecutionTime += currExecutionTime - prev.executionTime + 1;
                }
            }
        }
        return exclusiveTimes;
    }

}
