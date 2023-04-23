package com.vishal.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializationDeserialization {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");
        LinkedList<String> nodesList = new LinkedList<>(Arrays.asList(nodes));
        return constructTree(nodesList);
    }

    private TreeNode constructTree(LinkedList<String> nodesList){
        if(nodesList.size() > 0 && nodesList.getFirst().equals("null")){
            nodesList.removeFirst();
            return null;
        }
        int data = Integer.valueOf(nodesList.removeFirst());
        TreeNode root = new TreeNode(data);
        root.left = constructTree(nodesList);
        root.right = constructTree(nodesList);
        return root;
    }

}
