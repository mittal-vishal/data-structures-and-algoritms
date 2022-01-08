package com.vishal.recursion;

import java.util.ArrayList;
import java.util.List;

public class LargestTimeWithGivenDigits {

    public String largestTimeFromDigits(int[] arr) {
        List<String> timeList = new ArrayList<>();
        StringBuilder timeStr = new StringBuilder();
        for(int i: arr){
            timeStr.append(i);
        }
        permute("", timeStr.toString(), timeList);
        int maxTime = -1;
        String ans = "";
        for(String time: timeList){
            int hh = Integer.parseInt(time.substring(0, 2));
            int mm = Integer.parseInt(time.substring(2, 4));
            if(hh >= 0 && hh < 24 && mm >= 0 && mm < 60){
                int currTime = (hh * 60) + mm;
                if(currTime > maxTime){
                    maxTime = currTime;
                    ans = time.substring(0, 2) + ":" + time.substring(2, 4);
                }
            }
        }
        return ans;
    }

    private void permute(String sofar, String time, List<String> timeList){
        if(time.length() == 0){
            timeList.add(sofar);
        }
        for(int i = 0; i < time.length(); i++){
            char currChar = time.charAt(i);
            String timeLeft = time.substring(0, i) + time.substring(i + 1);
            permute(sofar + currChar, timeLeft, timeList);
        }
    }

}
