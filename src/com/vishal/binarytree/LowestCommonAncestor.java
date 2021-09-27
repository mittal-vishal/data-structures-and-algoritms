package com.vishal.binarytree;

public class LowestCommonAncestor {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(null);
		rootNode.getLeft().setLeft(new TreeNode(1));
		rootNode.getLeft().setRight(new TreeNode(10));
		System.out.println(find(rootNode, 1, 10).getData());
	}

	private static TreeNode find(TreeNode node, int n1, int n2) {
		if (node == null)
			return null;

		if (node.getData() == n1 || node.getData() == n2)
			return node;

		TreeNode left = find(node.getLeft(), n1, n2);
		TreeNode right = find(node.getRight(), n1, n2);

		if (left != null && right != null)
			return node;
		
		return left != null ? left : right;
	}

}
