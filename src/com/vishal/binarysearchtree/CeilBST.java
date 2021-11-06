package com.vishal.binarysearchtree;

public class CeilBST {

	private static TreeNode rootNode = null;
	private int ceil;
	private boolean isFound;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.left = new TreeNode(1);
		rootNode.right  = new TreeNode(7);
		rootNode.left.right = new TreeNode(2);
		rootNode.left.right.right = new TreeNode(3);
		CeilBST ceil = new CeilBST();
		int retVal = ceil.findCeil(rootNode, 3);
		System.out.print(retVal);
	}

	private int findCeil(TreeNode root, int item) {
		ceil = -1;
		dfs(root, item);
		return ceil;
	}

	private void dfs(TreeNode root, int item){
		if(root == null){
			return;
		}
		dfs(root.left, item);
		if(root.val >= item && (!isFound)){
			ceil = root.val;
			isFound = true;
		}
		dfs(root.right, item);
	}

	private int findCeilIteratively(TreeNode root, int item) {
		int result = -1;
		if(root.val > item) {
			result = root.val;
		}
		while(root != null) {
			if(root.val == item) {
				result = root.val;
				break;
			}
			else if(item > root.val) {
				root = root.right;
				if(root != null && root.val > item) {
					result = root.val;
				}
			}else {
				root = root.left;
				if(root != null && root.val > item && root.val < result) {
					result = root.val;
				}
			}
		}
		return result;
	}

}
