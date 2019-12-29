package com.vishal.binarysearchtree;

public class CeilBST {
	
	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(5);
		rootNode.setLeft(new Node(1));
		rootNode.setRight(new Node(7));
		rootNode.getLeft().setRight(new Node(2));
		rootNode.getLeft().getRight().setRight(new Node(3));
		System.out.println(find(rootNode, 3));
	}

	private static int find(Node root, int item) {
		int result = -1;
		if(root.getData() > item) {
			result = root.getData();
		}
		while(root != null) {
			if(root.getData() == item) {
				result = root.getData();
				break;
			}
			else if(item > root.getData()) {
				root = root.getRight();
				if(root != null && root.getData() > item) {
					result = root.getData();
				}
			}else {
				root = root.getLeft();
				if(root != null && root.getData() > item && root.getData() < result) {
					result = root.getData();
				}
			}
		}
		return result;
	}

}
