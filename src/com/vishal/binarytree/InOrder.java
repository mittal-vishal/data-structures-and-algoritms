package com.vishal.binarytree;

public class InOrder {
	
	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(10);
		rootNode.setLeft(new Node(4));
		rootNode.setRight(new Node(6));
		rootNode.getRight().setLeft(new Node(30));
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
