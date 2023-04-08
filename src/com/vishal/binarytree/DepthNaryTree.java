package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.List;

public class DepthNaryTree {

    static class Node {
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

    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }else if (root.children.isEmpty()) {
            return 1;
        }
        List<Integer> heights = new LinkedList<>();
        for (Node item : root.children) {
            heights.add(maxDepth(item));
        }
        return getMax(heights) + 1;
    }

    private int getMax(List<Integer> heights){
        int max = heights.get(0);
        for(int i = 1; i < heights.size(); i++){
            max = Math.max(max, heights.get(i));
        }
        return max;
    }

}
