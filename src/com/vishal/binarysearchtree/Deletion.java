package com.vishal.binarysearchtree;

public class Deletion {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.left = new TreeNode(2);
		rootNode.right = new TreeNode(20);
		rootNode.right.left = new TreeNode(10);
		rootNode.right.right = new TreeNode(40);
		find(rootNode, 20);
	}

	private static TreeNode find(TreeNode root, int item) {
		if (root == null) {
			return null;
		}else if(item > root.val) {
			root.right = find(root.right, item);
		}else if(item < root.val){
			root.left = find(root.left, item);
		}else {
			if(root.left == null && root.right == null) {
				return null;
			}else if(root.left == null) {
				return root.right;
			}else if(root.right == null) {
				return root.left;
			}else {
				TreeNode successor = getInorderSuccessor(root);
				root.val = successor.val;
				root.right =  find(root.right, successor.val);
			}
		}
		return root;
	}

	private static TreeNode getInorderSuccessor(TreeNode root) {
		TreeNode currNode = root.right;
		while(currNode.left != null) {
			currNode = currNode.left;
		}
		return currNode;
	}
	
}
