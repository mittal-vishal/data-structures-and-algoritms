package com.vishal.binarysearchtree;

import com.vishal.binarytree.Node;

public class BstOrNot {
	
	private static Node rootNode = null;
	private static Node prevNode = null;

	public static void main(String[] args) {
		rootNode = new Node(5);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(20));
		rootNode.getLeft().setRight(new Node(4));
		rootNode.getRight().setLeft(new Node(10));
		rootNode.getRight().setRight(new Node(40));
		rootNode.getRight().getRight().setLeft(new Node(30));
		System.out.println(find(rootNode));
	}

	private static boolean find(Node root) {
		if(root != null){
			if(!find(root.getLeft())) {
				return false;
			}
			if(prevNode != null && root.getData() < prevNode.getData()) {
				return false;
			}
			prevNode = root;
			if(!find(root.getRight())) {
				return false;
			}
		}
		return true;
	}
	
}
