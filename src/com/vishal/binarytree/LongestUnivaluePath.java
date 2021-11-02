package com.vishal.binarytree;

public class LongestUnivaluePath {

    private int maxConsecutive;

    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxConsecutive = 1;
        dfs(root);
        return maxConsecutive;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(root.left != null && root.val == (root.left.val - 1)){
            left += 1;
        }else{
            left = 1;
        }
        if(root.right != null && root.val == (root.right.val - 1)){
            right += 1;
        }else{
            right = 1;
        }
        maxConsecutive = Math.max(maxConsecutive, Math.max(left, right));
        return Math.max(left, right);
    }

}
