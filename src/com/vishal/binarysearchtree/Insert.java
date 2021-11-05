package com.vishal.binarysearchtree;

public class Insert {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.left = new TreeNode(2);
		rootNode.right = new TreeNode(20);
		rootNode.left.right = new TreeNode(4);
		rootNode.right.left = new TreeNode(10);
		rootNode.right.right = new TreeNode(40);
		rootNode.right.right.left = new TreeNode(30);
		insert(rootNode, 15);
	}

	private static TreeNode insert(TreeNode root, int item) {
		if (root == null) {
			return new TreeNode(item);
		}else if(item > root.val) {
			root.right = insert(root.right, item);
		}else {
			root.left = insert(root.left, item);
		}
		return root;
	}
	
}
