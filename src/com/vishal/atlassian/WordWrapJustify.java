package com.vishal.atlassian;

import java.util.ArrayList;
import java.util.List;

public class WordWrapJustify {

    public static void main(String[] args) {
        List<String> words = List.of("abc", "def", "gh");
        List<String> result = justify(words, 9);
        System.out.println(result);
    }

    private static List<String> justify(List<String> words, int size) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while(i < words.size()){
            String currWord = words.get(i);
            int totalLength = currWord.length();
            int j = i+1;
            int wordCount = 0;
            while(j < words.size() && (totalLength + 1 + words.get(j).length() + wordCount) <= size){
                totalLength += words.get(j).length();
                j++;
                wordCount++;
            }
            StringBuilder sb = new StringBuilder();
            for(int k = i; k < j; k++){
                sb.append(words.get(k));
                if(k < j-1){
                    sb.append("-");
                }
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }

}
