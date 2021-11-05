package com.vishal.binarysearchtree;

public class MinElementBST {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(7);
		rootNode.left = new TreeNode(5);
		rootNode.right = new TreeNode(10);
		rootNode.left.left = new TreeNode(3);
		rootNode.left.right  = new TreeNode(6);
		rootNode.right.left = new TreeNode(8);
		rootNode.right.right = new TreeNode(12);
		System.out.println(find(rootNode));
	}
	
	private static int find(TreeNode node) {
        while(node.left != null){
            node = node.left;
        }
        return node.val;
    }
	
}
