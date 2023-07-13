package com.vishal.tries;

class LongestPrefix {

    static class Node{
        Node[] children;
        boolean isWord;
        public Node(){
            children = new Node[27];
        }
    }

    private Node root;

    public String longestCommonPrefix(String[] strs) {
        root = new Node();
        for(String word: strs){
            if(word.length() == 0){
                return "";
            }
            insert(word);
        }
        StringBuilder sb = new StringBuilder();
        getPrefix(root, sb);
        return sb.toString();
    }

    private void getPrefix(Node curr, StringBuilder sb){
        if(curr.isWord){
            return;
        }
        Node singleNode = null;
        int singleNodeCount = 0;
        int resCharIndex = 0;
        for(int i = 0; i < 26; i++){
            if(curr.children[i] != null){
                singleNode = curr.children[i];
                singleNodeCount++;
                resCharIndex = i;
            }
        }
        if(singleNodeCount == 1){
            sb.append((char)('a'+resCharIndex));
            getPrefix(singleNode, sb);
        }
    }

    private void insert(String word){
        Node curr = root;
        if(word.length() == 0){
            curr.children[26] = new Node();
            return;
        }
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new Node();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isWord = true;
    }
}

