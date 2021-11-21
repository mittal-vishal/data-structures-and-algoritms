package com.vishal.google;

import java.util.Arrays;
import java.util.HashMap;

public class FindOrigArrFromDoubleArr {

    public int[] findOriginalArray(int[] changed) {
        if(changed == null || changed.length == 0 || changed.length % 2 != 0){
            return new int[0];
        }
        Arrays.sort(changed);
        HashMap<Integer, Integer> elementOccurMap = new HashMap<>();
        for(int ele: changed){
            elementOccurMap.put(ele, elementOccurMap.getOrDefault(ele, 0) + 1);
        }
        int[] origArr = new int[changed.length/2];
        int index = 0;
        for(int i = 0; i < changed.length && elementOccurMap.size() > 0; i++){
            if(!elementOccurMap.containsKey(changed[i])){
                continue;
            }
            int currEle = changed[i];
            int doubleEle = currEle*2;
            if(elementOccurMap.get(currEle) > 1){
                elementOccurMap.put(currEle, elementOccurMap.get(currEle) - 1);
            }else{
                elementOccurMap.remove(currEle);
            }
            if(elementOccurMap.containsKey(doubleEle)){
                origArr[index++] = currEle;
                if(elementOccurMap.get(doubleEle) > 1){
                    elementOccurMap.put(doubleEle, elementOccurMap.get(doubleEle) - 1);
                }else{
                    elementOccurMap.remove(doubleEle);
                }
            }else{
                break;
            }
        }
        if(elementOccurMap.size() == 0){
            return origArr;
        }else{
            return new int[0];
        }
    }

}
