package com.vishal.iterator;

import java.util.LinkedList;

class CombinationIterator {

    private LinkedList<String> list;

    public CombinationIterator(String characters, int combinationLength) {
        list = new LinkedList<>();
        backtrack(characters, 0, combinationLength, new StringBuilder(), list);
    }

    private void backtrack(String characters, int index, int k, StringBuilder sb, LinkedList<String> list){
        if(sb.length() == k){
            list.add(sb.toString());
            return;
        }
        for(int i = index; i < characters.length(); i++){
            char currChar = characters.charAt(i);
            sb.append(currChar);
            backtrack(characters, i+1, k, sb, list);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public String next() {
        String curr = list.removeFirst();
        return curr;
    }

    public boolean hasNext() {
        return list.size() > 0;
    }
}
