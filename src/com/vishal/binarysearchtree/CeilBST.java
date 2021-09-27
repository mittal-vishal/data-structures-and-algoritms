package com.vishal.binarysearchtree;

public class CeilBST {
	
	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.setLeft(new TreeNode(1));
		rootNode.setRight(new TreeNode(7));
		rootNode.getLeft().setRight(new TreeNode(2));
		rootNode.getLeft().getRight().setRight(new TreeNode(3));
		System.out.println(find(rootNode, 3));
	}

	private static int find(TreeNode root, int item) {
		int result = -1;
		if(root.getData() > item) {
			result = root.getData();
		}
		while(root != null) {
			if(root.getData() == item) {
				result = root.getData();
				break;
			}
			else if(item > root.getData()) {
				root = root.getRight();
				if(root != null && root.getData() > item) {
					result = root.getData();
				}
			}else {
				root = root.getLeft();
				if(root != null && root.getData() > item && root.getData() < result) {
					result = root.getData();
				}
			}
		}
		return result;
	}

}
