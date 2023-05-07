package com.vishal.google;

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0;
        int sentenceIdx = 0;
        int colCount = cols;
        for(int i = 0; i < rows;){
            if(colCount >= sentence[sentenceIdx].length()){
                colCount -= sentence[sentenceIdx++].length();
                colCount--;
            }else{
                i++;
                colCount = cols;
            }
            if(sentenceIdx == sentence.length){
                count++;
                sentenceIdx = 0;
            }
        }
        return count;
    }

}
