package com.vishal.binarytree;

public class Balance {

private static TreeNode rootNode = null;
	
	public static void main(String[] args) {
		rootNode = new TreeNode(1);
		rootNode.setLeft(new TreeNode(2));
		rootNode.getLeft().setLeft(new TreeNode(23));
		System.out.println(find(rootNode));
	}

	private static boolean find(TreeNode root) {
		if((root == null) || (root.getLeft() == null && root.getRight() == null)){
			return true;
		}else {
			int leftTree = height(root.getLeft());
			int rightTree = height(root.getRight());
			if(Math.abs(leftTree - rightTree) > 1) {
				return false;
			}
			if(find(root.getLeft()) && find(root.getRight())) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	private static int height(TreeNode node) {
		if(node == null) {
			return 0;
		}else {
			int left = height(node.getLeft());
			int right = height(node.getRight());
			return Math.max(left, right) + 1;
		}
	}
	
}
