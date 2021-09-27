package com.vishal.binarysearchtree;

public class PrintBSTRange {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(10);
		rootNode.setLeft(new TreeNode(5));
		rootNode.setRight(new TreeNode(50));
		rootNode.getLeft().setLeft(new TreeNode(1));
		rootNode.getRight().setLeft(new TreeNode(40));
		rootNode.getRight().setRight(new TreeNode(100));
		find(rootNode, 5, 45);
	}

	private static void find(TreeNode root, int i, int j) {
		if(root != null) {
			find(root.getLeft(), i, j);
			if(root.getData() >= i && root.getData() <= j) {
				System.out.print(root.getData() + " ");
			}
			find(root.getRight(), i, j);
		}
	}
	
}
