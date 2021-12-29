package com.vishal.tries;

public class DistinctSubstringInString {

    private int distinctCount;
    private Node root;

    public int countDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        this.distinctCount = 0;
        this.root = new Node();
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                insert(s.substring(i, j));
            }
        }
        return this.distinctCount;
    }

    private void insert(String s){
        Node curr = root;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(curr.childrens[ch-'a'] == null){
                curr.childrens[ch-'a'] = new Node();
            }
            curr = curr.childrens[ch-'a'];
        }
        if(!curr.isEnd){
            curr.isEnd = true;
            this.distinctCount++;
        }
    }

    class Node{
        Node[] childrens;
        boolean isEnd;
        public Node(){
            childrens = new Node[26];
            isEnd = false;
        }
    }

}
