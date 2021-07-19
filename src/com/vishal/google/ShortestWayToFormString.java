package com.vishal.google;

public class ShortestWayToFormString {

    public int shortestWay(String source, String target) {
        int k = 0;
        for(int i = 0; i < target.length(); i++){
            boolean isMatchFount = false;
            for(int j = 0; j < source.length(); j++){
                if(source.charAt(j) == target.charAt(k)){
                    k++;
                    isMatchFount = true;
                }
                if(k == target.length()){
                    return i+1;
                }
            }
            if(isMatchFount == false){
                return -1;
            }
        }
        return -1;
    }

}
