package com.vishal.google;

public class PunishmentNumber {

    public int punishmentNumber(int n) {
        int punishmentNum = 0;
        for(int i = 1; i <= n; i++){
            String partitionStr = "" + i*i;
            if(isPartition(partitionStr, 0, 0, i)){
                punishmentNum += i*i;
            }
        }
        return punishmentNum;
    }

    private boolean isPartition(String s, int index, int currNum, int target){
        if(currNum > target){
            return false;
        }else if(index == s.length()){
            if(currNum == target){
                return true;
            }else{
                return false;
            }
        }
        for(int i = index+1; i <= s.length(); i++){
            String partitionStr = s.substring(index, i);
            int partitionNum = Integer.valueOf(partitionStr);
            if(isPartition(s, i, currNum + partitionNum, target)){
                return true;
            }
        }
        return false;
    }

}
