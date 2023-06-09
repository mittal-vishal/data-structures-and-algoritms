package com.vishal.binarytree;

import java.util.*;

public class RightView {

private static TreeNode rootNode = null;
	
	public static void main(String[] args) {
		rootNode = new TreeNode(1);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(3));
		rootNode.getLeft().setLeft(new TreeNode(34));
		rootNode.getLeft().setRight(new TreeNode(4));
		rootNode.getRight().setLeft(new TreeNode(13));
		rootNode.getRight().setRight(new TreeNode(40));
		rootNode.getLeft().getLeft().setLeft(new TreeNode(10));
		rootNode.getLeft().getLeft().setRight(new TreeNode(12));
		RightView rightView = new RightView();
		List<Integer> rightViewList = rightView.rightSideView(rootNode);
		System.out.print(rightViewList);
	}

	public List<Integer> rightSideView(TreeNode root) {
		if(root == null){
			return new ArrayList<>();
		}
		List<Integer> results = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		TreeNode prev = null;
		while(!queue.isEmpty()){
			TreeNode curr = queue.poll();
			if(curr == null){
				if(prev != null){
					results.add(prev.val);
				}
				if(!queue.isEmpty()){
					queue.offer(null);
				}
			}else{
				if(curr.left != null){
					queue.offer(curr.left);
				}
				if(curr.right != null){
					queue.offer(curr.right);
				}
			}
			prev = curr;
		}
		return results;
	}
	
}
