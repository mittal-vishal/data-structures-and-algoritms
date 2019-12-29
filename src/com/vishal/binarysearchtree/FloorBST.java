package com.vishal.binarysearchtree;

public class FloorBST {
	
	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(7);
		rootNode.setLeft(new Node(5));
		rootNode.setRight(new Node(10));
		rootNode.getLeft().setLeft(new Node(3));
		rootNode.getLeft().setRight(new Node(6));
		rootNode.getRight().setLeft(new Node(8));
		rootNode.getRight().setRight(new Node(12));
		System.out.println(find(rootNode, 9).getData());
	}

	private static Node find(Node root, int item) {
		if(root.getData() == item) {
			return root;
		}
		Node result = null;
		while(root != null) {
			if(item > root.getData()) {
				root = root.getRight();
			}else if(item < root.getData()) {
				root = root.getLeft();
				result = root;
			}else {
				result = root;
				break;
			}
		}
		return result;
	}
	
}
