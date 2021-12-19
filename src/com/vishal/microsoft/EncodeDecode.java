package com.vishal.microsoft;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char nonAsciiCharDelimiter = 257;
        char nonAsciiStringDelimiter = 258;
        for(String str: strs){
            if(str.length() == 0){
                sb.append(nonAsciiCharDelimiter);
            }else{
                for(char ch: str.toCharArray()){
                    sb.append(ch);
                    sb.append(nonAsciiCharDelimiter);
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(nonAsciiStringDelimiter);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(s == null){
            return new ArrayList<>();
        }
        char nonAsciiCharDelimiter = 257;
        char nonAsciiStringDelimiter = 258;
        String[] strs = s.split(String.valueOf(nonAsciiStringDelimiter));
        List<String> strList = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            StringBuilder sb = new StringBuilder();
            for(char ch: str.toCharArray()){
                if(ch != nonAsciiCharDelimiter){
                    sb.append(ch);
                }
            }
            strList.add(sb.toString());
        }
        return strList;
    }

}
