package com.vishal.binarysearchtree;

public class Deletion {

	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(20));
		rootNode.getRight().setLeft(new TreeNode(10));
		rootNode.getRight().setRight(new TreeNode(40));
		find(rootNode, 20);
		PreOrder.find(rootNode);
	}

	private static TreeNode find(TreeNode root, int item) {
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
				TreeNode successor = getInorderSuccessor(root);
				root.setData(successor.getData());
				root.setRight(find(root.getRight(), successor.getData()));
			}
		}
		return root;
	}

	private static TreeNode getInorderSuccessor(TreeNode root) {
		TreeNode currNode = root.getRight();
		while(currNode.getLeft() != null) {
			currNode = currNode.getLeft();
		}
		return currNode;
	}
	
}
