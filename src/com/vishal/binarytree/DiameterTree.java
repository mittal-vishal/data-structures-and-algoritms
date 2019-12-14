package com.vishal.binarytree;

public class DiameterTree {

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
		System.out.println(find(rootNode));
	}

	private static int find(Node root) {
		int diameter = 0;
		if(root == null) {
			return 0;
		}else {
			int leftT = height(root.getLeft());
			int rightT = height(root.getRight());
			if(leftT + rightT + 1 > diameter) {
				diameter = leftT + rightT + 1;
			}
		}
		int leftT = find(root.getLeft());
		int right = find(root.getRight());
		if((leftT > right ? leftT : right) > diameter) {
			diameter = leftT > right ? leftT : right;
		}
		return diameter;
	}

	private static int height(Node root) {
		if(root == null) {
			return 0;
		}else {
			int left = height(root.getLeft());
			int right = height(root.getRight());
			return (left > right ? left : right) + 1;
		}
	}
	
}
