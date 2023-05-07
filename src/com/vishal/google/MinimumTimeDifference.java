package com.vishal.google;

import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[60*24];
        for(String timePoint: timePoints){
            String[] timeDimenstions = timePoint.split("\\:");
            int hours = Integer.valueOf(timeDimenstions[0]);
            int mints = Integer.valueOf(timeDimenstions[1]);
            int totalMints = 60 * hours + mints;
            if(minutes[totalMints]){
                return 0;
            }
            minutes[totalMints] = true;
        }
        Integer firstTimeStamp = null;
        Integer prevTimeStamp = null;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < minutes.length; i++){
            if(minutes[i]){
                if(firstTimeStamp == null){
                    firstTimeStamp = i;
                    prevTimeStamp = i;
                }else{
                    result = Math.min(result, Math.min(i-prevTimeStamp, (60*24) - i + prevTimeStamp));
                    prevTimeStamp = i;
                }
            }
        }
        result = Math.min(result, Math.min(prevTimeStamp-firstTimeStamp, (60*24) - prevTimeStamp + firstTimeStamp));
        return result;
    }

}
