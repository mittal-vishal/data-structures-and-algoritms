package com.vishal.graph;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> dictionary = new HashSet<>(wordList);
        if(dictionary.contains(beginWord)){
            dictionary.remove(beginWord);
        }
        int steps = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curr = queue.poll();
                if(curr.equals(endWord)){
                    return steps;
                }
                char[] currArr = curr.toCharArray();
                for(int j = 0; j < curr.length(); j++){
                    char temp = currArr[j];
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        currArr[j] = ch;
                        if(dictionary.contains(String.valueOf(currArr))){
                            queue.offer(String.valueOf(currArr));
                            dictionary.remove(String.valueOf(currArr));
                        }
                    }
                    currArr[j] = temp;
                }
            }
            steps++;
        }
        return 0;
    }

}
