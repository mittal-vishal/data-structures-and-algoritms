package com.vishal.binarysearchtree;

public class PreOrder {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(10);
		rootNode.setLeft(new TreeNode(4));
		rootNode.setRight(new TreeNode(6));
		rootNode.getRight().setLeft(new TreeNode(30));
		find(rootNode);
	}

	public static void find(TreeNode root) {
		if(root != null){
			System.out.print(root.getData() + " ");
			find(root.getLeft());
			find(root.getRight());
		}
	}

}
