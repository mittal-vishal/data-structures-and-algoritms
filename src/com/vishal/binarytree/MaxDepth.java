package com.vishal.binarytree;

public class MaxDepth {

	public int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		if(root. left == null && root.right == null){
			return 1;
		}
		int leftHeight = maxDepth(root.left);
		int rightHeight = maxDepth(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
}
