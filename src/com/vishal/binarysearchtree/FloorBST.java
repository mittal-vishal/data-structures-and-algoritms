package com.vishal.binarysearchtree;

public class FloorBST {
	
	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(7);
		rootNode.left = new TreeNode(5);
		rootNode.right = new TreeNode(10);
		rootNode.left.left = new TreeNode(3);
		rootNode.left.right = new TreeNode(6);
		rootNode.right.left = new TreeNode(8);
		rootNode.right.right = new TreeNode(12);
		System.out.println(find(rootNode, 9).val);
	}

	private static TreeNode find(TreeNode root, int item) {
		if(root.val == item) {
			return root;
		}
		TreeNode result = null;
		while(root != null) {
			if(item > root.val) {
				root = root.right;
			}else if(item < root.val) {
				root = root.left;
				result = root;
			}else {
				result = root;
				break;
			}
		}
		return result;
	}
	
}
