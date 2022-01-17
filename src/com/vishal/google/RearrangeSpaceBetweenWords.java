package com.vishal.google;

public class RearrangeSpaceBetweenWords {

    public String reorderSpaces(String text) {
        int spaceCount = 0;
        int wordsCount = 0;
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == ' '){
                spaceCount++;
            }
            if(text.charAt(i) != ' '){
                while(i < text.length() && text.charAt(i) != ' '){
                    i++;
                }
                i--;
                wordsCount++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int extraSpace = wordsCount > 1 ? spaceCount % (wordsCount - 1): spaceCount;
        int spacePerWord = wordsCount > 1 ? spaceCount / (wordsCount - 1) : 0;

        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) != ' '){
                while(i < text.length() && text.charAt(i) != ' '){
                    sb.append(text.charAt(i));
                    i++;
                }

                for(int j = 0; j < spacePerWord && (wordsCount-1) > 0; j++){
                    sb.append(' ');
                }
                wordsCount--;

            }
        }
        for(int i = 0; i < extraSpace; i++){
            sb.append(' ');
        }
        return sb.toString();
    }

}
