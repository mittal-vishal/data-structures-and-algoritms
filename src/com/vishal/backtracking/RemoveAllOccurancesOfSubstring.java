package com.vishal.backtracking;

public class RemoveAllOccurancesOfSubstring {

    public String removeOccurrences(String s, String part) {
        return helper(s, 0, part);
    }

    private String helper(String s, int beg, String part){
        if(s.length() < part.length()){
            return s;
        }
        int end = beg + part.length() - 1;
        if(end == s.length()){
            return s;
        }
        String subStr = s.substring(beg, end + 1);
        if(subStr.equals(part)){
            s = s.substring(0, beg) + s.substring(end+1);
            return helper(s, 0, part);
        }
        return helper(s, beg+1, part);
    }

}
