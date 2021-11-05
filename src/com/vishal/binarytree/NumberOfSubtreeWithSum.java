package com.vishal.binarytree;

public class NumberOfSubtreeWithSum {
	
	private static TreeNode rootNode = null;
	private  int count;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.setLeft(new TreeNode(-10));
		rootNode.setRight(new TreeNode(3));
		rootNode.getLeft().setLeft(new TreeNode(9));
		rootNode.getLeft().setRight(new TreeNode(8));
		rootNode.getRight().setLeft(new TreeNode(-4));
		rootNode.getRight().setRight(new TreeNode(7));
		NumberOfSubtreeWithSum subtree = new NumberOfSubtreeWithSum();
		System.out.println(subtree.countSubtree(rootNode, 7));
	}

	public int countSubtree(TreeNode root, int k){
		int leftSum = getSum(root.left, k);
		int rightSum = getSum(root.right, k);
		int sum = leftSum + rightSum + root.val;
		if(sum == k){
			count++;
		}
		return count;
	}

	private int getSum(TreeNode root, int k){
		if(root == null){
			return 0;
		}
		int leftSum = getSum(root.left, k);
		int rightSum = getSum(root.right, k);
		int sum = leftSum + rightSum + root.val;
		if(sum == k){
			count++;
		}
		return sum;
	}

}
