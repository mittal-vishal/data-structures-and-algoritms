package com.vishal.binarysearchtree;

public class Search {

	private static boolean find(TreeNode root, int item) {
		if (root == null) {
			return false;
		}else if(root.val == item) {
			return true;
		}else if(item > root.val) {
			return find(root.right, item);
		}else {
			return find(root.left, item);
		}
	}

}
