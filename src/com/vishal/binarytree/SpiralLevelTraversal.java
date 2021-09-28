package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralLevelTraversal {
	
	private static TreeNode rootNode = null;

	public static void main(String[] args) {
		rootNode = new TreeNode(5);
		rootNode.setLeft(new TreeNode(2));
		rootNode.setRight(new TreeNode(25));
		rootNode.getLeft().setLeft(new TreeNode(1));
		rootNode.getLeft().setRight(new TreeNode(4));
		rootNode.getRight().setLeft(new TreeNode(13));
		rootNode.getRight().setRight(new TreeNode(40));
		rootNode.getLeft().getLeft().setLeft(new TreeNode(10));
		rootNode.getLeft().getLeft().setRight(new TreeNode(12));
		find(rootNode);
	}

	private static void find(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<>();
		queue.add(root);
		queue.add(null);
		int level = 1;
		while(!queue.isEmpty()) {
			if(queue.size() == 1 && queue.peek() == null) {
				break;
			}
			if(level % 2 == 1) {
				if(queue.peek() != null) {
					TreeNode item = queue.poll();
					stack.push(item);
					if(item.getLeft() != null) {
						queue.add(item.getLeft());
					}
					if(item.getRight() != null) {
						queue.add(item.getRight());
					}
				}else {
					queue.poll();
					queue.add(null);
					while(!stack.isEmpty()) {
						System.out.print(stack.pop().getData() + " ");
					}
					System.out.println();
					level++;
				}
			}else {
				if(queue.peek() != null) {
					TreeNode item = queue.poll();
					System.out.print(item.getData() + " ");
					if(item.getLeft() != null) {
						queue.add(item.getLeft());
					}
					if(item.getRight() != null) {
						queue.add(item.getRight());
					}
				}else {
					queue.poll();
					queue.add(null);
					System.out.println();
					level++;
				}
			}
		}
	}

}
