package com.vishal.binarytree;

public class NumberOfSubtreeWithSum {
	
	private static Node rootNode = null;
	private static int count = 0;

	public static void main(String[] args) {
		rootNode = new Node(5);
		rootNode.setLeft(new Node(-10));
		rootNode.setRight(new Node(3));
		rootNode.getLeft().setLeft(new Node(9));
		rootNode.getLeft().setRight(new Node(8));
		rootNode.getRight().setLeft(new Node(-4));
		rootNode.getRight().setRight(new Node(7));
		System.out.println(find(rootNode, 7));
	}

	private static int find(Node root, int sum) {
		if(root != null) {
			int leftT = find(root.getLeft(), sum);
			int rightT = find(root.getRight(), sum);
			if(root.getLeft() == null && root.getRight() == null && root.getData() == sum) {
				count++;
			}
			if(root.getLeft() == null && root.getRight() == null) {
				return root.getData();
			}
			if(leftT + rightT + root.getData() == sum) {
				count++;
			}
			if(root != rootNode) {
				return leftT + rightT + root.getData();
			}
		}
		return count;
	}
	
}
