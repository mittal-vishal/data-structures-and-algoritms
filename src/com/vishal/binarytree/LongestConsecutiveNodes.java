package com.vishal.binarytree;

public class LongestConsecutiveNodes {

    int longest = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root, null, 0);
        return longest;
    }

    //Top-down approach using DFS Traversal
    private void dfs(TreeNode root, TreeNode parent, int length){
        if(root == null){
            return;
        }
        length = parent != null && parent.val + 1 == root.val ? length + 1 : 1;
        longest = Math.max(longest, length);
        dfs(root.left, root, length);
        dfs(root.right, root, length);
    }

    //Bottom-up approach using DFS Traversal
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        left = root.left != null && root.left.val - 1 == root.val ? left + 1 : 1;
        right = root.right != null && root.right.val - 1 == root.val ? right + 1 : 1;
        longest = Math.max(longest, Math.max(left, right));
        return Math.max(left, right);
    }

}
