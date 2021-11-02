package com.vishal.binarytree;

public class LowestCommonAncestor {

	private static TreeNode rootNode = null;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null){
			return null;
		}
		if(root == p || root == q){
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left != null && right != null){
			return root;
		}else{
			return left != null ? left: right;
		}
	}

}
