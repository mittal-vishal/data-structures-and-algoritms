package com.vishal.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class WordLadder {

    static class Pair{
        String word;
        int sequence;
        public Pair(String s, int sequence){
            this.word = s;
            this.sequence = sequence;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair polled = queue.poll();
                ListIterator<String> iterator = wordList.listIterator();
                while(iterator.hasNext()){
                    String currWord = iterator.next();
                    if(isAdjacent(polled.word, currWord)){
                        iterator.remove();
                        queue.offer(new Pair(currWord, polled.sequence + 1));
                        if(currWord.equals(endWord)){
                            return polled.sequence + 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    private boolean isAdjacent(String srcWord, String destWord){
        int unmatchedCount = 0;
        for(int i = 0; i < srcWord.length(); i++){
            if(srcWord.charAt(i) != destWord.charAt(i)){
                unmatchedCount++;
            }
            if(unmatchedCount > 1){
                return false;
            }
        }
        return true;
    }

}
