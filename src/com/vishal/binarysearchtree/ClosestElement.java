package com.vishal.binarysearchtree;

public class ClosestElement {

	private int closestEle;
	private double closestVal;

	public int closestValue(TreeNode root, double target) {
		closestVal = Integer.MAX_VALUE;
		inorder(root, target);
		return closestEle;
	}

	private void inorder(TreeNode root, double target){
		if(root == null){
			return;
		}
		inorder(root.left, target);
		if(Math.abs(target - root.val) < closestVal){
			closestVal = Math.abs(target - root.val);
			closestEle = root.val;
		}
		inorder(root.right, target);
	}
	
}
