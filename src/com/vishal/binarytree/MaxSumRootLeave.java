package com.vishal.binarytree;

public class MaxSumRootLeave {

private static TreeNode rootNode = null;
	
	public static void main(String args[]) { 
        rootNode = new TreeNode(1);
        rootNode.setLeft(new TreeNode(2));
        rootNode.setRight(new TreeNode(3));
        rootNode.getLeft().setLeft(new TreeNode(8));
        rootNode.getLeft().setRight(new TreeNode(4));
		rootNode.getLeft().getRight().setLeft(new TreeNode(10));
		rootNode.getRight().setLeft(new TreeNode(5));
		rootNode.getRight().setRight(new TreeNode(6));
		rootNode.getRight().getLeft().setLeft(new TreeNode(7));
		rootNode.getRight().getLeft().setRight(new TreeNode(9));
		rootNode.getRight().getRight().setRight(new TreeNode(5));
        System.out.println("maximum path sum is : " + findMaxSum(rootNode));
    }

	private static int findMaxSum(TreeNode root) {
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return root.val;
		}
		int left = findMaxSum(root.left);
		int right = findMaxSum(root.right);
		return root.val + Math.max(left, right);
	}
	
}
