package com.vishal.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumSplitOfPositiveEvenNum {

    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum % 2 == 1){
            return new ArrayList<>();
        }
        long remainingNum = finalSum;
        long currNum = 2;
        List<Long> result = new ArrayList<>();
        while(currNum <= remainingNum){
            result.add(currNum);
            remainingNum -= currNum;
            currNum += 2;
        }
        long last = result.remove(result.size()-1);
        result.add(last + remainingNum);
        return result;
    }

}
