package com.vishal.google;

import java.util.ArrayList;
import java.util.List;

public class TextJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        int n = words.length;
        List<String> result = new ArrayList<>();
        while(i < words.length){
            String currWord = words[i];
            int wordCount = currWord.length();
            int j = i+1;
            int candidate = 0;

            while(j < n && (wordCount + candidate + words[j].length()+1) <= maxWidth){
                wordCount += words[j].length();
                candidate++;
                j++;
            }

            int vacancy = maxWidth - wordCount;
            int leastSpaces = vacancy / Math.max(1, candidate);
            int extraSpaces = vacancy % Math.max(1, candidate);
            //If last line
            if(j == words.length){
                leastSpaces = 1;
                extraSpaces = 0;
            }
            StringBuilder sb = new StringBuilder();
            for(int k = i; k < j; k++){
                String word = words[k];
                sb.append(word);
                if(k == j-1){
                    break;
                }
                for(int m = 0; m < leastSpaces; m++){
                    sb.append(" ");
                }
                if(extraSpaces-- > 0){
                    sb.append(" ");
                }
            }
            while(sb.length() < maxWidth){
                sb.append(" ");
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] text = {"Science","is","what","we","understand","well"};
        int maxWidth = 20;
        TextJustify textJustify = new TextJustify();
        System.out.print(textJustify.fullJustify(text, maxWidth));
    }

}
