package com.vishal.binarytree;

public class PrintKLevel {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(1);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(3));
		rootNode.getLeft().setLeft(new TreeNode(34));
		rootNode.getLeft().setRight(new TreeNode(4));
		rootNode.getRight().setLeft(new TreeNode(13));
		rootNode.getRight().setRight(new TreeNode(40));
		rootNode.getLeft().getLeft().setLeft(new TreeNode(10));
		rootNode.getLeft().getLeft().setRight(new TreeNode(12));
		int k = 3;
		find(rootNode, k);
	}

	private static void find(TreeNode root, int k) {
		if(root == null){
			System.out.print(-1);
		}else if(k == 0) {
			System.out.print(root.getData() + " ");
		}else {
			find(root.getLeft(), k-1);
			find(root.getRight(), k-1);
		}
	}
	
}
