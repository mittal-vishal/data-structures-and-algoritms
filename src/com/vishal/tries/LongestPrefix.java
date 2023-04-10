package com.vishal.tries;

class LongestPrefix {

    class Node{
        Node[] childrens;
        boolean isEnd;
        char ch;
        public Node(char ch){
            this.ch = ch;
            childrens = new Node[26];
        }
    }
    private Node root;
    public String longestCommonPrefix(String[] strs) {
        root = new Node('\0');
        for(String str: strs){
            insert(str);
        }
        StringBuilder sb = new StringBuilder();
        Node curr = root;
        getLongestPrefix(curr, sb);
        return sb.toString();
    }

    private void getLongestPrefix(Node curr, StringBuilder sb){
        int nodeCount = 0;
        Node singleChild = null;
        if(curr.isEnd){
            return;
        }
        for(int i = 0; i < 26; i++){
            if(curr.childrens[i] != null){
                nodeCount++;
                singleChild = curr.childrens[i];
            }
        }
        if(nodeCount == 1){
            sb.append(singleChild.ch);
            getLongestPrefix(singleChild, sb);
        }
    }

    private void insert(String s){
        Node curr = root;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(curr.childrens[ch-'a'] == null){
                curr.childrens[ch-'a'] = new Node(ch);
            }
            curr = curr.childrens[ch-'a'];
        }
        curr.isEnd = true;
    }
}

