package com.vishal.binarytree;

public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }else if(s == null || t == null){
            return false;
        }else if(s.val != t.val){
            return false;
        }
        boolean isLeft = dfs(s.left, t.right);
        boolean isRight = dfs(s.right, t.left);
        return isLeft && isRight;
    }

}
