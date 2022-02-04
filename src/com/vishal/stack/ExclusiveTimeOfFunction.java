package com.vishal.stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunction {

    static class Log{
        int id;
        int start;
        int childTime;
        public Log(int id, int start){
            this.id = id;
            this.start = start;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> logStack = new Stack<>();
        int[] times = new int[n];
        for(int i = 0; i < logs.size(); i++){
            String[] currLog = logs.get(i).split("\\:");
            if(currLog[1].equals("start")){
                Log currentLog = new Log(Integer.parseInt(currLog[0]), Integer.parseInt(currLog[2]));
                logStack.push(currentLog);
            }else{
                Log poppedLog = logStack.pop();
                int interval = Integer.parseInt(currLog[2]) - poppedLog.start + 1;
                times[poppedLog.id] += (interval - poppedLog.childTime);
                if(!logStack.isEmpty()){
                    logStack.peek().childTime += interval;
                }
            }
        }
        return times;
    }

}
