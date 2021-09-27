package com.vishal.binarytree;

public class BalancedTreeOptimal {
	
	public boolean isBalanced(TreeNode root) {
        if(balancedFactor(root) > -1){
            return true;
        }else{
            return false;
        }
    }
    
    private int balancedFactor(TreeNode root) {
		if(root == null)
			return 0;
        int left = balancedFactor(root.getLeft());
        int right = balancedFactor(root.getRight());
        if(left == -1 || right == -1)
            return -1;
        if(Math.abs(left-right) > 1)
            return -1;
        return Math.max(left, right) + 1;
	}
	
}
