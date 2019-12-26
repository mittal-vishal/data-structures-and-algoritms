package com.vishal.binarytree;

public class MaxDiffNodeAndAncestor {
	
	private static Node rootNode = null;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		rootNode = new Node(8);
		rootNode.setLeft(new Node(3));
		rootNode.setRight(new Node(10));
		rootNode.getLeft().setLeft(new Node(1));
		rootNode.getLeft().setRight(new Node(6));
		rootNode.getLeft().getRight().setLeft(new Node(4));
		rootNode.getLeft().getRight().setRight(new Node(7));
		rootNode.getRight().setRight(new Node(14));
		rootNode.getRight().getRight().setLeft(new Node(13));
		System.out.println(find(rootNode));
	}

	private static int find(Node root) {
		if(root != null) {
			int leftT = find(root.getLeft());
			int rightT = find(root.getRight());
			if(root.getLeft() == null && root.getRight() == null) {
				return root.getData();
			}
			if(root.getData() - Math.min(leftT, rightT) > max) {
				max = root.getData() - Math.min(leftT, rightT);
			}
			if(root == rootNode)
				return max;
			else
				return Math.min(root.getData(), Math.min(leftT, rightT));
		}
		return Integer.MAX_VALUE;
	}

}
