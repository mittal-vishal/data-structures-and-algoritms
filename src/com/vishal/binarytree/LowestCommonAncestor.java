package com.vishal.binarytree;

public class LowestCommonAncestor {

	private static Node rootNode = null;

	public static void main(String[] args) {
		rootNode = new Node(5);
		rootNode.setLeft(new Node(2));
		rootNode.setRight(null);
		rootNode.getLeft().setLeft(new Node(1));
		rootNode.getLeft().setRight(new Node(10));
		System.out.println(find(rootNode, 1, 10).getData());
	}

	private static Node find(Node node, int n1, int n2) {
		if (node == null)
			return null;

		if (node.getData() == n1 || node.getData() == n2)
			return node;

		Node left = find(node.getLeft(), n1, n2);
		Node right = find(node.getRight(), n1, n2);

		if (left != null && right != null)
			return node;
		
		return left != null ? left : right;
	}

}
