package com.vishal.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

    public static void main(String[] args) {
        String str = "abc";
        List<String> subList = getSubset(str);
        System.out.print(subList);
    }

    public static List<String> getSubset(String str){
        List<String> subsetList = new ArrayList<>();
        getSubset(str, "", subsetList, 0);
        return subsetList;
    }

    private static void getSubset(String str, String current, List<String> subList, int i) {
        if(i == str.length()) {
            subList.add(current);
            return;
        }
        //Exclude
        getSubset(str, current, subList, i+1);
        //Include
        getSubset(str, current.concat(String.valueOf(str.charAt(i))), subList, i+1);
    }

}
