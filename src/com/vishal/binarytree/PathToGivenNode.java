package com.vishal.binarytree;

public class PathToGivenNode {

	private static TreeNode rootNode = null;
	
	public static void main(String[] args) {
		rootNode = new TreeNode(1);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(3));
		rootNode.getLeft().setLeft(new TreeNode(34));
		rootNode.getLeft().setRight(new TreeNode(4));
		rootNode.getRight().setLeft(new TreeNode(13));
		rootNode.getRight().setRight(new TreeNode(40));
		rootNode.getLeft().getLeft().setLeft(new TreeNode(10));
		rootNode.getLeft().getLeft().setRight(new TreeNode(12));
		System.out.println(find(rootNode, 12));
	}

	private static boolean find(TreeNode root, int n) {
		if(root == null) {
			return false;
		}
		if(root.getData() == n) {
			System.out.print(root.getData() + " ");
			return true;
		}
		if(find(root.getLeft(), n) || find(root.getRight(), n)) {
			System.out.print(root.getData() + " ");
			return true;
		}
		return false;
	}

}
