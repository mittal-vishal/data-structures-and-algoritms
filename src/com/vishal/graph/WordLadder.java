package com.vishal.graph;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        WordLadder wl = new WordLadder();
        int result = wl.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    class Pair{
        String s;
        int sequence;
        Pair(String s, int sequence){
            this.s = s;
            this.sequence = sequence;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        HashSet<String> wordSet = new HashSet<>(wordList);
        while(!queue.isEmpty()){
            Pair polled = queue.poll();
            if(polled.s.equals(endWord)){
                return polled.sequence;
            }
            char[] wordArr = polled.s.toCharArray();
            for(int i = 0; i < wordArr.length; i++){
                char original = wordArr[i];
                for(char ch='a'; ch <= 'z'; ch++){
                    wordArr[i] = ch;
                    if(wordSet.contains(String.valueOf(wordArr))){
                        wordSet.remove(String.valueOf(wordArr));
                        queue.offer(new Pair(String.valueOf(wordArr), polled.sequence+1));
                    }
                }
                wordArr[i] = original;
            }
        }
        return 0;
    }

}
