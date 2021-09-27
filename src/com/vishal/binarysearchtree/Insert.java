package com.vishal.binarysearchtree;

public class Insert {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(20));
		rootNode.getLeft().setRight(new TreeNode(4));
		rootNode.getRight().setLeft(new TreeNode(10));
		rootNode.getRight().setRight(new TreeNode(40));
		rootNode.getRight().getRight().setLeft(new TreeNode(30));
		insert(rootNode, 15);
		PreOrder.find(rootNode);
	}

	private static TreeNode insert(TreeNode root, int item) {
		if (root == null) {
			return new TreeNode(item);
		}else if(item > root.getData()) {
			root.setRight(insert(root.getRight(), item));
		}else {
			root.setLeft(insert(root.getLeft(), item));
		}
		return root;
	}
	
}
