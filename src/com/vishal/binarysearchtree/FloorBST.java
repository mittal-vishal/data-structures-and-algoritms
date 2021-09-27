package com.vishal.binarysearchtree;

public class FloorBST {
	
	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(7);
		rootNode.setLeft(new TreeNode(5));
		rootNode.setRight(new TreeNode(10));
		rootNode.getLeft().setLeft(new TreeNode(3));
		rootNode.getLeft().setRight(new TreeNode(6));
		rootNode.getRight().setLeft(new TreeNode(8));
		rootNode.getRight().setRight(new TreeNode(12));
		System.out.println(find(rootNode, 9).getData());
	}

	private static TreeNode find(TreeNode root, int item) {
		if(root.getData() == item) {
			return root;
		}
		TreeNode result = null;
		while(root != null) {
			if(item > root.getData()) {
				root = root.getRight();
			}else if(item < root.getData()) {
				root = root.getLeft();
				result = root;
			}else {
				result = root;
				break;
			}
		}
		return result;
	}
	
}
