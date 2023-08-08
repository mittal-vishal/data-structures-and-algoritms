package com.vishal.arrays;

public class MinPenaltyForShop {

    public int bestClosingTime(String customers) {
        int currPenalty = 0;
        for(int i = 0; i < customers.length(); i++){
            if(customers.charAt(i) == 'Y'){
                currPenalty++;
            }
        }
        int minPenalty = currPenalty;
        int result = 0;
        for(int i = 0; i < customers.length(); i++){
            if(customers.charAt(i) == 'Y'){
                currPenalty--;
            }else{
                currPenalty++;
            }
            if(currPenalty < minPenalty){
                minPenalty = currPenalty;
                result = i+1;
            }
        }
        return result;
    }

}
