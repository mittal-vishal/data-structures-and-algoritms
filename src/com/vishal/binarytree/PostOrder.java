package com.vishal.binarytree;

public class PostOrder {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(26);
		rootNode.setLeft(new Node(10));
		rootNode.getLeft().setLeft(new Node(4));
		rootNode.getLeft().setRight(new Node(6));
		rootNode.getLeft().getRight().setLeft(new Node(30));
		rootNode.setRight(new Node(3));
		rootNode.getRight().setRight(new Node(13));
		find(rootNode);
	}

	private static void find(Node root) {
		if(root != null) {
			find(root.getLeft());
			find(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}

}
