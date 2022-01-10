package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtree {

    private static TreeNode rootNode = null;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> duplicates = new ArrayList<>();
        dfs(root, map, duplicates);
        return duplicates;
    }

    private String dfs(TreeNode root, HashMap<String, Integer> map, List<TreeNode> duplicates){
        if(root == null){
            return "#";
        }
        String left = dfs(root.left, map, duplicates);
        String right = dfs(root.right, map, duplicates);
        String path = root.val + "," + left + "," + right;
        map.put(path, map.getOrDefault(path, 0) + 1);
        if(map.get(path) == 2){
            duplicates.add(root);
        }
        return path;
    }

    public static void main(String[] args) {
        rootNode = new TreeNode(1);
        rootNode.setLeft(new TreeNode(2));
        rootNode.setRight(new TreeNode(3));
        rootNode.getLeft().setLeft(new TreeNode(4));
        rootNode.getRight().setLeft(new TreeNode(2));
        rootNode.getRight().setRight(new TreeNode(4));
        rootNode.getRight().getLeft().setLeft(new TreeNode(4));
        FindDuplicateSubtree duplicate = new FindDuplicateSubtree();
        List<TreeNode> duplicates = duplicate.findDuplicateSubtrees(rootNode);
        for(TreeNode root: duplicates){
            PreOrder.find(root);
            System.out.println();
        }
    }

}
