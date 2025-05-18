package com.vishal.apple;

import java.util.HashSet;

public class CalculateScoreAfterPerformingOperation {

    public long calculateScore(String[] instructions, int[] values) {
        HashSet<Integer> visited = new HashSet<>();
        long score = 0;
        for(int i = 0; i >= 0 && i < values.length; i++){
            String currInstruction = instructions[i];
            int currValue = values[i];
            if(visited.contains(i)){
                break;
            }
            visited.add(i);
            if(currInstruction.equals("add")){
                score += currValue;
            }else{
                i += (currValue-1);
            }
        }
        return score;
    }

}
