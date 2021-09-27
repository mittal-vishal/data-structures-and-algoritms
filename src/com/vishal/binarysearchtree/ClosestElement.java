package com.vishal.binarysearchtree;

public class ClosestElement {

	private static TreeNode rootNode = null;
	private static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		rootNode = new TreeNode(82);
		rootNode.setLeft(new TreeNode(49));
		rootNode.setRight(new TreeNode(94));
		rootNode.getLeft().setLeft(new TreeNode(6));
		rootNode.getLeft().setRight(new TreeNode(51));
		rootNode.getLeft().getRight().setRight(new TreeNode(69));
		rootNode.getLeft().getLeft().setRight(new TreeNode(13));
		System.out.println(find(rootNode, 27));
	}

	private static int find(TreeNode root, int item) {
		if(root != null) {
			if(Math.abs(item - root.getData()) < result){
				result = Math.abs(item - root.getData());
			}
			find(root.getLeft(), item);
			find(root.getRight(), item);
		}
		return result;
	}
	
}
