package com.vishal.string;

public class StringCompression {
	
	public int compress(char[] chars) {
        int count = 0;
        int index = 0;
        char prev = '\0'; 
        for(int i = 0; i < chars.length; i++){
            while((i < chars.length) && (prev == '\0' || prev == chars[i])){
                prev = chars[i];
                count++;
                i++;
            }
            chars[index++] = prev;
            if(count > 1){
                String countVal = count + "";
                for(char c : countVal.toCharArray()){
                    chars[index++] = c;
                }
            }
            prev = '\0';
            count = 0;
            --i;
        }
        return index;
    }

}
