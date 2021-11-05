package com.vishal.binarysearchtree;

public class ClosestElement {

	private static TreeNode rootNode = null;
	private static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		rootNode = new TreeNode(82);
		rootNode.left = new TreeNode(49);
		rootNode.right = new TreeNode(94);
		rootNode.left.left = new TreeNode(6);
		rootNode.left.right = new TreeNode(51);
		rootNode.left.right.right = new TreeNode(69);
		rootNode.left.left.right = new TreeNode(13);
		System.out.println(find(rootNode, 27));
	}

	private static int find(TreeNode root, int item) {
		if(root != null) {
			if(Math.abs(item - root.val) < result){
				result = Math.abs(item - root.val);
			}
			find(root.left, item);
			find(root.right, item);
		}
		return result;
	}
	
}
