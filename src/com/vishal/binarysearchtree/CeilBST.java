package com.vishal.binarysearchtree;

public class CeilBST {

	private int ans;
	private boolean isFound;
	// Function to return the ceil of given number in BST.
	int findCeil(TreeNode root, int key) {
		if (root == null) return -1;
		dfs(root, key);
		return isFound ? ans: -1;
	}

	void dfs(TreeNode root, int key){
		if(root == null){
			return;
		}
		dfs(root.left, key);
		if(root.val >= key && !isFound){
			ans = root.val;
			isFound = true;
		}
		dfs(root.right, key);
	}

}
