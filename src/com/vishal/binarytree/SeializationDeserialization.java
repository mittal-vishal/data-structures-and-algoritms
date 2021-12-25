package com.vishal.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

public class SeializationDeserialization {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder preorderStr = new StringBuilder();;
        preorder(root, preorderStr);
        preorderStr.deleteCharAt(preorderStr.length() - 1);
        return preorderStr.toString();
    }

    private void preorder(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("null,");
        }else{
            str.append(String.valueOf(root.val) + ',');
            preorder(root.left, str);
            preorder(root.right, str);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        LinkedList<String> nodesList = new LinkedList(Arrays.asList(nodes));
        return constructTree(nodesList);
    }

    private TreeNode constructTree(LinkedList<String> nodes){
        if(nodes.getFirst().equals("null")){
            nodes.removeFirst();
            return null;
        }
        int rootVal = Integer.parseInt(nodes.getFirst());
        TreeNode root = new TreeNode(rootVal);
        nodes.removeFirst();
        root.left = constructTree(nodes);
        root.right = constructTree(nodes);
        return root;
    }

}
