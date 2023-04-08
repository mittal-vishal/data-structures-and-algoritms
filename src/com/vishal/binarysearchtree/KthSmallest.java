package com.vishal.binarysearchtree;

public class KthSmallest {

	private static TreeNode rootNode = null;
	private int kSmallest;
	private int kCount;

	public static void main(String[] args) {
		rootNode = new TreeNode(7);
		rootNode.left = new TreeNode(5);
		rootNode.right = new TreeNode(10);
		rootNode.left.left = new TreeNode(3);
		rootNode.left.right = new TreeNode(6);
		rootNode.right.left = new TreeNode(8);
		rootNode.right.right = new TreeNode(12);
		KthSmallest smallest = new KthSmallest();
		smallest.kthSmallest(rootNode, 2);
	}

	public int kthSmallest(TreeNode root, int k) {
		this.kCount = k;
		this.kSmallest = -1;
		inorder(root);
		return kSmallest;
	}

	private void inorder(TreeNode root){
		if(root == null){
			return;
		}
		inorder(root.left);
		if(kCount == 1){
			kSmallest = root.val;
		}
		kCount--;
		inorder(root.right);
	}
	
}
