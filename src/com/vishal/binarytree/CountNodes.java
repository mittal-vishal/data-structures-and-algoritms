package com.vishal.binarytree;

public class CountNodes {

    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + dfs(root.left) + dfs(root.right);
    }

}
