package com.vishal.binarytree;

public class PathSumI {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        boolean isExist = dfs(root, targetSum);
        return isExist;
    }

    private boolean dfs(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && (targetSum - root.val) == 0){
            return true;
        }
        boolean isLeft = dfs(root.left, targetSum - root.val);
        boolean isRight = dfs(root.right, targetSum - root.val);
        return isLeft || isRight;
    }
	
}
