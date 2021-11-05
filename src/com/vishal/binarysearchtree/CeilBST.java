package com.vishal.binarysearchtree;

public class CeilBST {
	
	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.left = new TreeNode(1);
		rootNode.right  = new TreeNode(7);
		rootNode.left.right = new TreeNode(2);
		rootNode.left.right.right = new TreeNode(3);
		System.out.println(find(rootNode, 3));
	}

	private static int find(TreeNode root, int item) {
		int result = -1;
		if(root.val > item) {
			result = root.val;
		}
		while(root != null) {
			if(root.val == item) {
				result = root.val;
				break;
			}
			else if(item > root.val) {
				root = root.right;
				if(root != null && root.val > item) {
					result = root.val;
				}
			}else {
				root = root.left;
				if(root != null && root.val > item && root.val < result) {
					result = root.val;
				}
			}
		}
		return result;
	}

}
