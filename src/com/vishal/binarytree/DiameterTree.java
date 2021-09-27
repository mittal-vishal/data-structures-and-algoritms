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
		System.out.println(diameterOfBinaryTree(rootNode));
	}
	
    private static int diameterOfBinaryTree(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int option1 = height(root.getLeft()) + height(root.getRight());
            int option2 = diameterOfBinaryTree(root.getLeft());
            int option3 = diameterOfBinaryTree(root.getRight());
            return Math.max(option1, Math.max(option2, option3));
        }
    }
    private static int height(TreeNode root) {
		if(root == null) {
			return 0;
		}else {
			int left = height(root.getLeft());
			int right = height(root.getRight());
			return Math.max(left, right) + 1;
		}
	}
	
}
