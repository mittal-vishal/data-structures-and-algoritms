package com.vishal.graph;

import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>(Arrays.asList(beginWord)));
        List<String> lastLevelWords = new ArrayList<>();
        lastLevelWords.add(beginWord);
        int level = 0;
        HashSet<String> dictionary = new HashSet<>(wordList);
        while(!queue.isEmpty()){
            List<String> currList = queue.poll();
            //Remove previous level words from dictionary
            if(currList.size() > level){
                level++;
                for(String lastLevelWord: lastLevelWords){
                    dictionary.remove(lastLevelWord);
                }
                lastLevelWords.clear();
            }
            String currWord = currList.get(currList.size()-1);
            if(currWord.equals(endWord)){
                results.add(currList);
            }
            char[] currWordArr = currWord.toCharArray();
            for(int i = 0; i < currWordArr.length; i++){
                char temp = currWordArr[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    currWordArr[i] = ch;
                    String transformedStr = String.valueOf(currWordArr);
                    if(dictionary.contains(transformedStr)){
                        currList.add(transformedStr);
                        queue.offer(new ArrayList<>(currList));
                        lastLevelWords.add(transformedStr);
                        currList.remove(currList.size()-1);
                    }
                }
                currWordArr[i] = temp;
            }
        }
        return results;
    }

}
