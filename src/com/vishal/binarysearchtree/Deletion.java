package com.vishal.binarysearchtree;

public class Deletion {

	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null){
			return root;
		}
		if(root.val == key){
			//If leave
			if(root.left == null && root.right == null){
				return null;
			}else if(root.right != null){
				//If right child present, find successor
				TreeNode successor = getSuccessor(root);
				root.val = successor.val;
				root.right = deleteNode(root.right, successor.val);
			}else{
				//If right child missing, find predecessor
				TreeNode predecessor = getPredecessor(root);
				root.val = predecessor.val;
				root.left = deleteNode(root.left, predecessor.val);
			}
		}else if(key > root.val){
			root.right = deleteNode(root.right, key);
		}else{
			root.left = deleteNode(root.left, key);
		}
		return root;
	}

	private TreeNode getSuccessor(TreeNode root){
		root = root.right;
		while(root.left != null){
			root = root.left;
		}
		return root;
	}

	private TreeNode getPredecessor(TreeNode root){
		root = root.left;
		while(root.right != null){
			root = root.right;
		}
		return root;
	}
	
}
