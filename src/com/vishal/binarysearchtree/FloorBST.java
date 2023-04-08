package com.vishal.binarysearchtree;

public class FloorBST {

	private int ans;

	public int floor(TreeNode root, int x) {
		if (root == null) return -1;
		ans = -1;
		dfs(root, x);
		return ans;
	}

	private void dfs(TreeNode root, int key){
		if(root == null){
			return;
		}
		dfs(root.left, key);
		if(root.val <= key){
			ans = root.val;
		}
		dfs(root.right, key);
	}
	
}
