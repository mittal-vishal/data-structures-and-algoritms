package com.vishal.binarysearchtree;

public class BstOrNot {

	private static TreeNode rootNode = null;
	
	static class Previous{
        private TreeNode prev;
    }

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.left = new TreeNode(5);
		BstOrNot bstOrNot = new BstOrNot();
		System.out.println(bstOrNot.isValidBST(rootNode));
		System.out.println(bstOrNot.isValidBSTree(rootNode));
	}

	private TreeNode prev;

	public boolean isValidBST(TreeNode root) {
		prev = null;
		return isValid(root);
	}

	private boolean isValid(TreeNode root){
		if(root == null){
			return true;
		}

		if(!isValid(root.left)){
			return false;
		}

		if(prev != null && prev.val >= root.val){
			return false;
		}

		prev = root;

		if(!isValid(root.right)){
			return false;
		}

		return true;
	}

	public boolean isValidBSTree(TreeNode root) {
		return validate(root, null, null);
	}

	private boolean validate(TreeNode root, Integer leftVal, Integer rightVal){
		if(root == null){
			return true;
		}
		if((leftVal != null && root.val <= leftVal) || (rightVal != null && root.val >= rightVal)){
			return false;
		}
		boolean isLeftBST = validate(root, leftVal, root.val);
		boolean isRightBST = validate(root.right, root.val, rightVal);
		return isLeftBST && isRightBST;
	}

}
