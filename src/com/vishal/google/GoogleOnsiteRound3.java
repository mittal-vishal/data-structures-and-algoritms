package com.vishal.google;

import java.util.*;


/*
Suppose we have a text file in which each line has many positive integers separated by spaces.
Two lines are considered as duplicate if they contain exact same numbers (ordering is not significant).

Please write a program to remove duplicate lines.

For example, we have an input file as follows:
1  23  1  34  -- 1, 1, 23, 24
23  1  1  34 -- 1,1,23,24
23  1  34 -- 1, 23, 34
1  2  3 -- 1,2,3
4  5  6  7  8  9 -- 4,5,6,7,8,9

Then the line 1 and line 2 are duplicate since they include the same multi-set (23, 1, 1, 34)
The output file should be (the original order of lines or numbers within each line doesn't need to be reserved):
1 23 34
1 1 23 34
1 2 3
4 5 6 7 8 9

*/

/*

1  23  1  34
23  1  1  34
23  1  34
1  2  3
4  5  6  7  8  9

res , dict -> 1 1 23 34, 1 23 34, 1 2 3, 4  5  6  7  8  9

23  1  1  34
23  1  34
1  2  3
4  5  6  7  8  9


HashSet<List<Integer>> dictionary

T(N) - N*(MLogM)
S(N) - N*M(worst case scenario)
M- numbers count in lines
N - total number of lines

1  23  1  34

1 1 23 34

23  1  1  34
1 1 23 34

0 <= num[i] < FINITE
*/


public class GoogleOnsiteRound3 {

    private List<List<Integer>> getNonDuplicateLines(List<List<Integer>> inputs){
        //base check
        if(inputs == null || inputs.size() == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> nonDuplicates = new ArrayList<>();
        HashSet<List<Integer>> dictionary = new HashSet<>();
        for(List<Integer> currentLine: inputs){
            if(currentLine == null){
                continue;
            }
            Collections.sort(currentLine);
            if(!dictionary.contains(currentLine)){
                dictionary.add(currentLine);
                nonDuplicates.add(currentLine);
            }
        }
        return nonDuplicates;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> line1 = Arrays.asList(1,23,1,34);
        List<Integer> line2 = Arrays.asList(1,1,23,34);
        List<Integer> line3 = Arrays.asList(23,1,34);
        List<Integer> line4 = Arrays.asList(1,2,3);
        List<Integer> line5 = Arrays.asList(4,5,6,7,8,9);
        input.add(line1);
        input.add(line2);
        input.add(line3);
        input.add(line4);
        input.add(line5);
        GoogleOnsiteRound3 or3 = new GoogleOnsiteRound3();
        System.out.println(or3.getNonDuplicateLines(input));
    }

}