package com.vishal.bitmaskdp;

import java.util.HashMap;

public class FindShortestSuperString {

    private HashMap<String,String> memo;

    public String shortestSuperString(String[] words) {
        memo = new HashMap<>();
        int mask = 0;
        int n = words.length;
        for(int i = 0; i < n; i++){
            mask |= 1 << i;
        }
        String ans = shortestSuperstring(words, "", mask);
        return ans;
    }

    private String shortestSuperstring(String[] words, String startWord, int mask){
        if(mask == 0){
            return startWord;
        }
        String key = startWord + mask;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        String shortest = null;
        for(int i = 0; i < words.length; i++){
            if(!isConsume(i, mask)){
                String currSuperstring = shortestSuperstring(words, words[i], consume(i, mask));
                currSuperstring = getCommonSuperstring(startWord, currSuperstring);
                if(shortest == null || currSuperstring.length() < shortest.length()){
                    shortest = currSuperstring;
                }
            }
        }
        memo.put(key, shortest);
        return shortest;
    }

    private int consume(int i, int mask){
        return (~(1 << i)) & mask;
    }

    private boolean isConsume(int i, int mask){
        return ((mask >> i) & 1) == 0;
    }

    private String getCommonSuperstring(String s, String t){
        for(int i = Math.max(1, s.length()-t.length()); i < s.length(); i++){
            boolean match = true;
            for(int j = i; j < s.length(); j++){
                if(s.charAt(j) != t.charAt(j-i)){
                    match = false;
                    break;
                }
            }
            if(match){
                return s.substring(0, i) + t;
            }
        }
        return s+t;
    }

    public static void main(String[] args) {
        FindShortestSuperString findShortestSuperString = new FindShortestSuperString();
        String[] words = {"catg","ctaagt","gcta","ttca","atgcatc"};
        findShortestSuperString.shortestSuperString(words);
    }

}
