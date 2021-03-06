package com.vishal.binarytree;

public class MaxPathSumBetweenAnyTwoLeaves {
	
	private static Node rootNode = null;
	
	public static void main(String args[]) { 
        rootNode = new Node(10); 
        rootNode.setLeft(new Node(2)); 
        rootNode.setRight(new Node(10)); 
        rootNode.getLeft().setLeft(new Node(20));
        rootNode.getLeft().setRight(new Node(1));
        rootNode.getRight().setRight(new Node(-25));
        rootNode.getRight().getRight().setLeft(new Node(3));
        rootNode.getRight().getRight().setRight(new Node(4));
        System.out.println("maximum path sum is : " + findMaxSum(rootNode));
    }

	static class MaxPathSumBean{
		public int res;
	}
	
	private static int findMaxSum(Node root) {
		MaxPathSumBean result = new MaxPathSumBean();
		result.res = Integer.MIN_VALUE;
		findMax(root, result);
		return result.res;
	}

	private static int findMax(Node root, MaxPathSumBean result) {
		if(root == null)
			return 0;
		if(root.getLeft() == null && root.getRight() == null)
			return root.getData();
		int left = findMax(root.getLeft(), result);
		int right = findMax(root.getRight(), result);
		if(root.getLeft() != null && root.getRight() != null) {
			result.res = Math.max(left + right + root.getData(), result.res);
			return Math.max(left, right) + root.getData();
		}
		return root.getLeft() != null ? left + root.getData() : right + root.getData();
	}

}
