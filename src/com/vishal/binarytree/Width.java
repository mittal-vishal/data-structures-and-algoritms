package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Width {
	
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
		System.out.println(find(rootNode));
	}

	private static int find(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		TreeNode item = null;
		int size = -1;
		while(!queue.isEmpty()) {
		    if(queue.peek() == null && queue.size() == 1){
		        break;
		    }
			if(queue.peek() == null){
			    queue.poll();
			    if(queue.size() > size) {
			    	size = queue.size();
			    }
			    queue.add(null);
			}
			item = queue.poll();
			if(item.getLeft() != null) {
				queue.add(item.getLeft());
			}
			if(item.getRight() != null) {
				queue.add(item.getRight());
			}
		}
		return size;
	}
	
}
