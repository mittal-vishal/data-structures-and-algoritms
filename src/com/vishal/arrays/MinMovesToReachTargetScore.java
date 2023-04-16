package com.vishal.arrays;

public class MinMovesToReachTargetScore {

    public int minMoves(int target, int maxDoubles) {
        int result = 0;
        while(target != 1){
            if(maxDoubles > 0){
                if(target % 2 == 0){
                    target /= 2;
                    maxDoubles--;
                    result++;
                }else{
                    target--;
                    result++;
                }
            }else{
                result += (target-1);
                break;
            }
        }
        return result;
    }

}
