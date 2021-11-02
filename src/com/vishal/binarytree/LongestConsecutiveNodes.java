package com.vishal.binarytree;

public class LongestConsecutiveNodes {

    private int maxUnivalue;

    public int longestUnivaluePath(TreeNode root) {
        maxUnivalue = 0;
        dfs(root);
        return maxUnivalue;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        if(root.left != null && root.val == root.left.val){
            left += 1;
        }else{
            left = 0;
        }

        if(root.right != null && root.val == root.right.val){
            right += 1;
        }else{
            right = 0;
        }

        maxUnivalue = Math.max(maxUnivalue, left + right);
        return Math.max(left, right);
    }

}
