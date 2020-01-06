package com.vishal.binarysearchtree;

public class KthSmallest {

	private static Node rootNode = null;
	private static int counter = 1;

	public static void main(String[] args) {
		rootNode = new Node(7);
		rootNode.setLeft(new Node(5));
		rootNode.setRight(new Node(10));
		rootNode.getLeft().setLeft(new Node(3));
		rootNode.getLeft().setRight(new Node(6));
		rootNode.getRight().setLeft(new Node(8));
		rootNode.getRight().setRight(new Node(12));
		find(rootNode, 2);
	}
	
	private static void find(Node root, int k) {
		if(root != null){
			find(root.getLeft(), k);
			if(counter == k){
				System.out.print(root.getData());
			}
			counter++;
			find(root.getRight(), k);
		}
    }
	
}
