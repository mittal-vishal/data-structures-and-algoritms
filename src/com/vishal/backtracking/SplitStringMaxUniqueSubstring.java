package com.vishal.backtracking;

import java.util.HashSet;

public class SplitStringMaxUniqueSubstring {

    private int max;

    public int maxUniqueSplit(String s) {
        max = 0;
        backtrack(s, 0, new HashSet<>());
        return max;
    }

    private void backtrack(String s, int start, HashSet<String> seen){
        if(start == s.length()){
            max = Math.max(max, seen.size());
        }
        for(int i = start + 1; i <= s.length(); i++){
            String curr = s.substring(start, i);
            if(!seen.contains(curr)){
                seen.add(curr);
                backtrack(s, i, seen);
                seen.remove(curr);
            }
        }
    }

}
