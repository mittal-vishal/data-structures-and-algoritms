package com.vishal.tries;

class LongestPrefix {

    private static Node root;

    public LongestPrefix(){
        root = new Node('\0');
    }

    static class Node{
        char ch;
        Node[] childrens;
        boolean isWord;
        public Node(char ch){
            this.ch = ch;
            childrens = new Node[26];
        }
    }

    public String longestCommonPrefix(String[] strs) {
        Node curr = root;
        for(String str: strs) {
            insert(curr, str);
            curr = root;
        }
        StringBuilder prefix = new StringBuilder();
        getCommonPrefix(curr, prefix);
        return prefix.toString();
    }

    private void getCommonPrefix(Node curr, StringBuilder prefix){
        boolean isOneChild = false;
        Node oneChildNode = null;
        if(curr.isWord){
            return;
        }
        for(int i = 0; i < 26; i++){
            if(curr.childrens[i] != null) {
                if(isOneChild){
                    return;
                }
                oneChildNode = curr.childrens[i];
                isOneChild = true;
            }
        }
        if(isOneChild){
            prefix.append(oneChildNode.ch);
            if(!oneChildNode.isWord) {
                getCommonPrefix(oneChildNode, prefix);
            }
        }
    }

    private void insert(Node current, String s){
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(current.childrens[curr-'a'] == null){
                Node newNode = new Node(curr);
                current.childrens[curr-'a'] = newNode;
            }
            current = current.childrens[curr-'a'];
        }
        current.isWord = true;
    }

    public static void main(String[] args) {
        LongestPrefix longestPrefix = new LongestPrefix();
        String[] strArr= {"flower","flow","flight"};
        String prefix = longestPrefix.longestCommonPrefix(strArr);
        System.out.print(prefix);
    }

    public String longestCommonPrefixBrute(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        int i = 1;
        while(i < strs.length){
            if(strs[i].startsWith(prefix)){
                i++;
                continue;
            }else{
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
}

