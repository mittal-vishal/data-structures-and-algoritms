package com.vishal.binarytree;

public class LongestConsecutiveNodes {

    int longest = 0;

    public int longestConsecutive(Node root) {
        dfs(root, null, 0);
        return longest;
    }

    //Top-down approach using DFS Traversal
    private void dfs(Node root, Node parent, int length){
        if(root == null){
            return;
        }
        length = parent != null && parent.data + 1 == root.data ? length + 1 : 1;
        longest = Math.max(longest, length);
        dfs(root.left, root, length);
        dfs(root.right, root, length);
    }

    //Bottom-up approach using DFS Traversal
    private int dfs(Node root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        left = root.left != null && root.left.data - 1 == root.data ? left + 1 : 1;
        right = root.right != null && root.right.data - 1 == root.data ? right + 1 : 1;
        longest = Math.max(longest, Math.max(left, right));
        return Math.max(left, right);
    }

}
