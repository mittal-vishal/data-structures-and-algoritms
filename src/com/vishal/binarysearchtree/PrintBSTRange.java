package com.vishal.binarysearchtree;

public class PrintBSTRange {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(10);
		rootNode.left = new TreeNode(5);
		rootNode.right = new TreeNode(50);
		rootNode.left.left = new TreeNode(1);
		rootNode.right.left = new TreeNode(40);
		rootNode.right.right = new TreeNode(100);
		find(rootNode, 5, 45);
	}

	private static void find(TreeNode root, int i, int j) {
		if(root != null) {
			find(root.left, i, j);
			if(root.val >= i && root.val <= j) {
				System.out.print(root.val + " ");
			}
			find(root.right, i, j);
		}
	}
	
}
