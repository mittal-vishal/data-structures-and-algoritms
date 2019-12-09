package com.vishal.binarytree;

public class PrintKLevel {

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
		int k = 2;
		find(rootNode, k);
	}

	private static void find(Node root, int k) {
		if(root == null){
			System.out.print(-1);
		}else if(k == 0) {
			System.out.print(root.getData() + " ");
		}else {
			find(root.getLeft(), k-1);
			find(root.getRight(), k-1);
		}
	}
	
}
