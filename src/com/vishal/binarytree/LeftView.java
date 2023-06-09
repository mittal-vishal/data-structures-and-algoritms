package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {
	
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
		LeftView leftView = new LeftView();
		List<Integer>leftViewList = leftView.leftView(rootNode);
		System.out.print(leftViewList);
	}

	private ArrayList<Integer> leftView(TreeNode root){
		ArrayList<Integer> results = new ArrayList<>();
		if(root == null){
			return results;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		results.add(root.val);
		boolean isFirstNode = false;
		while(!queue.isEmpty()){
			TreeNode curr = queue.poll();
			if(isFirstNode){
				results.add(curr.val);
			}
			if(curr == null){
				isFirstNode = true;
				if(!queue.isEmpty()){
					queue.offer(null);
				}
			}else{
				isFirstNode = false;
				if(curr.left != null){
					queue.offer(curr.left);
				}
				if(curr.right != null){
					queue.offer(curr.right);
				}
			}
		}
		return results;
	}

}
