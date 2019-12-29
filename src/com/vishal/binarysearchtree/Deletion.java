package com.vishal.binarysearchtree;

public class Deletion {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(5);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(20));
		rootNode.getRight().setLeft(new Node(10));
		rootNode.getRight().setRight(new Node(40));
		find(rootNode, 20);
		PreOrder.find(rootNode);
	}

	private static Node find(Node root, int item) {
		if (root == null) {
			return null;
		}else if(item > root.getData()) {
			root.setRight(find(root.getRight(), item));
		}else if(item < root.getData()){
			root.setLeft(find(root.getLeft(), item));
		}else {
			if(root.getLeft()==null && root.getRight() == null) {
				return null;
			}else if(root.getLeft() == null) {
				return root.getRight();
			}else if(root.getRight() == null) {
				return root.getLeft();
			}else {
				Node successor = getInorderSuccessor(root);
				root.setData(successor.getData());
				root.setRight(find(root.getRight(), successor.getData()));
			}
		}
		return root;
	}

	private static Node getInorderSuccessor(Node root) {
		Node currNode = root.getRight();
		while(currNode.getLeft() != null) {
			currNode = currNode.getLeft();
		}
		return currNode;
	}
	
}
