package com.vishal.binarysearchtree;

public class KthSmallest {

	private static TreeNode rootNode = null;
	private static int counter = 1;

	public static void main(String[] args) {
		rootNode = new TreeNode(7);
		rootNode.left = new TreeNode(5);
		rootNode.right = new TreeNode(10);
		rootNode.left.left = new TreeNode(3);
		rootNode.left.right = new TreeNode(6);
		rootNode.right.left = new TreeNode(8);
		rootNode.right.right = new TreeNode(12);
		find(rootNode, 2);
	}
	
	private static void find(TreeNode root, int k) {
		if(root != null){
			find(root.left, k);
			if(counter == k){
				System.out.print(root.val);
			}
			counter++;
			find(root.right, k);
		}
    }
	
}
