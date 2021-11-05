package com.vishal.binarytree;

public class MaxPathSum {

	private int maxPathSum;

	public int maxPathSum(TreeNode root) {
		maxPathSum = Integer.MIN_VALUE;
		postOrderTraversal(root);
		return maxPathSum;
	}

	private int postOrderTraversal(TreeNode root){
		if(root == null){
			return 0;
		}
		int maxPathSumFromLeft = postOrderTraversal(root.left);
		int maxPathSumFromRight = postOrderTraversal(root.right);
		maxPathSumFromLeft = maxPathSumFromLeft < 0 ? 0: maxPathSumFromLeft;
		maxPathSumFromRight = maxPathSumFromRight < 0 ? 0: maxPathSumFromRight;
		int currPathSum = maxPathSumFromLeft + maxPathSumFromRight + root.val;
		maxPathSum = Math.max(maxPathSum, currPathSum);
		return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + root.val;
	}

	private static TreeNode rootNode = null;

	public static void main(String args[]) {
        rootNode = new TreeNode(10);
        rootNode.setLeft(new TreeNode(2));
        rootNode.setRight(new TreeNode(10));
        rootNode.getLeft().setLeft(new TreeNode(20));
        rootNode.getLeft().setRight(new TreeNode(1));
        rootNode.getRight().setRight(new TreeNode(-25));
        rootNode.getRight().getRight().setLeft(new TreeNode(3));
        rootNode.getRight().getRight().setRight(new TreeNode(4));
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println("maximum path sum is : " + maxPathSum.maxPathSum(rootNode));
    }

}
