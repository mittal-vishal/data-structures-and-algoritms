package com.vishal.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> lengthStringMap = new HashMap<>();
        for(int i = 0; i < strings.length; i++){
            String currStr = strings[i];
            String currKey = getHashKey(currStr);
            if(lengthStringMap.containsKey(currKey)){
                List<String> existingList = lengthStringMap.get(currKey);
                existingList.add(currStr);
                lengthStringMap.put(currKey, existingList);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(currStr);
                lengthStringMap.put(currKey, newList);
            }
        }
        List<List<String>> returnList = new ArrayList<>(lengthStringMap.values());
        return returnList;
    }

    private String getHashKey(String currStr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < currStr.length() - 1; i++){
            int asciiDiff = currStr.charAt(i) - currStr.charAt(i+1);
            asciiDiff = asciiDiff >= 0 ? asciiDiff: 26 + asciiDiff;
            sb.append(asciiDiff).append("#");
        }
        return sb.toString();
    }

}
