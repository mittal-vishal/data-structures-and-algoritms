package com.vishal.binarytree;

public class InOrder {
	
	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(1);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(3));
		rootNode.getLeft().setLeft(new Node(4));
		rootNode.getLeft().setRight(new Node(5));
		rootNode.getRight().setLeft(new Node(6));
		rootNode.getRight().setRight(new Node(7));
		find(rootNode);
	}

	private static void find(Node root) {
		if(root != null){
			find(root.getLeft());
			System.out.print(root.getData() + " ");
			find(root.getRight());
		}
	}
	
}
