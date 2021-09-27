package com.vishal.binarysearchtree;

public class KthSmallest {

	private static TreeNode rootNode = null;
	private static int counter = 1;

	public static void main(String[] args) {
		rootNode = new TreeNode(7);
		rootNode.setLeft(new TreeNode(5));
		rootNode.setRight(new TreeNode(10));
		rootNode.getLeft().setLeft(new TreeNode(3));
		rootNode.getLeft().setRight(new TreeNode(6));
		rootNode.getRight().setLeft(new TreeNode(8));
		rootNode.getRight().setRight(new TreeNode(12));
		find(rootNode, 2);
	}
	
	private static void find(TreeNode root, int k) {
		if(root != null){
			find(root.getLeft(), k);
			if(counter == k){
				System.out.print(root.getData());
			}
			counter++;
			find(root.getRight(), k);
		}
    }
	
}
