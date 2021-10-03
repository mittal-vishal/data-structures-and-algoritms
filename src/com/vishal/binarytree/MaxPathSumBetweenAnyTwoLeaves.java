package com.vishal.binarytree;

public class MaxPathSumBetweenAnyTwoLeaves {
	
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
        System.out.println("maximum path sum is : " + findMaxSum(rootNode));
    }

	static class MaxPathSumBean{
		public int res;
	}
	
	private static int findMaxSum(TreeNode root) {
		MaxPathSumBean result = new MaxPathSumBean();
		result.res = Integer.MIN_VALUE;
		findMax(root, result);
		return result.res;
	}

	private static int findMax(TreeNode root, MaxPathSumBean result) {
		if(root == null)
			return 0;
		if(root.getLeft() == null && root.getRight() == null)
			return root.getVal();
		int left = findMax(root.getLeft(), result);
		int right = findMax(root.getRight(), result);
		if(root.getLeft() != null && root.getRight() != null) {
			result.res = Math.max(left + right + root.getVal(), result.res);
			return Math.max(left, right) + root.getVal();
		}
		return root.getLeft() != null ? left + root.getVal() : right + root.getVal();
	}

}
