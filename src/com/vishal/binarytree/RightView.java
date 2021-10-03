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
		List<Integer> rightViewList = new ArrayList<>();

		if(root == null){
			return rightViewList;
		}

		List<Integer> levelList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		while(!queue.isEmpty()){
			TreeNode polled = queue.poll();
			if(polled == null){
				rightViewList.add(levelList.get(levelList.size()-1));
				levelList = new ArrayList<>();
				if(queue.size() > 0){
					queue.offer(null);
				}
			}else{
				levelList.add(polled.val);
				if(polled.left != null){
					queue.offer(polled.left);
				}
				if(polled.right != null){
					queue.offer(polled.right);
				}
			}
		}

		return rightViewList;
	}
	
}
