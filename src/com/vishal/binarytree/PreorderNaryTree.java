package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreorderNaryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node root) {
        List<Integer> preorderList = new ArrayList<>();
        preorder(root, preorderList);
        return preorderList;
    }

    private void preorder(Node root, List<Integer> preorderList){
        if(root == null){
            return;
        }
        preorderList.add(root.val);
        for(Node node: root.children){
            preorder(node, preorderList);
        }
    }

}
