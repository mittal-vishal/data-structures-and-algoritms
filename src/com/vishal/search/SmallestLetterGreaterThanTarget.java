package com.vishal.search;

public class SmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        if(target > letters[end]){
            return letters[0];
        }else if(target < letters[0]){
            return letters[0];
        }

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target >= letters[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return letters[start % (letters.length)];
    }

}
