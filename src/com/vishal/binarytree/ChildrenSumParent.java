package com.vishal.binarytree;

public class ChildrenSumParent {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(12);
		rootNode.setLeft(new TreeNode(8));
		rootNode.setRight(new TreeNode(4));
		rootNode.getLeft().setLeft(new TreeNode(5));
		rootNode.getLeft().setRight(new TreeNode(3));
		rootNode.getRight().setLeft(new TreeNode(1));
		rootNode.getRight().setRight(new TreeNode(3));
		rootNode.getLeft().getLeft().setLeft(new TreeNode(3));
		rootNode.getLeft().getLeft().setRight(new TreeNode(2));
		System.out.println(find(rootNode));
	}

	private static boolean find(TreeNode root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null)) {
			return true;
		}
		int sum = 0;
		if (root.getLeft() != null) {
			sum = sum + root.getLeft().getData();
		}
		if (root.getRight() != null) {
			sum = sum + root.getRight().getData();
		}
		if (root.getData() == sum && find(root.getLeft()) && find(root.getRight())) {
			return true;
		} else {
			return false;
		}
	}

}
