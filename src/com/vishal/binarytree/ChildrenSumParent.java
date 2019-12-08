package com.vishal.binarytree;

public class ChildrenSumParent {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(12);
		rootNode.setLeft(new Node(8));
		rootNode.setRight(new Node(4));
		rootNode.getLeft().setLeft(new Node(5));
		rootNode.getLeft().setRight(new Node(3));
		rootNode.getRight().setLeft(new Node(1));
		rootNode.getRight().setRight(new Node(3));
		rootNode.getLeft().getLeft().setLeft(new Node(3));
		rootNode.getLeft().getLeft().setRight(new Node(2));
		System.out.println(find(rootNode));
	}

	private static boolean find(Node root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null)) {
			return true;
		}
		int sum = 0;
		if (root.getLeft() != null) {
			sum = sum + root.getLeft().getData();
		}
		if (root.getRight() != null) {
			sum = sum + root.getRight().getData();
		}
		if (root.getData() == sum && find(root.getLeft()) && find(root.getRight())) {
			return true;
		} else {
			return false;
		}
	}

}
