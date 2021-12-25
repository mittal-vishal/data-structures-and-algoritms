package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.List;

public class SerializationDeserializationII {

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

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private void preorder(Node root, StringBuilder sb){
        sb.append(String.valueOf(root.val) + ",");
        for(Node child: root.children){
            preorder(child, sb);
        }
        sb.append("null,");
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String[] nodes = data.split(",");
        LinkedList<Node> nodeList = new LinkedList<>();
        for(int i = 0; i < nodes.length-1; i++){
            String rootVal = nodes[i];
            if(rootVal.equals("null")){
                Node polled = nodeList.removeFirst();
                nodeList.getFirst().children.add(polled);
            }else{
                Node currNode = new Node(Integer.parseInt(rootVal));
                currNode.children = new LinkedList<>();
                nodeList.addFirst(currNode);
            }
        }
        return nodeList.removeFirst();
    }

}
