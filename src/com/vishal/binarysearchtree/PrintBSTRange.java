package com.vishal.binarysearchtree;

public class PrintBSTRange {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(10);
		rootNode.setLeft(new Node(5));
		rootNode.setRight(new Node(50));
		rootNode.getLeft().setLeft(new Node(1));
		rootNode.getRight().setLeft(new Node(40));
		rootNode.getRight().setRight(new Node(100));
		find(rootNode, 5, 45);
	}

	private static void find(Node root, int i, int j) {
		if(root != null) {
			find(root.getLeft(), i, j);
			if(root.getData() >= i && root.getData() <= j) {
				System.out.print(root.getData() + " ");
			}
			find(root.getRight(), i, j);
		}
	}
	
}
