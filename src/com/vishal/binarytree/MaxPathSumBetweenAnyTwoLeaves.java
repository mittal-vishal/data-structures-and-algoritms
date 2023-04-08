package com.vishal.binarytree;

public class MaxPathSumBetweenAnyTwoLeaves {

	private static TreeNode rootNode = null;
	private int maxSum;

	public static void main(String args[]) {
		rootNode = new TreeNode(10);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(10));
		rootNode.getLeft().setLeft(new TreeNode(20));
		rootNode.getLeft().setRight(new TreeNode(1));
		rootNode.getRight().setRight(new TreeNode(-25));
		rootNode.getRight().getRight().setLeft(new TreeNode(3));
		rootNode.getRight().getRight().setRight(new TreeNode(4));
		MaxPathSumBetweenAnyTwoLeaves pathSum = new MaxPathSumBetweenAnyTwoLeaves();
		System.out.println("maximum path sum is : " + pathSum.maxPathSum(rootNode));
	}

	public int maxPathSum(TreeNode root){
		this.maxSum = 0;
		postOrderTraversal(root);
		return maxSum;
	}

	private int postOrderTraversal(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftPathSum = postOrderTraversal(root.left);
		int rightPathSum = postOrderTraversal(root.right);

		if(root.left != null && root.right != null){
			int currSum = leftPathSum + rightPathSum + root.val;
			maxSum = Math.max(maxSum, currSum);
			return Math.max(leftPathSum, rightPathSum) + root.val;
		}else{
			return root.left == null ? rightPathSum + root.val: leftPathSum + root.val;
		}
	}

}
