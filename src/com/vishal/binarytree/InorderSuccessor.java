package com.vishal.binarytree;

public class InorderSuccessor {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(1);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(3));
		rootNode.getLeft().setLeft(new TreeNode(4));
		rootNode.getLeft().setRight(new TreeNode(5));
		rootNode.getRight().setLeft(new TreeNode(6));
		rootNode.getRight().setRight(new TreeNode(7));
		int num = 1;
		find(rootNode, num);
	}
	
	static class PreviousNode{
		TreeNode prevNode;
		public PreviousNode() {
			prevNode = null;
		}
	}

	private static void find(TreeNode root, int num) {
		find(root, num, new PreviousNode());
	}

	private static void find(TreeNode root, int num, PreviousNode previousNode) {
		if(root != null) {
			find(root.getRight(), num, previousNode);
			if(root.getVal() == num) {
				System.out.println(previousNode.prevNode.getVal());
			}
			previousNode.prevNode = root;
			find(root.getLeft(), num, previousNode);
		}
	}

}
