package com.vishal.tries;

class Trie {

    /**
     * Initialize your data structure here.
     */
    private final Node root;

    public Trie() {
        root = new Node('\0');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (curr.childrens[currChar - 'a'] == null) {
                Node newNode = new Node(currChar);
                curr.childrens[currChar - 'a'] = newNode;
            }
            curr = curr.childrens[currChar - 'a'];
        }
        curr.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node searchNode = getNode(word);
        return searchNode != null && searchNode.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node prefixNode = getNode(prefix);
        return prefixNode != null;
    }

    private Node getNode(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.childrens[ch - 'a'] == null) {
                return null;
            }
            curr = curr.childrens[ch - 'a'];
        }
        return curr;
    }
}

class Node {
    char ch;
    boolean isWord;
    Node[] childrens;

    public Node(char ch) {
        this.ch = ch;
        childrens = new Node[26];
        isWord = false;
    }
}