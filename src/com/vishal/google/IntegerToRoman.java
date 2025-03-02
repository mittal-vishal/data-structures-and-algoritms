package com.vishal.google;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {

    private static LinkedHashMap<Integer,String> mapping;
    static {
        mapping = new LinkedHashMap<>();
        mapping.put(1000, "M");
        mapping.put(900, "CM");
        mapping.put(500, "D");
        mapping.put(400, "CD");
        mapping.put(100, "C");
        mapping.put(90, "XC");
        mapping.put(50, "L");
        mapping.put(40, "XL");
        mapping.put(10, "X");
        mapping.put(9, "IX");
        mapping.put(5, "V");
        mapping.put(4, "IV");
        mapping.put(1, "I");
    }
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            for(Map.Entry<Integer,String> entry: mapping.entrySet()){
                int times = num / entry.getKey();
                String symbol = entry.getValue();
                if(times == 0){
                    continue;
                }else{
                    for(int i = 0; i < times; i++){
                        sb.append(symbol);
                    }
                    num = num % entry.getKey();
                }
            }
        }
        return sb.toString();
    }

}
