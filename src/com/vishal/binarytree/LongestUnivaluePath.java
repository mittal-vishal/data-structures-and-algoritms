package com.vishal.binarytree;

public class LongestUnivaluePath {

    int max;
    public int longestUnivaluePath(Node root) {
        dfs(root);
        return max;
    }

    private int dfs(Node root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(root.left != null && root.left.data == root.data){
            left += 1;
        }else{
            left = 0;
        }
        if(root.right != null && root.right.data == root.data){
            right += 1;
        }else{
            right = 0;
        }
        max = Math.max(max, left+right);
        return Math.max(left, right);
    }

}
