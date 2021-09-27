package com.vishal.binarytree;

public class MaxDiffNodeAndAncestor {
	
	private static TreeNode rootNode = null;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		rootNode = new TreeNode(8);
		rootNode.setLeft(new TreeNode(3));
		rootNode.setRight(new TreeNode(10));
		rootNode.getLeft().setLeft(new TreeNode(1));
		rootNode.getLeft().setRight(new TreeNode(6));
		rootNode.getLeft().getRight().setLeft(new TreeNode(4));
		rootNode.getLeft().getRight().setRight(new TreeNode(7));
		rootNode.getRight().setRight(new TreeNode(14));
		rootNode.getRight().getRight().setLeft(new TreeNode(13));
		System.out.println(find(rootNode));
	}

	private static int find(TreeNode root) {
		if(root != null) {
			int leftT = find(root.getLeft());
			int rightT = find(root.getRight());
			if(root.getLeft() == null && root.getRight() == null) {
				return root.getData();
			}
			if(root.getData() - Math.min(leftT, rightT) > max) {
				max = root.getData() - Math.min(leftT, rightT);
			}
			if(root == rootNode)
				return max;
			else
				return Math.min(root.getData(), Math.min(leftT, rightT));
		}
		return Integer.MAX_VALUE;
	}

}
