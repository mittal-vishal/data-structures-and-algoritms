package com.vishal.microsoft;

import com.vishal.binarytree.TreeNode;

public class DistributeCoins {

    private int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        moves += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }

}
