package com.vishal.string;

public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length();
        int m = abbr.length();
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if(word.charAt(i) == abbr.charAt(j)){
                i++;
                j++;
                continue;
            }else if(!Character.isDigit(abbr.charAt(j)) || abbr.charAt(j) == '0'){
                return false;
            }else{
                int num = 0;
                while(j < m && Character.isDigit(abbr.charAt(j))){
                    num = (10*num) + (abbr.charAt(j)-'0');
                    j++;
                }
                i += num;
                if(i > n){
                    return false;
                }
            }
        }
        return i < n || j < m ? false : true;
    }

}
