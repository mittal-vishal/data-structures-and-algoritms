package com.vishal.string;

public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while(i < name.length() && j < typed.length()){
            char ch = name.charAt(i);
            int length = 1;
            while(i+1 < name.length()){
                if(name.charAt(i) == name.charAt(i+1)){
                    i++;
                    length++;
                    continue;
                }else{
                    break;
                }
            }
            while(j < typed.length()){
                if(typed.charAt(j) == ch){
                    j++;
                    length--;
                }else{
                    break;
                }
            }
            if(length > 0){
                return false;
            }
            i++;
        }
        return j < typed.length() || i < name.length() ? false : true;
    }

}
