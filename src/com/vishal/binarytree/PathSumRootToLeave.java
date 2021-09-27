package com.vishal.binarytree;

public class PathSumRootToLeave {

	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if((sum - root.data) == 0 && root.left == null && root.right == null){
            return true;
        }
        boolean left = hasPathSum(root.left, sum - root.data);
        boolean right = hasPathSum(root.right, sum - root.data);
        if(left || right){
            return true;
        }
        return false;
    }
	
}
