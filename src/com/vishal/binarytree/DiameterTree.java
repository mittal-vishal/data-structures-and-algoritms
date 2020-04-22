package com.vishal.binarytree;

public class DiameterTree {

	private static Node rootNode = null;
	
	public static void main(String[] args) {
		rootNode = new Node(1);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(3));
		rootNode.getLeft().setLeft(new Node(34));
		rootNode.getLeft().setRight(new Node(4));
		rootNode.getRight().setLeft(new Node(13));
		rootNode.getRight().setRight(new Node(40));
		rootNode.getLeft().getLeft().setLeft(new Node(10));
		rootNode.getLeft().getLeft().setRight(new Node(12));
		System.out.println(diameterOfBinaryTree(rootNode));
	}
	
    private static int diameterOfBinaryTree(Node root){
        if(root == null){
            return 0;
        }else{
            int option1 = height(root.getLeft()) + height(root.getRight());
            int option2 = diameterOfBinaryTree(root.getLeft());
            int option3 = diameterOfBinaryTree(root.getRight());
            return Math.max(option1, Math.max(option2, option3));
        }
    }
    private static int height(Node root) {
		if(root == null) {
			return 0;
		}else {
			int left = height(root.getLeft());
			int right = height(root.getRight());
			return Math.max(left, right) + 1;
		}
	}
	
}
