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
            //count 1 space between each words except for last word
            int spaceBtwWords = (i == words.length - 1) ? 0: 1;
            //if words per line is less or equal to maxChars per line
            if(currWord.length() <= maxChars){
                //update line length with space between words
                lineLength += (currWord.length() + spaceBtwWords);
                lineWordsList.add(currWord);
                maxChars -= (currWord.length() + spaceBtwWords);
                if(i == words.length - 1 || maxChars < words[i+1].length()){
                    //remove extra space for last word of line
                    if(i < words.length - 1){
                        lineLength--;
                    }
                    String justifiedStr = doJustifyContent(lineWordsList, spaceBtwWords, maxWidth, lineLength);
                    //add in resultant justified list
                    fullJustifyList.add(justifiedStr);
                    //reset maxChars limit to original width
                    maxChars = maxWidth;
                    //reset line length to zero
                    lineLength = 0;
                    //reset number of words in line to empty
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
        //calculate extra spaces
        int extraSpaces = maxWidth - lineLength;
        for(int i = 0; i < lineWordsList.size(); i++){
            if(i < lineWordsList.size() - 1){
                justifiedContent.append(lineWordsList.get(i)).append(" ");
            }else{
                justifiedContent.append(lineWordsList.get(i));
            }
        }
        //append extra spaces at end of justfied content
        for(int i = 0; i < extraSpaces; i++){
            justifiedContent.append(" ");
        }
        return justifiedContent.toString();
    }

    private String doFullJustify(List<String> lineWordsList, int maxWidth, int lineLength){
        StringBuilder justifiedContent = new StringBuilder();
        //calculate total spaces in line
        int totalExtraSpaces = maxWidth - lineLength;
        //extra spaces per word
        int extraSpacesPerWord = totalExtraSpaces / (lineWordsList.size() - 1);
        //additional extra spaces for inital words
        int extraSpacesForInitialWords = totalExtraSpaces % (lineWordsList.size() - 1);
        for(int i = 0; i < lineWordsList.size(); i++){
            if(i < lineWordsList.size() - 1){
                justifiedContent.append(lineWordsList.get(i)).append(" ");
                //totalSpaces contains sum of extraSpacesPerWord and extraSpacesForInitialWords
                int spacesCount = extraSpacesPerWord;
                if(extraSpacesForInitialWords > 0){
                    extraSpacesForInitialWords--;
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
