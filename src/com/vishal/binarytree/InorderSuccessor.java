package com.vishal.binarytree;

public class InorderSuccessor {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(1);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(new Node(3));
		rootNode.getLeft().setLeft(new Node(4));
		rootNode.getLeft().setRight(new Node(5));
		rootNode.getRight().setLeft(new Node(6));
		rootNode.getRight().setRight(new Node(7));
		int num = 1;
		find(rootNode, num);
	}
	
	static class PreviousNode{
		Node prevNode;
		public PreviousNode() {
			prevNode = null;
		}
	}

	private static void find(Node root, int num) {
		find(root, num, new PreviousNode());
	}

	private static void find(Node root, int num, PreviousNode previousNode) {
		if(root != null) {
			find(root.getRight(), num, previousNode);
			if(root.getData() == num) {
				System.out.println(previousNode.prevNode.getData());
			}
			previousNode.prevNode = root;
			find(root.getLeft(), num, previousNode);
		}
	}

}
