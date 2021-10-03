package com.vishal.binarytree;

public class PathSumRootToLeave {

	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if((sum - root.val) == 0 && root.left == null && root.right == null){
            return true;
        }
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
        if(left || right){
            return true;
        }
        return false;
    }
	
}
