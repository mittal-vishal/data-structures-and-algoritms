package com.vishal.binarytree;

public class PreOrder {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(10);
		rootNode.setLeft(new Node(4));
		rootNode.setRight(new Node(6));
		rootNode.getRight().setLeft(new Node(30));
		find(rootNode);
	}

	public static void find(Node root) {
		if(root != null){
			System.out.print(root.getData() + " ");
			find(root.getLeft());
			find(root.getRight());
		}
	}

}
