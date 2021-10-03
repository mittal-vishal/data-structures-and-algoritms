package com.vishal.binarytree;

public class InorderSuccessor {

	private boolean isNext;
	private TreeNode successor;
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root == null){
			return null;
		}
		this.isNext = false;
		inorderTraversal(root, p);
		return successor;
	}

	private void inorderTraversal(TreeNode root, TreeNode p){
		if(root.left != null){
			inorderTraversal(root.left, p);
		}
		if(isNext){
			successor = root;
			isNext = false;
		}
		if(root.val == p.val){
			isNext = true;
		}
		if(root.right != null){
			inorderTraversal(root.right, p);
		}
	}

}
