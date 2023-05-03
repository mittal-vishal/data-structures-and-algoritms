package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        while(root != null){
            root = dfs(root, result);
            results.add(result);
            result = new ArrayList<>();
        }
        return results;
    }
    private TreeNode dfs(TreeNode root, List<Integer> result){
        if(root == null){
            return null;
        }else if(root.left == null && root.right == null){
            result.add(root.val);
            return null;
        }
        root.left = dfs(root.left, result);
        root.right = dfs(root.right, result);
        return root;
    }

}
