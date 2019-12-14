package com.vishal.binarytree;

public class PathToGivenNode {

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
		System.out.println(find(rootNode, 12));
	}

	private static boolean find(Node root, int n) {
		if(root == null) {
			return false;
		}
		if(root.getData() == n) {
			System.out.print(root.getData() + " ");
			return true;
		}
		if(find(root.getLeft(), n) || find(root.getRight(), n)) {
			System.out.print(root.getData() + " ");
			return true;
		}
		return false;
	}

}
