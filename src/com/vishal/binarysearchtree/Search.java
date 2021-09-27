package com.vishal.binarysearchtree;

public class Search {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(20));
		rootNode.getLeft().setRight(new TreeNode(4));
		rootNode.getRight().setLeft(new TreeNode(10));
		rootNode.getRight().setRight(new TreeNode(40));
		rootNode.getRight().getRight().setLeft(new TreeNode(30));
		System.out.println(find(rootNode, 30));
	}

	private static boolean find(TreeNode root, int item) {
		if (root == null) {
			return false;
		}else if(root.getData() == item) {
			return true;
		}else if(item > root.getData()) {
			return find(root.getRight(), item);
		}else {
			return find(root.getLeft(), item);
		}
	}

}
