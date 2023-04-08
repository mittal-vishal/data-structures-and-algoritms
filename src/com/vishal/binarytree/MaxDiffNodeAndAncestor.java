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
		System.out.println(maxAncestorDiff(rootNode));
	}

	public static int maxAncestorDiff(TreeNode root) {
		if(root == null){
			return 0;
		}
		return dfs(root, root.val, root.val);
	}

	private static int dfs(TreeNode root, int currMin, int currMax){
		if(root == null){
			return currMax - currMin;
		}
		currMax = Math.max(currMax, root.val);
		currMin = Math.min(currMin, root.val);
		int left = dfs(root.left, currMin, currMax);
		int right = dfs(root.right, currMin, currMax);
		return Math.max(left, right);
	}

}
