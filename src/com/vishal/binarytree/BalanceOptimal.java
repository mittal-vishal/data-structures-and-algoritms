package com.vishal.binarytree;

public class BalanceOptimal {

	private static Node rootNode = null;
	
	public static void main(String[] args) {
		rootNode = new Node(1);
		rootNode.setLeft(new Node(2));
		rootNode.getLeft().setLeft(new Node(3));
		rootNode.getLeft().getLeft().setLeft(new Node(4));
		System.out.println(find(rootNode));
	}

	private static boolean find(Node root) {
		if(getBalance(root) == -1) {
			return false;
		}else {
			return true;
		}
	}
	
	private static int getBalance(Node node) {
		if(node == null) {
			return 0;
		}
		int leftT = getBalance(node.getLeft());
		int rightT = getBalance(node.getRight());
		if(leftT == -1 || rightT == -1)
			return -1;
		if(Math.abs(leftT - rightT) > 1) {
			return -1;
		}
		return Math.max(leftT, rightT) + 1;
	}
	
}
