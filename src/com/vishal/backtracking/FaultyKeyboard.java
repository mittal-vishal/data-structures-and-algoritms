package com.vishal.backtracking;

import java.util.*;


/*
* Input: s = "I lik   to   xplor   univ rs ", dictionary  = {"like", "explore", "toe", "universe", "rse"}
Output:
[I lik   to   xplor   univ rs ,
I lik   to   xplor   univ rse,
I lik   to   xplor   universe
I lik   to  explore  univ rs ,
I lik   to  explore  univ rse
I lik   to  explore  universe
I lik   toe  xplor   univ rs
I lik   toe  xplor   univ rse
I lik   toe  xplor   universe
I lik   toe explore  univ rs ,
I lik   toe explore  univ rse,
I lik   toe explore  universe,
I like  to   xplor   univ rs ,
I like  to   xplor   univ rse,
I like  to   xplor   universe,
I like  to  explore  univ rs ,
I like  to  explore  univ rse,
I like  to  explore  universe,
I like  toe  xplor   univ rs ,
I like  toe  xplor   univ rse,
I like  toe  xplor   universe,
I like  toe explore  univ rs ,
I like  toe explore  univ rse,
I like  toe explore  universe]
*
* */
public class FaultyKeyboard {

    public static void generateStrings(char [] str, int index, Set<String> dict, List<String> result){
        if(index==str.length ) {
            String words[]= new String(str).split("\\s+");
            for(String w:words){
                if(w.contains("e") && !dict.contains(w)){
                    return;
                }
            }
            result.add(new String(str));
            return;
        }
        generateStrings(str,index+1,dict,result);
        if(str[index]==' '){
            str[index]='e';
            generateStrings(str,index+1,dict,result);
            str[index]=' ';
        }

    }
    public static void main(String[] args) {
        String input = "I lik   to   xplor   univ rs ";
        Set<String> dict = new HashSet<>(Arrays.asList("like", "explore", "toe", "universe", "rse"));
        List<String> result = new ArrayList<>();
        generateStrings(input.toCharArray(), 0, dict, result);
        System.out.println(result);
    }
}
