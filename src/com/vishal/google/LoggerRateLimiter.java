package com.vishal.google;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    /** Initialize your data structure here. */
    Map<String, Integer> loggerMap;
    public LoggerRateLimiter() {
        loggerMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!loggerMap.containsKey(message)){
            loggerMap.put(message, timestamp);
            return true;
        }else{
            int prevTime = loggerMap.get(message);
            if(timestamp >= (prevTime + 10)){
                loggerMap.put(message, timestamp);
                return true;
            }else{
                return false;
            }
        }
    }

}
