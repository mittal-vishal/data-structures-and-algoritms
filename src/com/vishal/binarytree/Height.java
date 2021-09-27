package com.vishal.binarytree;

public class Height {
	
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
		System.out.println(find(rootNode));
	}

	private static int find(TreeNode root) {
		if(root == null) {
			return 0;
		}else if(root.getLeft() == null && root.getRight() == null){
			return 1;
		}else{
			return 1 + Math.max(find(root.getLeft()), find(root.getRight()));
		}
	}
	
}
