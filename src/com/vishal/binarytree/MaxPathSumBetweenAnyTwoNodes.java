package com.vishal.binarytree;

public class MaxPathSumBetweenAnyTwoNodes {
	
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
		if(root.getLeft() == null && root.getRight() == null) {
			return root.getData();
		}
		int left = findMax(root.getLeft(), result);
		int right = findMax(root.getRight(), result);
		int singleNodeMax = Math.max(Math.max(left + root.getData(), right + root.getData()), root.getData());
		int doubleNodeMax = Math.max(singleNodeMax, left + right + root.getData());
		result.res = Math.max(result.res, doubleNodeMax);
		return singleNodeMax;
	}

}
