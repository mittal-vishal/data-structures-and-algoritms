package com.vishal.binarytree;

public class MaxSumRootLeave {

private static TreeNode rootNode = null;
	
	public static void main(String args[]) { 
        rootNode = new TreeNode(10);
        rootNode.setLeft(new TreeNode(-2));
        rootNode.setRight(new TreeNode(7));
        rootNode.getLeft().setLeft(new TreeNode(8));
        rootNode.getLeft().setRight(new TreeNode(-4));
        System.out.println("maximum path sum is : " + findMaxSum(rootNode));
    }

	private static int findMaxSum(TreeNode root) {
		if(root == null) {
			return 0;
		}else if(root.left == null && root.right == null){
			return root.data;
		}else {
			int left = findMaxSum(root.left);
			int right = findMaxSum(root.right);
			return root.data + Math.max(left, right);
		}
	}
	
}
