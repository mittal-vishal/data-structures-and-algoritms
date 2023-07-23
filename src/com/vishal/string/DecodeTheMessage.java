package com.vishal.string;

import java.util.HashMap;

public class DecodeTheMessage {

    public String decodeMessage(String key, String message) {
        HashMap<Character,Integer> charIntegers = new HashMap<>();
        int count = 0;
        for(int i = 0; i < key.length(); i++){
            char ch = key.charAt(i);
            if(charIntegers.containsKey(ch) || ch == ' '){
                continue;
            }
            charIntegers.put(ch, count++);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: message.toCharArray()){
            if(ch == ' '){
                sb.append(' ');
                continue;
            }
            Integer pos = charIntegers.get(ch);
            sb.append((char)(pos+97));
        }
        return sb.toString();
    }

}
