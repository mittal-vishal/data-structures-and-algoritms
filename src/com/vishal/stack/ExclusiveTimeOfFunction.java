package com.vishal.stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunction {

    static class Log{
        int id;
        int ts;
        int childTs;
        public Log(int id, int ts){
            this.id = id;
            this.ts = ts;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> stack = new Stack<>();
        int[] res = new int[n];
        for(String log: logs){
            String[] logParts = log.split(":");
            int currLogId = Integer.valueOf(logParts[0]);
            int currLogTs = Integer.valueOf(logParts[2]);
            boolean isStart = logParts[1].equals("start")? true: false;
            if(isStart){
                stack.push(new Log(currLogId, currLogTs));
            }else{
                Log prevLog = stack.pop();
                int interval = currLogTs - prevLog.ts + 1;
                int executionTime = interval - prevLog.childTs;
                res[currLogId] += executionTime;
                if(stack.size() > 0){
                    stack.peek().childTs += interval;
                }
            }
        }
        return res;
    }

}
