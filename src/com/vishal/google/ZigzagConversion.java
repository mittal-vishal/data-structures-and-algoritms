package com.vishal.google;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            int idx = i;
            int down = (numRows - 1 - i) * 2;
            int up = 2 * i;
            boolean isDown = true;
            while(idx < s.length()){
                sb.append(s.charAt(idx));
                if(i == 0){
                    idx += down;
                }else if(i == numRows - 1){
                    idx += up;
                }else{
                    if(isDown){
                        idx += down;
                    }else{
                        idx += up;
                    }
                    isDown = !isDown;
                }
            }
        }
        return sb.toString();
    }

}
