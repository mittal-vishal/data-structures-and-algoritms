package com.vishal.google;

import java.util.ArrayList;
import java.util.List;

public class TextJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> fullJustifyList = new ArrayList<>();
        List<String> lineWordsList = new ArrayList<>();

        int maxChars = maxWidth;
        int lineLength = 0;
        for(int i = 0; i < words.length; i++){
            String currWord = words[i];
            int spaceBtwWords = (i == words.length - 1) ? 0: 1;
            if(currWord.length() <= maxChars){
                lineLength += (currWord.length() + spaceBtwWords);
                lineWordsList.add(currWord);
                maxChars -= (currWord.length() + spaceBtwWords);
                if(i == words.length - 1 || maxChars < words[i+1].length()){
                    if(i < words.length - 1){
                        lineLength--;
                    }
                    String justifiedStr = doJustifyContent(lineWordsList, spaceBtwWords, maxWidth, lineLength);
                    fullJustifyList.add(justifiedStr);
                    maxChars = maxWidth;
                    lineLength = 0;
                    lineWordsList = new ArrayList<>();
                }
            }
        }

        return fullJustifyList;
    }

    private String doJustifyContent(List<String> lineWordsList, int spaceBtwWords, int maxWidth, int lineLength){
        //Full Justify
        if(lineWordsList.size() > 1 && spaceBtwWords == 1){
            return doFullJustify(lineWordsList, maxWidth, lineLength);
        }else{
            //Left Justify
            return doLeftJustify(lineWordsList, maxWidth, lineLength);
        }
    }

    private String doLeftJustify(List<String> lineWordsList, int maxWidth, int lineLength){
        StringBuilder justifiedContent = new StringBuilder();
        int totalSpaces = maxWidth - lineLength;
        for(int i = 0; i < lineWordsList.size(); i++){
            if(i < lineWordsList.size() - 1){
                justifiedContent.append(lineWordsList.get(i)).append(" ");
            }else{
                justifiedContent.append(lineWordsList.get(i));
            }
        }
        for(int i = 0; i < totalSpaces; i++){
            justifiedContent.append(" ");
        }
        return justifiedContent.toString();
    }

    private String doFullJustify(List<String> lineWordsList, int maxWidth, int lineLength){
        StringBuilder justifiedContent = new StringBuilder();
        int totalSpaces = maxWidth - lineLength;
        int spacesPerWord = totalSpaces / (lineWordsList.size() - 1);
        int extraSpaces = totalSpaces % (lineWordsList.size() - 1);
        for(int i = 0; i < lineWordsList.size(); i++){
            if(i < lineWordsList.size() - 1){
                justifiedContent.append(lineWordsList.get(i)).append(" ");
                int spacesCount = spacesPerWord;
                if(extraSpaces > 0){
                    extraSpaces--;
                    spacesCount += 1;
                }
                for(int j = 0; j < spacesCount; j++){
                    justifiedContent.append(" ");
                }
            }else{
                justifiedContent.append(lineWordsList.get(i));
            }
        }
        return justifiedContent.toString();
    }

    public static void main(String[] args) {
        String[] text = {"Science","is","what","we","understand","well"};
        int maxWidth = 20;
        TextJustify textJustify = new TextJustify();
        System.out.print(textJustify.fullJustify(text, maxWidth));
    }

}
