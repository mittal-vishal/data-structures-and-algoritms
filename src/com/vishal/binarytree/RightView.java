package com.vishal.binarytree;

import java.util.Deque;
import java.util.LinkedList;

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
		find(rootNode);
	}

	private static void find(TreeNode root) {
		Deque<TreeNode> queue = new LinkedList<>();
		if(root != null) {
			TreeNode popped = null;
			queue.add(root);
			queue.add(null);
			System.out.print(root.getData() + " ");
			while(!queue.isEmpty()) {
				popped = queue.poll();
				if(popped != null) {
					if(popped.getLeft() != null)
						queue.add(popped.getLeft());
					if(popped.getRight() != null)
						queue.add(popped.getRight());
				}else if(popped == null && queue.size() > 0) {
					System.out.print(queue.peekLast().getData() + " ");
					queue.add(null);
				}
			}
		}
	}
	
}
