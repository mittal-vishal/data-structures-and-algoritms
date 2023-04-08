package com.vishal.binarysearchtree;

public class ClosestElement {

	private int ans;
	private double absDiff;
	public int closestValue(TreeNode root, double target) {
		this.absDiff = Integer.MAX_VALUE;
		dfs(root, target);
		return ans;
	}

	private void dfs(TreeNode root, double target){
		if(root == null){
			return;
		}
		dfs(root.left, target);
		double val = (double)root.val;
		if(Math.abs(val-target) < absDiff){
			ans = root.val;
			absDiff = Math.abs(val-target);
		}
		dfs(root.right, target);
	}
	
}
