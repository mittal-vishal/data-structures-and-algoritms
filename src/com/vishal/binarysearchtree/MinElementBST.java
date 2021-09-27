package com.vishal.binarysearchtree;

public class MinElementBST {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(7);
		rootNode.setLeft(new TreeNode(5));
		rootNode.setRight(new TreeNode(10));
		rootNode.getLeft().setLeft(new TreeNode(3));
		rootNode.getLeft().setRight(new TreeNode(6));
		rootNode.getRight().setLeft(new TreeNode(8));
		rootNode.getRight().setRight(new TreeNode(12));
		System.out.println(find(rootNode));
	}
	
	private static int find(TreeNode node) {
        while(node.getLeft() != null){
            node = node.getLeft();
        }
        return node.getData();
    }
	
}
