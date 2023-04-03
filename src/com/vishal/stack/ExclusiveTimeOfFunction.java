package com.vishal.stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunction {

    class Log{
        int id;
        boolean isStart;
        int ts;
        public Log(String[] logs){
            this.id = Integer.valueOf(logs[0]);
            this.isStart = logs[1].equals("start");
            this.ts = Integer.valueOf(logs[2]);
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        Stack<Log> stack = new Stack<>();
        int prevLogTime = 0;
        for(String log: logs){
            Log currentLog = new Log(log.split(":"));
            if(currentLog.isStart){
                if(!stack.isEmpty()){
                    Log prevLog = stack.peek();
                    time[prevLog.id] += currentLog.ts - prevLogTime;
                }
                prevLogTime = currentLog.ts;
                stack.push(currentLog);
            }else{
                time[currentLog.id] += currentLog.ts - prevLogTime + 1;
                prevLogTime = currentLog.ts + 1;
                stack.pop();
            }
        }
        return time;
    }

}
