package com.vishal.binarysearchtree;

public class Insert {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(5);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(20));
		rootNode.getLeft().setRight(new Node(4));
		rootNode.getRight().setLeft(new Node(10));
		rootNode.getRight().setRight(new Node(40));
		rootNode.getRight().getRight().setLeft(new Node(30));
		insert(rootNode, 15);
		PreOrder.find(rootNode);
	}

	private static Node insert(Node root, int item) {
		if (root == null) {
			return new Node(item);
		}else if(item > root.getData()) {
			root.setRight(insert(root.getRight(), item));
		}else {
			root.setLeft(insert(root.getLeft(), item));
		}
		return root;
	}
	
}
