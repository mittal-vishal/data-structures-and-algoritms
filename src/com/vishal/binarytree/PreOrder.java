package com.vishal.binarytree;

public class PreOrder {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(1);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(3));
		rootNode.getLeft().setLeft(new TreeNode(4));
		rootNode.getLeft().setRight(new TreeNode(5));
		rootNode.getRight().setLeft(new TreeNode(6));
		rootNode.getRight().setRight(new TreeNode(7));
		find(rootNode);
	}

	public static void find(TreeNode root) {
		if(root != null){
			System.out.print(root.getVal() + " ");
			find(root.getLeft());
			find(root.getRight());
		}
	}

}
