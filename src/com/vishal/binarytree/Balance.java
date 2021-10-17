package com.vishal.binarytree;

public class Balance {

private static TreeNode rootNode = null;

	private boolean isBalance;
	public boolean isBalanced(TreeNode root) {
		isBalance = true;
		dfs(root);
		return isBalance;
	}

	private int dfs(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		if(Math.abs(left - right) > 1){
			isBalance = false;
		}
		return Math.max(left, right) + 1;
	}
	
}
