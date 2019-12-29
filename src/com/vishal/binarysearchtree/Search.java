package com.vishal.binarysearchtree;

public class Search {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(5);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(20));
		rootNode.getLeft().setRight(new Node(4));
		rootNode.getRight().setLeft(new Node(10));
		rootNode.getRight().setRight(new Node(40));
		rootNode.getRight().getRight().setLeft(new Node(30));
		System.out.println(find(rootNode, 30));
	}

	private static boolean find(Node root, int item) {
		if (root == null) {
			return false;
		}else if(root.getData() == item) {
			return true;
		}else if(item > root.getData()) {
			return find(root.getRight(), item);
		}else {
			return find(root.getLeft(), item);
		}
	}

}
