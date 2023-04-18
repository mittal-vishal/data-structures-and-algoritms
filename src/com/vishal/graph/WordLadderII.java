package com.vishal.graph;

import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Queue<ArrayList<String>> queue = new LinkedList<>();
        HashSet<String> wordsSet = new HashSet<>();
        for(String word: wordList){
            wordsSet.add(word);
        }
        queue.offer(new ArrayList<>(Arrays.asList(beginWord)));
        int level = 0;
        List<String> wordsOnLevel = new ArrayList<>();
        wordsOnLevel.add(beginWord);
        while(!queue.isEmpty()){
            List<String> polled = queue.poll();
            if(polled.size() > level){
                level++;
                for(String levelWord: wordsOnLevel){
                    wordsSet.remove(levelWord);
                }
                wordsOnLevel.clear();
            }
            String lastSeqWord = polled.get(polled.size()-1);
            if(lastSeqWord.equals(endWord)){
                result.add(polled);
            }
            char[] lastSeqWordArr = lastSeqWord.toCharArray();
            for(int i = 0; i < lastSeqWordArr.length; i++){
                char original = lastSeqWordArr[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    lastSeqWordArr[i] = ch;
                    if(wordsSet.contains(String.valueOf(lastSeqWordArr))){
                        polled.add(String.valueOf(lastSeqWordArr));
                        queue.offer(new ArrayList<>(polled));
                        wordsOnLevel.add(String.valueOf(lastSeqWordArr));
                        polled.remove(polled.size()-1);
                    }
                }
                lastSeqWordArr[i] = original;
            }
        }
        return result;
    }

}
