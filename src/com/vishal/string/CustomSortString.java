package com.vishal.string;

import java.util.Arrays;

public class CustomSortString {

    public String customSortString(String order, String s) {
        Character[] sArr = new Character[s.length()];
        for(int i = 0; i < s.length(); i++){
            sArr[i] = s.charAt(i);
        }
        Arrays.sort(sArr, (a, b) -> order.indexOf(a) - order.indexOf(b));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sArr.length; i++){
            sb.append(sArr[i]);
        }
        return sb.toString();
    }

}
