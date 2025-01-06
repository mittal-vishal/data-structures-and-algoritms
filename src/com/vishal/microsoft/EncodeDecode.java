package com.vishal.microsoft;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        char nonAsciiSplitChar = (char) 256;
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str).append(nonAsciiSplitChar);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        char nonAsciiSplitChar = (char) 256;
        String[] strs = s.split(String.valueOf(nonAsciiSplitChar), -1);
        return List.of(strs);
    }

    public static void main(String[] args) {
        List<String> strs = List.of("","");
        EncodeDecode encodeDecode = new EncodeDecode();
        String decodeStr = encodeDecode.encode(strs);
        System.out.println(encodeDecode.decode(decodeStr));
    }

}
