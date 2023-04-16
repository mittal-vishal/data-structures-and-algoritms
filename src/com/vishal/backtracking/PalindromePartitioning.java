package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        List<String> palin = new ArrayList<>();
        recurse(s, 0, palin, results);
        return results;
    }

    private void recurse(String s, int i, List<String> palin, List<List<String>> results){
        if(i == s.length()){
            results.add(new ArrayList<>(palin));
            return;
        }
        for(int j = i+1; j <= s.length(); j++){
            String substr = s.substring(i, j);
            if(isPalin(substr)){
                palin.add(substr);
                recurse(s, j, palin, results);
                palin.remove(palin.size()-1);
            }
        }
    }

    private boolean isPalin(String s){
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

}
