package com.vishal.binarytree;

public class Mirror {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(1);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(3));
		rootNode.getLeft().setLeft(new Node(34));
		rootNode.getLeft().setRight(new Node(4));
		PreOrder.find(rootNode);
		find(rootNode);
		System.out.println();
		PreOrder.find(rootNode);
	}

	private static void find(Node root) {
		Node temp = null;
		if(root != null && (root.getLeft() != null || root.getRight() != null)) {
			find(root.getLeft());
			find(root.getRight());
			temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
	}
	
}
