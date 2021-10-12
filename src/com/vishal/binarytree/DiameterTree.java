package com.vishal.binarytree;

public class DiameterTree {

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
		DiameterTree diameterTree = new DiameterTree();
		System.out.println(diameterTree.diameterOfBinaryTree(rootNode));
	}

	private int diameter;
	public int diameterOfBinaryTree(TreeNode root) {
		diameter = 0;
		calculateHeight(root);
		return diameter;
	}

	private int calculateHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		int leftHeight = calculateHeight(root.left);
		int rightHeight = calculateHeight(root.right);
		if(leftHeight != 0 || rightHeight != 0){
			int currDiameter = leftHeight + rightHeight;
			diameter = Math.max(diameter, currDiameter);
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
}
