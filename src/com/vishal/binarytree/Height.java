package com.vishal.binarytree;

public class Height {
	
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
		System.out.println(find(rootNode));
	}

	private static int find(Node root) {
		if(root == null) {
			return 0;
		}else {
			int left = find(root.getLeft());
			int right = find(root.getRight());
			return (left > right ? left : right) + 1;
		}
	}
	
}
