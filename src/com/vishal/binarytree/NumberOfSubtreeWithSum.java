package com.vishal.binarytree;

public class NumberOfSubtreeWithSum {
	
	private static TreeNode rootNode = null;
	private static int count = 0;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.setLeft(new TreeNode(-10));
		rootNode.setRight(new TreeNode(3));
		rootNode.getLeft().setLeft(new TreeNode(9));
		rootNode.getLeft().setRight(new TreeNode(8));
		rootNode.getRight().setLeft(new TreeNode(-4));
		rootNode.getRight().setRight(new TreeNode(7));
		System.out.println(find(rootNode, 7));
	}

	private static int find(TreeNode root, int sum) {
		if(root != null) {
			int leftT = find(root.getLeft(), sum);
			int rightT = find(root.getRight(), sum);
			if(root.getLeft() == null && root.getRight() == null && root.getVal() == sum) {
				count++;
			}
			if(root.getLeft() == null && root.getRight() == null) {
				return root.getVal();
			}
			if(leftT + rightT + root.getVal() == sum) {
				count++;
			}
			if(root != rootNode) {
				return leftT + rightT + root.getVal();
			}
		}
		return count;
	}
	
}
