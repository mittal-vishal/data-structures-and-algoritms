package com.vishal.google;

class FileSystem {

    class TrieNode{
        TrieNode[] childrens;
        int value;
        public TrieNode(){
            childrens = new TrieNode[27];
            value = -1;
        }
    }

    private TrieNode root;

    public FileSystem() {
        root = new TrieNode();
    }

    public boolean createPath(String path, int value) {
        TrieNode curr = root;
        boolean isCreated = false;
        for(int i = 0; i < path.length(); i++){
            int index = path.charAt(i) != '/' ? path.charAt(i) - 'a': 26;
            if(curr.childrens[index] == null){
                if(isCreated && index == 26){
                    return false;
                }
                curr.childrens[index] = new TrieNode();
                isCreated = true;
            }
            if(i != 0 && index == 26 && curr.value == -1){
                return false;
            }
            curr = curr.childrens[index];
        }
        if(curr.value == -1){
            curr.value = value;
            return true;
        }else{
            return false;
        }
    }

    public int get(String path) {
        TrieNode curr = root;
        for(int i = 0; i < path.length(); i++){
            int index = path.charAt(i) != '/' ? path.charAt(i) - 'a': 26;
            if(curr.childrens[index] != null){
                curr = curr.childrens[index];
            }else{
                return -1;
            }
        }
        return curr.value;
    }
}