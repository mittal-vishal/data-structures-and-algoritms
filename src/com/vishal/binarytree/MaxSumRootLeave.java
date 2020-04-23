package com.vishal.binarytree;

public class MaxSumRootLeave {

private static Node rootNode = null;
	
	public static void main(String args[]) { 
        rootNode = new Node(10); 
        rootNode.setLeft(new Node(-2)); 
        rootNode.setRight(new Node(7)); 
        rootNode.getLeft().setLeft(new Node(8));
        rootNode.getLeft().setRight(new Node(-4));
        System.out.println("maximum path sum is : " + findMaxSum(rootNode));
    }

	private static int findMaxSum(Node root) {
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
