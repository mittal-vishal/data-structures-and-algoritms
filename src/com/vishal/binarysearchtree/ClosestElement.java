package com.vishal.binarysearchtree;

public class ClosestElement {

	private static Node rootNode = null;
	private static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		rootNode = new Node(82);
		rootNode.setLeft(new Node(49));
		rootNode.setRight(new Node(94));
		rootNode.getLeft().setLeft(new Node(6));
		rootNode.getLeft().setRight(new Node(51));
		rootNode.getLeft().getRight().setRight(new Node(69));
		rootNode.getLeft().getLeft().setRight(new Node(13));
		System.out.println(find(rootNode, 27));
	}

	private static int find(Node root, int item) {
		if(root != null) {
			if(Math.abs(item - root.getData()) < result){
				result = Math.abs(item - root.getData());
			}
			find(root.getLeft(), item);
			find(root.getRight(), item);
		}
		return result;
	}
	
}
